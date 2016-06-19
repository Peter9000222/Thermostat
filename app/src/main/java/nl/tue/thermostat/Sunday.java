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

public class Sunday extends AppCompatActivity {

    EditText day1sun, day2sun, day3sun, day4sun, day5sun, night1sun, night2sun, night3sun,
            night4sun, night5sun;

    Switch switchday1sun, switchday2sun, switchday3sun, switchday4sun, switchday5sun,
            switchnight1sun, switchnight2sun, switchnight3sun, switchnight4sun, switchnight5sun;

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


        HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/19";
        HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";

        Button settimetues = (Button) findViewById(R.id.settimetues);

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

    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}
