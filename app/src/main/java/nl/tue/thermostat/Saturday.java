package nl.tue.thermostat;
//
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

public class Saturday extends AppCompatActivity {

    EditText day1satur, day2satur, day3satur, day4satur, day5satur, night1satur, night2satur, night3satur,
            night4satur, night5satur;

    Switch switchday1satur, switchday2satur, switchday3satur, switchday4satur, switchday5satur,
            switchnight1satur, switchnight2satur, switchnight3satur, switchnight4satur, switchnight5satur;

    int days = 1;
    int nights = 1;

    String time, time1, time2, time3, time4, time5, time6, time7, time8, time9, time10,
            type;
    Boolean state, state1, state2, state3, state4, state5, state6, state7, state8, state9, state10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturday);
        Button backtemp = (Button) findViewById(R.id.backtemp);
        backtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        Button settimesat = (Button) findViewById(R.id.settimesat);

        switchday1satur = (Switch) findViewById(R.id.switchday1satur);
        switchday2satur = (Switch) findViewById(R.id.switchday2satur);
        switchday3satur = (Switch) findViewById(R.id.switchday3satur);
        switchday4satur = (Switch) findViewById(R.id.switchday4satur);
        switchday5satur = (Switch) findViewById(R.id.switchday5satur);
        switchnight1satur = (Switch) findViewById(R.id.switchnight1satur);
        switchnight2satur = (Switch) findViewById(R.id.switchnight2satur);
        switchnight3satur = (Switch) findViewById(R.id.switchnight3satur);
        switchnight4satur = (Switch) findViewById(R.id.switchnight4satur);
        switchnight5satur = (Switch) findViewById(R.id.switchnight5satur);

        new Thread(new Runnable() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                try {
                    // Get the week program
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    ArrayList<SwitchHS> wpgm = wpg.data.get("Saturday");
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
                    day1satur.post(new Runnable() {
                        @Override
                        public void run() {
                            day1satur.setText(time1);
                            day2satur.setText(time2);
                            day3satur.setText(time3);
                            day4satur.setText(time4);
                            day5satur.setText(time5);
                            switchday1satur.setChecked(state1);
                            switchday2satur.setChecked(state2);
                            switchday3satur.setChecked(state3);
                            switchday4satur.setChecked(state4);
                            switchday5satur.setChecked(state5);
                            night1satur.setText(time6);
                            night2satur.setText(time7);
                            night3satur.setText(time8);
                            night4satur.setText(time9);
                            night5satur.setText(time10);
                            switchnight1satur.setChecked(state6);
                            switchnight2satur.setChecked(state7);
                            switchnight3satur.setChecked(state8);
                            switchnight4satur.setChecked(state9);
                            switchnight5satur.setChecked(state10);
                        }
                    });
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        }).start();

        settimesat.setOnClickListener(new View.OnClickListener(){
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
                            wpg.data.get("Saturday").set(0, new SwitchHS("night", switchnight1satur.isChecked(), night1satur.getText().toString()));
                            wpg.data.get("Saturday").set(1, new SwitchHS("night", switchnight2satur.isChecked(), night2satur.getText().toString()));
                            wpg.data.get("Saturday").set(2, new SwitchHS("night", switchnight3satur.isChecked(), night3satur.getText().toString()));
                            wpg.data.get("Saturday").set(3, new SwitchHS("night", switchnight4satur.isChecked(), night4satur.getText().toString()));
                            wpg.data.get("Saturday").set(4, new SwitchHS("night", switchnight5satur.isChecked(), night5satur.getText().toString()));
                            wpg.data.get("Saturday").set(5, new SwitchHS("day", switchday1satur.isChecked(), day1satur.getText().toString()));
                            wpg.data.get("Saturday").set(6, new SwitchHS("day", switchday2satur.isChecked(), day2satur.getText().toString()));
                            wpg.data.get("Saturday").set(7, new SwitchHS("day", switchday3satur.isChecked(), day3satur.getText().toString()));
                            wpg.data.get("Saturday").set(8, new SwitchHS("day", switchday4satur.isChecked(), day4satur.getText().toString()));
                            wpg.data.get("Saturday").set(9, new SwitchHS("day", switchday5satur.isChecked(), day5satur.getText().toString()));
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
        day1satur = (EditText) findViewById(R.id.day1satur);
        day1satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day1satur); // show dialog
            }
        });

        day2satur = (EditText) findViewById(R.id.day2satur);
        day2satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day2satur); // show dialog
            }
        });

        day3satur = (EditText) findViewById(R.id.day3satur);
        day3satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day3satur); // show dialog
            }
        });

        day4satur = (EditText) findViewById(R.id.day4satur);
        day4satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day4satur); // show dialog
            }
        });

        day5satur = (EditText) findViewById(R.id.day5satur);
        day5satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day5satur); // show dialog
            }
        });

        night1satur = (EditText) findViewById(R.id.night1satur);
        night1satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night1satur); // show dialog
            }
        });

        night2satur = (EditText) findViewById(R.id.night2satur);
        night2satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night2satur); // show dialog
            }
        });

        night3satur = (EditText) findViewById(R.id.night3satur);
        night3satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night3satur); // show dialog
            }
        });

        night4satur = (EditText) findViewById(R.id.night4satur);
        night4satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night4satur); // show dialog
            }
        });

        night5satur = (EditText) findViewById(R.id.night5satur);
        night5satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night5satur); // show dialog
            }
        });

    }

    //clock dialig
    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}