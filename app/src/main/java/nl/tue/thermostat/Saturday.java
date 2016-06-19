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

public class Saturday extends AppCompatActivity {

    EditText day1satur, day2satur, day3satur, day4satur, day5satur, night1satur, night2satur, night3satur,
            night4satur, night5satur;

    Switch switchday1satur, switchday2satur, switchday3satur, switchday4satur, switchday5satur,
            switchnight1satur, switchnight2satur, switchnight3satur, switchnight4satur, switchnight5satur;

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

        HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/19";
        HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";

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
                            // wpg.setDefault();
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

    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}