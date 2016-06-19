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

public class Friday extends AppCompatActivity {

    EditText day1fri, day2fri, day3fri, day4fri, day5fri, night1fri, night2fri, night3fri,
            night4fri, night5fri;

    Switch switchday1fri, switchday2fri, switchday3fri, switchday4fri, switchday5fri,
            switchnight1fri, switchnight2fri, switchnight3fri, switchnight4fri, switchnight5fri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday);
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

        Button settimetues = (Button) findViewById(R.id.settimetues);

        switchday1fri = (Switch) findViewById(R.id.switchday1fri);
        switchday2fri = (Switch) findViewById(R.id.switchday2fri);
        switchday3fri = (Switch) findViewById(R.id.switchday3fri);
        switchday4fri = (Switch) findViewById(R.id.switchday4fri);
        switchday5fri = (Switch) findViewById(R.id.switchday5fri);
        switchnight1fri = (Switch) findViewById(R.id.switchnight1fri);
        switchnight2fri = (Switch) findViewById(R.id.switchnight2fri);
        switchnight3fri = (Switch) findViewById(R.id.switchnight3fri);
        switchnight4fri = (Switch) findViewById(R.id.switchnight4fri);
        switchnight5fri = (Switch) findViewById(R.id.switchnight5fri);

        settimetues.setOnClickListener(new View.OnClickListener(){
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
                            wpg.data.get("Friday").set(0, new SwitchHS("night", switchnight1fri.isChecked(), night1fri.getText().toString()));
                            wpg.data.get("Friday").set(1, new SwitchHS("night", switchnight2fri.isChecked(), night2fri.getText().toString()));
                            wpg.data.get("Friday").set(2, new SwitchHS("night", switchnight3fri.isChecked(), night3fri.getText().toString()));
                            wpg.data.get("Friday").set(3, new SwitchHS("night", switchnight4fri.isChecked(), night4fri.getText().toString()));
                            wpg.data.get("Friday").set(4, new SwitchHS("night", switchnight5fri.isChecked(), night5fri.getText().toString()));
                            wpg.data.get("Friday").set(5, new SwitchHS("day", switchday1fri.isChecked(), day1fri.getText().toString()));
                            wpg.data.get("Friday").set(6, new SwitchHS("day", switchday2fri.isChecked(), day2fri.getText().toString()));
                            wpg.data.get("Friday").set(7, new SwitchHS("day", switchday3fri.isChecked(), day3fri.getText().toString()));
                            wpg.data.get("Friday").set(8, new SwitchHS("day", switchday4fri.isChecked(), day4fri.getText().toString()));
                            wpg.data.get("Friday").set(9, new SwitchHS("day", switchday5fri.isChecked(), day5fri.getText().toString()));
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

        day1fri = (EditText) findViewById(R.id.day1fri);
        day1fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day1fri); // show dialog
            }
        });

        day2fri = (EditText) findViewById(R.id.day2fri);
        day2fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day2fri); // show dialog
            }
        });

        day3fri = (EditText) findViewById(R.id.day3fri);
        day3fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day3fri); // show dialog
            }
        });

        day4fri = (EditText) findViewById(R.id.day4fri);
        day4fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day4fri); // show dialog
            }
        });

        day5fri = (EditText) findViewById(R.id.day5fri);
        day5fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day5fri); // show dialog
            }
        });

        night1fri = (EditText) findViewById(R.id.night1fri);
        night1fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night1fri); // show dialog
            }
        });

        night2fri = (EditText) findViewById(R.id.night2fri);
        night2fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night2fri); // show dialog
            }
        });

        night3fri = (EditText) findViewById(R.id.night3fri);
        night3fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night3fri); // show dialog
            }
        });

        night4fri = (EditText) findViewById(R.id.night4fri);
        night4fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night4fri); // show dialog
            }
        });

        night5fri = (EditText) findViewById(R.id.night5fri);
        night5fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night5fri); // show dialog
            }
        });

    }

    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}