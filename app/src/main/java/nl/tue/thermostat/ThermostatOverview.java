package nl.tue.thermostat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import org.thermostatapp.util.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

public class ThermostatOverview extends AppCompatActivity {

    int stemp;                  // value for temperature
    TextView temp;              // temp display
    SeekBar tempbar;            // process bar
    View view;
    Button bweekprogram, bsetprogram;
    Boolean on = false;         // state is set to false by default for week program button
    Drawable weekon;            // layout program on
    Drawable weekoff;           // layout program off
    double currentTemp;         // value for temp
    TextView currentTempText;   // Text for current temperature

    //control window
    TimerTask taskTime;
    String getcurrentTemperature;
    TextView currentTime;
    Timer timer = new Timer();

    // current temp
    int clockcurrentTemp = 2000;        // time in miliseconds 1000 is 1 second

    //program switch
    String getParamProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Locale locale = new Locale("nl");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.activity_thermostat_overview);
        // server addresses
        HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/19";
        HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";

        // server week program switch
        getParamProgram = "";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getParamProgram  = HeatingSystem.get("weekProgramState");   // get program state
                    currentTime.setText(getParamProgram);                       // set program state to string
                    if (getParamProgram.equals("off")) {                        // if program state is "off"
                        bweekprogram.setBackground(weekoff);                    // set program button layout to off
                        bweekprogram.setText("Week program is off");               // set program button text to "off"
                        bweekprogram.setPaintFlags(0);
                        on = false;                                             // remember state
                    } else {                                                    // if program state is "on"
                        bweekprogram.setBackground(weekon);                     // set program button layout to on
                        bweekprogram.setText("Week program is on");
                        bweekprogram.setPaintFlags(bweekprogram.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); // set program button text to "on"
                        on = true;                                              // remember state
                    }
                } catch (Exception e) {                                         // catch error, always add this !!
                    System.err.println("Error from getdata "+e);
                }
            }
        }).start();

        // temp display
        // set display to current temp of system
        temp = (TextView) findViewById(R.id.temp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getcurrentTemperature  = HeatingSystem.get("targetTemperature");
                    currentTemp = Double.parseDouble(getcurrentTemperature) * 10;
                    stemp = (int)currentTemp;
                    int number = stemp/10;
                    int decimal = stemp%10;
                    temp.setText(number + ","+ decimal + " \u2103");
                    tempbar.setProgress(stemp);
                } catch (Exception e) {                                         // catch error, always add this !!
                    System.err.println("Error from getdata "+e);
                }
            }
        }).start();

        // set programs button
        bsetprogram = (Button) findViewById(R.id.bsetprogram);
        bsetprogram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                timer.cancel();
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);

            }
        });

        // temp bar sets progress to server and display
        tempbar = (SeekBar) findViewById(R.id.tempbar);
        tempbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int  progress, boolean fromUser) {
                if (progress < 50) {
                    progress = 50;
                    // put progress to server
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                HeatingSystem.put("targetTemperature", "5.0");
                            } catch (Exception e) {
                                System.err.println("Error from getdata " + e);
                            }
                        }}).start();
                    // display progess temp in display
                    stemp = progress;
                    temp.setText("5,0 \u2103");
                    tempbar.setProgress(progress);
                } else {
                    stemp = progress;
                    // values to rewirte stemp to server format
                    double server = (double)stemp / 10;
                    final String tserver = Double.toString(server);
                    // putt progess to server
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                HeatingSystem.put("targetTemperature", tserver);
                            } catch (Exception e) {
                                System.err.println("Error from getdata " + e);
                            }
                        }}).start();
                    // rewrite stemp to format of display and display progress on display
                    int number = stemp/10;
                    int decimal = stemp%10;
                    temp.setText(number + ","+ decimal + " \u2103");
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}});

        // temp + button
        Button bplus = (Button) findViewById(R.id.bplus);
        bplus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // values to rewrite temp to display format
                stemp = (stemp + 1);
                int number = stemp/10;
                int decimal = stemp%10;
                if (stemp > 300) {
                    stemp = 300;
                    temp.setText("30,0 \u2103");
                    tempbar.setProgress(stemp);
                    burn(view);
                    // put temp to server
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                HeatingSystem.put("targetTemperature", "30.0");
                            } catch (Exception e) {
                                System.err.println("Error from getdata " + e);
                            }
                        }}).start();
                } else {
                    // rewrite temp for server format
                    double server = (double)stemp;
                    double tempserver = server / 10;
                    final String tserver = Double.toString(tempserver);
                    // put temp to server
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                HeatingSystem.put("targetTemperature", tserver);
                            } catch (Exception e) {
                                System.err.println("Error from getdata " + e);
                            }
                        }}).start();
                    // display temp on display
                    temp.setText(number + ","+ decimal + " \u2103");
                    tempbar.setProgress(stemp);
                }
            }
        });

        // temp - button
        Button bminus = (Button) findViewById(R.id.bminus);
        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stemp = (stemp - 1);
                if (stemp<50) {
                    freeze(view);
                }
                // rewrite temp for server format
                double server = (double)stemp;
                double tempserver = server / 10;
                final String tserver = Double.toString(tempserver);
                // put temp to server
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            HeatingSystem.put("targetTemperature", tserver);
                        } catch (Exception e) {
                            System.err.println("Error from getdata " + e);
                        }
                    }}).start();
                // values to rewrite temp to display format
                int number = stemp/10;
                int decimal = stemp%10;
                // display temp on display
                temp.setText(number + ","+ decimal + " \u2103");
                tempbar.setProgress(stemp);
            }
        });

        // week program button (program switch)
        bweekprogram = (Button) findViewById(R.id.bweekprogram);
        Resources res = getResources();
        weekon = res.getDrawable(R.drawable.on);                                 // layout on
        weekoff = res.getDrawable(R.drawable.off);                               // layout off
        bweekprogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (on == false) {                                               // current state of week program is off
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                        try {
                          HeatingSystem.put("weekProgramState", "on");           // set program state to on
                        } catch (Exception e) {
                            System.err.println("Error from getdata " + e);
                        }
                    }}).start();
                    bweekprogram.setText("Week program is on");                     // set program button text to "off"
                    bweekprogram.setBackground(weekon);                          // set program button layout to on
                    bweekprogram.setPaintFlags(bweekprogram.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                    on = true;
                }
                else {                                                           // current state of week program is on
                    new Thread(new Runnable() {
                         @Override
                         public void run() {
                         try {
                            HeatingSystem.put("weekProgramState", "off");       // set program state to off
                         } catch (Exception e) {
                              System.err.println("Error from getdata " + e);
                         }
                    }}).start();
                    bweekprogram.setText("Week program is off");                   // set program button text to "on"
                    bweekprogram.setBackground(weekoff);                        // set program button layout to off
                    bweekprogram.setPaintFlags(0);
                    on = false;
                }
            }
        });

        // current temperature text
        currentTempText = (TextView) findViewById(R.id.currentTempText);

        // control window temps
        currentTime = (TextView) findViewById(R.id.currentTime);
        taskTime = new TimerTask() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            getcurrentTemperature = HeatingSystem.get("currentTemperature");
                            currentTemp = Double.parseDouble(getcurrentTemperature) * 10;
                            stemp = (int)currentTemp;
                            currentTime.post(new Runnable() {
                                @Override
                                public void run() {
                                    currentTime.setText(getcurrentTemperature);
                                }
                            });
                        } catch (Exception e) {
                            System.err.println("Error from getdata "+e);
                        }
                    }
                }).start();
            }
        };
        timer.schedule(taskTime, 0, clockcurrentTemp);
    }

    // freeze message
    public void freeze(View view) {
        AlertDialog.Builder freeze = new AlertDialog.Builder(this);
        freeze.setMessage("Do not freeze the pipes!! The minimum temperature is 5,0 \u2103")
                .setTitle("Warning!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        freeze.show();
    }
    // burn message
    public void burn(View view) {
        AlertDialog.Builder burn = new AlertDialog.Builder(this);
        burn.setMessage("Do not burn the pipes!! The maximum temperature is 30,0 \u2103")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setTitle("Warning!")
                .create();
        burn.show();
    }
}
