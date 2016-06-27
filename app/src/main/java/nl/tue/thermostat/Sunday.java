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

public class Sunday extends AppCompatActivity {

    EditText day1sun, day2sun, day3sun, day4sun, day5sun, night1sun, night2sun, night3sun,
            night4sun, night5sun;

    Switch switchday1sun, switchday2sun, switchday3sun, switchday4sun, switchday5sun,
            switchnight1sun, switchnight2sun, switchnight3sun, switchnight4sun, switchnight5sun;

    int days = 1;
    int nights = 1;

    String time, time1, time2, time3, time4, time5, time6, time7, time8, time9, time10,
            type;
    Boolean state, state1, state2, state3, state4, state5, state6, state7, state8, state9, state10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunday);
        Button backtemp = (Button) findViewById(R.id.backtemp);
        backtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        Button settimesun = (Button) findViewById(R.id.settimesun);

        switchday1sun = (Switch) findViewById(R.id.switchday1sun);
        switchday2sun = (Switch) findViewById(R.id.switchday2sun);
        switchday3sun = (Switch) findViewById(R.id.switchday3sun);
        switchday4sun = (Switch) findViewById(R.id.switchday4sun);
        switchday5sun = (Switch) findViewById(R.id.switchday5sun);
        switchnight1sun = (Switch) findViewById(R.id.switchnight1sun);
        switchnight2sun = (Switch) findViewById(R.id.switchnight2sun);
        switchnight3sun = (Switch) findViewById(R.id.switchnight3sun);
        switchnight4sun = (Switch) findViewById(R.id.switchnight4sun);
        switchnight5sun = (Switch) findViewById(R.id.switchnight5sun);

        new Thread(new Runnable() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                try {
                    // Get the week program
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    ArrayList<SwitchHS> wpgm = wpg.data.get("Sunday");
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
                    day1sun.post(new Runnable() {
                        @Override
                        public void run() {
                            day1sun.setText(time10);
                            day2sun.setText(time9);
                            day3sun.setText(time8);
                            day4sun.setText(time7);
                            day5sun.setText(time6);
                            switchday1sun.setChecked(state10);
                            switchday2sun.setChecked(state9);
                            switchday3sun.setChecked(state8);
                            switchday4sun.setChecked(state7);
                            switchday5sun.setChecked(state6);
                            night1sun.setText(time5);
                            night2sun.setText(time4);
                            night3sun.setText(time3);
                            night4sun.setText(time2);
                            night5sun.setText(time1);
                            switchnight1sun.setChecked(state5);
                            switchnight2sun.setChecked(state4);
                            switchnight3sun.setChecked(state3);
                            switchnight4sun.setChecked(state2);
                            switchnight5sun.setChecked(state1);
                        }
                    });
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        }).start();

        settimesun.setOnClickListener(new View.OnClickListener(){
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
                            wpg.data.get("Sunday").set(0, new SwitchHS("night", switchnight1sun.isChecked(), night1sun.getText().toString()));
                            wpg.data.get("Sunday").set(1, new SwitchHS("night", switchnight2sun.isChecked(), night2sun.getText().toString()));
                            wpg.data.get("Sunday").set(2, new SwitchHS("night", switchnight3sun.isChecked(), night3sun.getText().toString()));
                            wpg.data.get("Sunday").set(3, new SwitchHS("night", switchnight4sun.isChecked(), night4sun.getText().toString()));
                            wpg.data.get("Sunday").set(4, new SwitchHS("night", switchnight5sun.isChecked(), night5sun.getText().toString()));
                            wpg.data.get("Sunday").set(5, new SwitchHS("day", switchday1sun.isChecked(), day1sun.getText().toString()));
                            wpg.data.get("Sunday").set(6, new SwitchHS("day", switchday2sun.isChecked(), day2sun.getText().toString()));
                            wpg.data.get("Sunday").set(7, new SwitchHS("day", switchday3sun.isChecked(), day3sun.getText().toString()));
                            wpg.data.get("Sunday").set(8, new SwitchHS("day", switchday4sun.isChecked(), day4sun.getText().toString()));
                            wpg.data.get("Sunday").set(9, new SwitchHS("day", switchday5sun.isChecked(), day5sun.getText().toString()));
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

        // clocks
        day1sun = (EditText) findViewById(R.id.day1sun);
        day1sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day1sun); // show dialog
            }
        });

        day2sun = (EditText) findViewById(R.id.day2sun);
        day2sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day2sun); // show dialog
            }
        });

        day3sun = (EditText) findViewById(R.id.day3sun);
        day3sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day3sun); // show dialog
            }
        });

        day4sun = (EditText) findViewById(R.id.day4sun);
        day4sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day4sun); // show dialog
            }
        });

        day5sun = (EditText) findViewById(R.id.day5sun);
        day5sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day5sun); // show dialog
            }
        });

        night1sun = (EditText) findViewById(R.id.night1sun);
        night1sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night1sun); // show dialog
            }
        });

        night2sun = (EditText) findViewById(R.id.night2sun);
        night2sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night2sun); // show dialog
            }
        });

        night3sun = (EditText) findViewById(R.id.night3sun);
        night3sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night3sun); // show dialog
            }
        });

        night4sun = (EditText) findViewById(R.id.night4sun);
        night4sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night4sun); // show dialog
            }
        });

        night5sun = (EditText) findViewById(R.id.night5sun);
        night5sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night5sun); // show dialog
            }
        });

    }

    // clock dialog
    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}
