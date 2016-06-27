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

public class Wednesday extends AppCompatActivity {

    EditText day1wed, day2wed, day3wed, day4wed, day5wed, night1wed, night2wed, night3wed, night4wed, night5wed;

    Switch switchday1wed, switchday2wed, switchday3wed, switchday4wed, switchday5wed,
            switchnight1wed, switchnight2wed, switchnight3wed, switchnight4wed, switchnight5wed;

    int days = 1;
    int nights = 1;

    String time, time1, time2, time3, time4, time5, time6, time7, time8, time9, time10,
            type;
    Boolean state, state1, state2, state3, state4, state5, state6, state7, state8, state9, state10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);
        Button backtemp = (Button) findViewById(R.id.backtemp);
        backtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        Button settimewed = (Button) findViewById(R.id.settimewed);

        switchday1wed = (Switch) findViewById(R.id.switchday1wed);
        switchday2wed = (Switch) findViewById(R.id.switchday2wed);
        switchday3wed = (Switch) findViewById(R.id.switchday3wed);
        switchday4wed = (Switch) findViewById(R.id.switchday4wed);
        switchday5wed = (Switch) findViewById(R.id.switchday5wed);
        switchnight1wed = (Switch) findViewById(R.id.switchnight1wed);
        switchnight2wed = (Switch) findViewById(R.id.switchnight2wed);
        switchnight3wed = (Switch) findViewById(R.id.switchnight3wed);
        switchnight4wed = (Switch) findViewById(R.id.switchnight4wed);
        switchnight5wed = (Switch) findViewById(R.id.switchnight5wed);

        new Thread(new Runnable() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                try {
                    // Get the week program
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    ArrayList<SwitchHS> wpgm = wpg.data.get("Wednesday");
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
                    day1wed.post(new Runnable() {
                        @Override
                        public void run() {
                            day1wed.setText(time10);
                            day2wed.setText(time9);
                            day3wed.setText(time8);
                            day4wed.setText(time7);
                            day5wed.setText(time6);
                            switchday1wed.setChecked(state10);
                            switchday2wed.setChecked(state9);
                            switchday3wed.setChecked(state8);
                            switchday4wed.setChecked(state7);
                            switchday5wed.setChecked(state6);
                            night1wed.setText(time5);
                            night2wed.setText(time4);
                            night3wed.setText(time3);
                            night4wed.setText(time2);
                            night5wed.setText(time1);
                            switchnight1wed.setChecked(state5);
                            switchnight2wed.setChecked(state4);
                            switchnight3wed.setChecked(state3);
                            switchnight4wed.setChecked(state2);
                            switchnight5wed.setChecked(state1);
                        }
                    });
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        }).start();

        settimewed.setOnClickListener(new View.OnClickListener(){
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
                            wpg.data.get("Wednesday").set(0, new SwitchHS("night", switchnight1wed.isChecked(), night1wed.getText().toString()));
                            wpg.data.get("Wednesday").set(1, new SwitchHS("night", switchnight2wed.isChecked(), night2wed.getText().toString()));
                            wpg.data.get("Wednesday").set(2, new SwitchHS("night", switchnight3wed.isChecked(), night3wed.getText().toString()));
                            wpg.data.get("Wednesday").set(3, new SwitchHS("night", switchnight4wed.isChecked(), night4wed.getText().toString()));
                            wpg.data.get("Wednesday").set(4, new SwitchHS("night", switchnight5wed.isChecked(), night5wed.getText().toString()));
                            wpg.data.get("Wednesday").set(5, new SwitchHS("day", switchday1wed.isChecked(), day1wed.getText().toString()));
                            wpg.data.get("Wednesday").set(6, new SwitchHS("day", switchday2wed.isChecked(), day2wed.getText().toString()));
                            wpg.data.get("Wednesday").set(7, new SwitchHS("day", switchday3wed.isChecked(), day3wed.getText().toString()));
                            wpg.data.get("Wednesday").set(8, new SwitchHS("day", switchday4wed.isChecked(), day4wed.getText().toString()));
                            wpg.data.get("Wednesday").set(9, new SwitchHS("day", switchday5wed.isChecked(), day5wed.getText().toString()));
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
        day1wed = (EditText) findViewById(R.id.day1wed);
        day1wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day1wed); // show dialog
            }
        });

        day2wed = (EditText) findViewById(R.id.day2wed);
        day2wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day2wed); // show dialog
            }
        });

        day3wed = (EditText) findViewById(R.id.day3wed);
        day3wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day3wed); // show dialog
            }
        });

        day4wed = (EditText) findViewById(R.id.day4wed);
        day4wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day4wed); // show dialog
            }
        });

        day5wed = (EditText) findViewById(R.id.day5wed);
        day5wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day5wed); // show dialog
            }
        });

        night1wed = (EditText) findViewById(R.id.night1wed);
        night1wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night1wed); // show dialog
            }
        });

        night2wed = (EditText) findViewById(R.id.night2wed);
        night2wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night2wed); // show dialog
            }
        });

        night3wed = (EditText) findViewById(R.id.night3wed);
        night3wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night3wed); // show dialog
            }
        });

        night4wed = (EditText) findViewById(R.id.night4wed);
        night4wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night4wed); // show dialog
            }
        });

        night5wed = (EditText) findViewById(R.id.night5wed);
        night5wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night5wed); // show dialog
            }
        });

    }

    // clock dialog
    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}
