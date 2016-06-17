package nl.tue.thermostat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.thermostatapp.util.HeatingSystem;

public class SetTemperature extends AppCompatActivity {

    String getDayTemp,getNightTemp,chosenDayTemp, chosenNightTemp;
    EditText daytemp, nighttemp;
    double ddaytemp,dnighttemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_temperature);
        HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/19";

        Button backtemp = (Button) findViewById(R.id.backtemp);
        backtemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        daytemp = (EditText) findViewById(R.id.daytemp);
        nighttemp = (EditText) findViewById(R.id.nighttemp);
        //getDayTemp = "";
        //getNightTemp = "";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getDayTemp  = HeatingSystem.get("dayTemperature");
                    daytemp.setText(getDayTemp);
                    System.out.println(getDayTemp);
                   // getNightTemp = HeatingSystem.get("nightTemperature");
                   // nighttemp.setText(getNightTemp);
                   // System.out.println(getNightTemp);
                } catch (Exception e) {                                         // catch error, always add this !!
                    System.err.println("Error from getdata "+e);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //getDayTemp  = HeatingSystem.get("dayTemperature");
                    //daytemp.setText(getDayTemp);
                    //System.out.println(getDayTemp);
                    getNightTemp = HeatingSystem.get("nightTemperature");
                    nighttemp.setText(getNightTemp);
                    System.out.println(getNightTemp);
                } catch (Exception e) {                                         // catch error, always add this !!
                    System.err.println("Error from getdata "+e);
                }
            }
        }).start();

        Button settemp = (Button) findViewById(R.id.settempdaynight);
        settemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                chosenDayTemp = daytemp.getText().toString();
                ddaytemp = Double.parseDouble(chosenDayTemp);
                if (ddaytemp < 5.0) {
                    invalidInput(view, "day");
                } else if (ddaytemp > 30.0) {
                    invalidInput(view, "day");
                }
                chosenNightTemp = nighttemp.getText().toString();
                dnighttemp = Double.parseDouble(chosenNightTemp);
                if (dnighttemp < 5.0) {
                    invalidInput(view, "night");
                } else if (dnighttemp > 30.0) {
                    invalidInput(view, "night");
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            HeatingSystem.put("dayTemperature", chosenDayTemp);
                        } catch (Exception e) {                                         // catch error, always add this !!
                            System.err.println("Error from getdata "+e);
                        }
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            HeatingSystem.put("nightTemperature", chosenNightTemp);
                        } catch (Exception e) {                                         // catch error, always add this !!
                            System.err.println("Error from getdata "+e);
                        }
                    }
                }).start();
                Toast.makeText(getApplicationContext(),
                        "Temperatures are set.", Toast.LENGTH_LONG).show();
            }
        });
    }

    // burn message
    public void invalidInput(View view, String invalid) {
        AlertDialog.Builder invalidInput = new AlertDialog.Builder(this);
        invalidInput.setMessage("Invalid input for " + invalid + " temperature!! " +
                "Please insert a temperature between 5,0 \u2103 and 30,0 \u2103.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setTitle("Invalid input!")
                .create();
        invalidInput.show();
    }
}
