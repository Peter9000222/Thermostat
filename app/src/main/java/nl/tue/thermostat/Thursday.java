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

public class Thursday extends AppCompatActivity {

    EditText day1thurs, day2thurs, day3thurs, day4thurs, day5thurs, night1thurs, night2thurs, night3thurs,
            night4thurs, night5thurs;

    Switch switchday1thurs, switchday2thurs, switchday3thurs, switchday4thurs, switchday5thurs,
            switchnight1thurs, switchnight2thurs, switchnight3thurs, switchnight4thurs, switchnight5thurs;

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

        HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/19";
        HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";

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
                            wpg.setDefault();
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

    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}


