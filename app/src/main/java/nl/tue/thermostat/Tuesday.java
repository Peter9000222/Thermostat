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

public class Tuesday extends AppCompatActivity {

    EditText day1tues, day2tues, day3tues, day4tues, day5tues, night1tues, night2tues, night3tues, night4tues, night5tues;

    Switch switchday1tues, switchday2tues, switchday3tues, switchday4tues, switchday5tues,
            switchnight1tues, switchnight2tues, switchnight3tues, switchnight4tues, switchnight5tues;

    int days = 1;
    int nights = 1;

    String time, time1, time2, time3, time4, time5, time6, time7, time8, time9, time10,
            type;
    Boolean state, state1, state2, state3, state4, state5, state6, state7, state8, state9, state10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);
        Button backtemp = (Button) findViewById(R.id.backtemp);
        backtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        Button settimetues = (Button) findViewById(R.id.settimetues);

        switchday1tues = (Switch) findViewById(R.id.switchday1tues);
        switchday2tues = (Switch) findViewById(R.id.switchday2tues);
        switchday3tues = (Switch) findViewById(R.id.switchday3tues);
        switchday4tues = (Switch) findViewById(R.id.switchday4tues);
        switchday5tues = (Switch) findViewById(R.id.switchday5tues);
        switchnight1tues = (Switch) findViewById(R.id.switchnight1tues);
        switchnight2tues = (Switch) findViewById(R.id.switchnight2tues);
        switchnight3tues = (Switch) findViewById(R.id.switchnight3tues);
        switchnight4tues = (Switch) findViewById(R.id.switchnight4tues);
        switchnight5tues = (Switch) findViewById(R.id.switchnight5tues);

        new Thread(new Runnable() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                try {
                    // Get the week program
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    ArrayList<SwitchHS> wpgm = wpg.data.get("Tuesday");
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
                    day1tues.post(new Runnable() {
                        @Override
                        public void run() {
                            day1tues.setText(time1);
                            day2tues.setText(time2);
                            day3tues.setText(time3);
                            day4tues.setText(time4);
                            day5tues.setText(time5);
                            switchday1tues.setChecked(state1);
                            switchday2tues.setChecked(state2);
                            switchday3tues.setChecked(state3);
                            switchday4tues.setChecked(state4);
                            switchday5tues.setChecked(state5);
                            night1tues.setText(time6);
                            night2tues.setText(time7);
                            night3tues.setText(time8);
                            night4tues.setText(time9);
                            night5tues.setText(time10);
                            switchnight1tues.setChecked(state6);
                            switchnight2tues.setChecked(state7);
                            switchnight3tues.setChecked(state8);
                            switchnight4tues.setChecked(state9);
                            switchnight5tues.setChecked(state10);
                        }
                    });
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        }).start();

        settimetues.setOnClickListener(new View.OnClickListener() {
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
                            wpg.data.get("Tuesday").set(0, new SwitchHS("night", switchnight1tues.isChecked(), night1tues.getText().toString()));
                            wpg.data.get("Tuesday").set(1, new SwitchHS("night", switchnight2tues.isChecked(), night2tues.getText().toString()));
                            wpg.data.get("Tuesday").set(2, new SwitchHS("night", switchnight3tues.isChecked(), night3tues.getText().toString()));
                            wpg.data.get("Tuesday").set(3, new SwitchHS("night", switchnight4tues.isChecked(), night4tues.getText().toString()));
                            wpg.data.get("Tuesday").set(4, new SwitchHS("night", switchnight5tues.isChecked(), night5tues.getText().toString()));
                            wpg.data.get("Tuesday").set(5, new SwitchHS("day", switchday1tues.isChecked(), day1tues.getText().toString()));
                            wpg.data.get("Tuesday").set(6, new SwitchHS("day", switchday2tues.isChecked(), day2tues.getText().toString()));
                            wpg.data.get("Tuesday").set(7, new SwitchHS("day", switchday3tues.isChecked(), day3tues.getText().toString()));
                            wpg.data.get("Tuesday").set(8, new SwitchHS("day", switchday4tues.isChecked(), day4tues.getText().toString()));
                            wpg.data.get("Tuesday").set(9, new SwitchHS("day", switchday5tues.isChecked(), day5tues.getText().toString()));
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
        day1tues = (EditText) findViewById(R.id.day1tues);
        day1tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day1tues); // show dialog
            }
        });

        day2tues = (EditText) findViewById(R.id.day2tues);
        day2tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day2tues); // show dialog
            }
        });

        day3tues = (EditText) findViewById(R.id.day3tues);
        day3tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day3tues); // show dialog
            }
        });

        day4tues = (EditText) findViewById(R.id.day4tues);
        day4tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day4tues); // show dialog
            }
        });

        day5tues = (EditText) findViewById(R.id.day5tues);
        day5tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day5tues); // show dialog
            }
        });

        night1tues = (EditText) findViewById(R.id.night1tues);
        night1tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night1tues); // show dialog
            }
        });

        night2tues = (EditText) findViewById(R.id.night2tues);
        night2tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night2tues); // show dialog
            }
        });

        night3tues = (EditText) findViewById(R.id.night3tues);
        night3tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night3tues); // show dialog
            }
        });

        night4tues = (EditText) findViewById(R.id.night4tues);
        night4tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night4tues); // show dialog
            }
        });

        night5tues = (EditText) findViewById(R.id.night5tues);
        night5tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night5tues); // show dialog
            }
        });
    }

    //clock dialog
    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}
