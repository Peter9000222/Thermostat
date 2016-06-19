package nl.tue.thermostat;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
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

public class Monday extends AppCompatActivity {

    EditText day1mon, day2mon, day3mon, day4mon, day5mon, night1mon, night2mon, night3mon, night4mon, night5mon;
    Switch switchday1mon, switchday2mon, switchday3mon, switchday4mon, switchday5mon,
    switchnight1mon, switchnight2mon, switchnight3mon, switchnight4mon, switchnight5mon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        Button backtemp = (Button) findViewById(R.id.backtemp);
        backtemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        Button settimemon = (Button) findViewById(R.id.settimemon);

        switchday1mon = (Switch) findViewById(R.id.switchday1mon);
        switchday2mon = (Switch) findViewById(R.id.switchday2mon);
        switchday3mon = (Switch) findViewById(R.id.switchday3mon);
        switchday4mon = (Switch) findViewById(R.id.switchday4mon);
        switchday5mon = (Switch) findViewById(R.id.switchday5mon);
        switchnight1mon = (Switch) findViewById(R.id.switchnight1mon);
        switchnight2mon = (Switch) findViewById(R.id.switchnight2mon);
        switchnight3mon = (Switch) findViewById(R.id.switchnight3mon);
        switchnight4mon = (Switch) findViewById(R.id.switchnight4mon);
        switchnight5mon = (Switch) findViewById(R.id.switchnight5mon);

        // testing
        new Thread(new Runnable() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                try {
                    // Get the week program
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    ArrayList wpgm = wpg.data.get("Monday");
                    wpgm.get(1);

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        }).start();


        settimemon.setOnClickListener(new View.OnClickListener(){
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
                            wpg.setDefault();
                            wpg.data.get("Monday").set(0, new SwitchHS("night", switchnight1mon.isChecked(), night1mon.getText().toString()));
                            wpg.data.get("Monday").set(1, new SwitchHS("night", switchnight2mon.isChecked(), night2mon.getText().toString()));
                            wpg.data.get("Monday").set(2, new SwitchHS("night", switchnight3mon.isChecked(), night3mon.getText().toString()));
                            wpg.data.get("Monday").set(3, new SwitchHS("night", switchnight4mon.isChecked(), night4mon.getText().toString()));
                            wpg.data.get("Monday").set(4, new SwitchHS("night", switchnight5mon.isChecked(), night5mon.getText().toString()));
                            wpg.data.get("Monday").set(5, new SwitchHS("day", switchday1mon.isChecked(), day1mon.getText().toString()));
                            wpg.data.get("Monday").set(6, new SwitchHS("day", switchday2mon.isChecked(), day2mon.getText().toString()));
                            wpg.data.get("Monday").set(7, new SwitchHS("day", switchday3mon.isChecked(), day3mon.getText().toString()));
                            wpg.data.get("Monday").set(8, new SwitchHS("day", switchday3mon.isChecked(), day4mon.getText().toString()));
                            wpg.data.get("Monday").set(9, new SwitchHS("day", switchday4mon.isChecked(), day5mon.getText().toString()));
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
        day1mon = (EditText) findViewById(R.id.day1tues);
        day1mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day1mon); // show dialog
            }
        });

        day2mon = (EditText) findViewById(R.id.day2mon);
        day2mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day2mon); // show dialog
            }
        });

        day3mon = (EditText) findViewById(R.id.day3mon);
        day3mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day3mon); // show dialog
            }
        });

        day4mon = (EditText) findViewById(R.id.day4mon);
        day4mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day4mon); // show dialog
            }
        });

        day5mon = (EditText) findViewById(R.id.day5mon);
        day5mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day5mon); // show dialog
            }
        });

        night1mon = (EditText) findViewById(R.id.night1mon);
        night1mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night1mon); // show dialog
            }
        });

        night2mon = (EditText) findViewById(R.id.night2mon);
        night2mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night2mon); // show dialog
            }
        });

        night3mon = (EditText) findViewById(R.id.night3mon);
        night3mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night3mon); // show dialog
            }
        });

        night4mon = (EditText) findViewById(R.id.night4mon);
        night4mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night4mon); // show dialog
            }
        });

        night5mon = (EditText) findViewById(R.id.night5mon);
        night5mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night5mon); // show dialog
            }
        });

    }

    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}
