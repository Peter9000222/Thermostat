package nl.tue.thermostat;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import org.thermostatapp.util.HeatingSystem;
import org.thermostatapp.util.SwitchHS;
import org.thermostatapp.util.WeekProgram;

import java.util.ArrayList;

public class Thursday extends AppCompatActivity {

    EditText day1thurs, day2thurs, day3thurs, day4thurs, day5thurs, night1thurs, night2thurs, night3thurs,
            night4thurs, night5thurs;

    Switch switchday1thurs, switchday2thurs, switchday3thurs, switchday4thurs, switchday5thurs,
            switchnight1thurs, switchnight2thurs, switchnight3thurs, switchnight4thurs, switchnight5thurs;

    int days = 1;
    int nights = 1;

    String time, time1, time2, time3, time4, time5, time6, time7, time8, time9, time10,
            type;
    Boolean state, state1, state2, state3, state4, state5, state6, state7, state8, state9, state10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);
        Button backtemp = (Button) findViewById(R.id.backtemp);
        backtemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        Button settimethurs = (Button) findViewById(R.id.settimethurs);

        switchday1thurs = (Switch) findViewById(R.id.switchday1thurs);
        switchday2thurs = (Switch) findViewById(R.id.switchday2thurs);
        switchday3thurs = (Switch) findViewById(R.id.switchday3thurs);
        switchday4thurs = (Switch) findViewById(R.id.switchday4thurs);
        switchday5thurs = (Switch) findViewById(R.id.switchday5thurs);
        switchnight1thurs = (Switch) findViewById(R.id.switchnight1thurs);
        switchnight2thurs = (Switch) findViewById(R.id.switchnight2thurs);
        switchnight3thurs = (Switch) findViewById(R.id.switchnight3thurs);
        switchnight4thurs = (Switch) findViewById(R.id.switchnight4thurs);
        switchnight5thurs = (Switch) findViewById(R.id.switchnight5thurs);

        new Thread(new Runnable() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                try {
                    // Get the week program
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    ArrayList<SwitchHS> wpgm = wpg.data.get("Thursday");
                    // set the right varibles for the times and states
                    for (int i = 0; i < 10; i++) {
                        time = wpgm.get(i).getTime();
                        state = wpgm.get(i).getState();
                        type = wpgm.get(i).getType();
                        if (type.equals("day")) {
                            if (days == 1) {
                                time10 = time;
                                state10 = state;
                            } else if (days == 2) {
                                time9 = time;
                                state9 = state;
                            } else if (days == 3) {
                                time8 = time;
                                state8 = state;
                            } else if (days == 4) {
                                time7 = time;
                                state7 = state;
                            } else if (days == 5) {
                                time6 = time;
                                state6 = state;
                            }
                            days++;
                        } else if (type.equals("night")) {
                            if (nights == 1) {
                                time5 = time;
                                state5 = state;
                            } else if (nights == 2) {
                                time4 = time;
                                state4 = state;
                            } else if (nights == 3) {
                                time3 = time;
                                state3 = state;
                            } else if (nights == 4) {
                                time2 = time;
                                state2 = state;
                            } else if (nights == 5) {
                                time1 = time;
                                state1 = state;
                            }
                            nights++;
                        }
                    }
                    // make sure the time and state variables are displayed
                    day1thurs.post(new Runnable() {
                        @Override
                        public void run() {
                            day1thurs.setText(time10);
                            day2thurs.setText(time9);
                            day3thurs.setText(time8);
                            day4thurs.setText(time7);
                            day5thurs.setText(time6);
                            switchday1thurs.setChecked(state10);
                            switchday2thurs.setChecked(state9);
                            switchday3thurs.setChecked(state8);
                            switchday4thurs.setChecked(state7);
                            switchday5thurs.setChecked(state6);
                            night1thurs.setText(time5);
                            night2thurs.setText(time4);
                            night3thurs.setText(time3);
                            night4thurs.setText(time2);
                            night5thurs.setText(time1);
                            switchnight1thurs.setChecked(state5);
                            switchnight2thurs.setChecked(state4);
                            switchnight3thurs.setChecked(state3);
                            switchnight4thurs.setChecked(state2);
                            switchnight5thurs.setChecked(state1);
                        }
                    });
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        }).start();

        settimethurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        try {
                            // Get the week program
                            WeekProgram wpg = HeatingSystem.getWeekProgram();
                            // Set the week program to default
                            wpg.data.get("Thursday").set(0, new SwitchHS("night", switchnight1thurs.isChecked(), night1thurs.getText().toString()));
                            wpg.data.get("Thursday").set(1, new SwitchHS("night", switchnight2thurs.isChecked(), night2thurs.getText().toString()));
                            wpg.data.get("Thursday").set(2, new SwitchHS("night", switchnight3thurs.isChecked(), night3thurs.getText().toString()));
                            wpg.data.get("Thursday").set(3, new SwitchHS("night", switchnight4thurs.isChecked(), night4thurs.getText().toString()));
                            wpg.data.get("Thursday").set(4, new SwitchHS("night", switchnight5thurs.isChecked(), night5thurs.getText().toString()));
                            wpg.data.get("Thursday").set(5, new SwitchHS("day", switchday1thurs.isChecked(), day1thurs.getText().toString()));
                            wpg.data.get("Thursday").set(6, new SwitchHS("day", switchday2thurs.isChecked(), day2thurs.getText().toString()));
                            wpg.data.get("Thursday").set(7, new SwitchHS("day", switchday3thurs.isChecked(), day3thurs.getText().toString()));
                            wpg.data.get("Thursday").set(8, new SwitchHS("day", switchday4thurs.isChecked(), day4thurs.getText().toString()));
                            wpg.data.get("Thursday").set(9, new SwitchHS("day", switchday5thurs.isChecked(), day5thurs.getText().toString()));
                            //Upload the updated program
                            HeatingSystem.setWeekProgram(wpg);
                        } catch (Exception e) {
                            System.err.println("Error from getdata " + e);
                        }
                    }
                }).start();
                Toast.makeText(getApplicationContext(),
                        "Times and switches are set.", Toast.LENGTH_LONG).show();
            }
        });

        //clocks
        day1thurs = (EditText) findViewById(R.id.day1thurs);
        day1thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day1thurs); // show dialog
            }
        });

        day2thurs = (EditText) findViewById(R.id.day2thurs);
        day2thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day2thurs); // show dialog
            }
        });

        day3thurs = (EditText) findViewById(R.id.day3thurs);
        day3thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day3thurs); // show dialog
            }
        });

        day4thurs = (EditText) findViewById(R.id.day4thurs);
        day4thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day4thurs); // show dialog
            }
        });

        day5thurs = (EditText) findViewById(R.id.day5thurs);
        day5thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day5thurs); // show dialog
            }
        });

        night1thurs = (EditText) findViewById(R.id.night1thurs);
        night1thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night1thurs); // show dialog
            }
        });

        night2thurs = (EditText) findViewById(R.id.night2thurs);
        night2thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night2thurs); // show dialog
            }
        });

        night3thurs = (EditText) findViewById(R.id.night3thurs);
        night3thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night3thurs); // show dialog
            }
        });

        night4thurs = (EditText) findViewById(R.id.night4thurs);
        night4thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night4thurs); // show dialog
            }
        });

        night5thurs = (EditText) findViewById(R.id.night5thurs);
        night5thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night5thurs); // show dialog
            }
        });

    }

    //clock dialog
    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}


