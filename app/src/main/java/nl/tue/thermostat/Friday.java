package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Friday extends AppCompatActivity {

    EditText day1fri, day2fri, day3fri, day4fri, day5fri, night1fri, night2fri, night3fri,
            night4fri, night5fri;

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