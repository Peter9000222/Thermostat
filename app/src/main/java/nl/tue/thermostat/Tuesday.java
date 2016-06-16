package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tuesday extends AppCompatActivity {

    EditText day1tues, day2tues, day3tues, day4tues, day5tues, night1tues, night2tues, night3tues, night4tues, night5tues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);
        Button backtemp = (Button) findViewById(R.id.backtemp);
        backtemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        day1tues = (EditText) findViewById(R.id.day1tues);
        day1tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day1tues); // show dialog
            }
        });

        day2tues = (EditText) findViewById(R.id.day2tues);
        day2tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day2tues); // show dialog
            }
        });

        day3tues = (EditText) findViewById(R.id.day3tues);
        day3tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day3tues); // show dialog
            }
        });

        day4tues = (EditText) findViewById(R.id.day4tues);
        day4tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day4tues); // show dialog
            }
        });

        day5tues = (EditText) findViewById(R.id.day5tues);
        day5tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day5tues); // show dialog
            }
        });

        night1tues = (EditText) findViewById(R.id.night1tues);
        night1tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night1tues); // show dialog
            }
        });

        night2tues = (EditText) findViewById(R.id.night2tues);
        night2tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night2tues); // show dialog
            }
        });

        night3tues = (EditText) findViewById(R.id.night3tues);
        night3tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night3tues); // show dialog
            }
        });

        night4tues = (EditText) findViewById(R.id.night4tues);
        night4tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night4tues); // show dialog
            }
        });

        night5tues = (EditText) findViewById(R.id.night5tues);
        night5tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night5tues); // show dialog
            }
        });
    }

    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}
