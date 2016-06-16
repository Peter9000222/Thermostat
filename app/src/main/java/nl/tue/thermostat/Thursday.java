package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Thursday extends AppCompatActivity {

    EditText day1thurs, day2thurs, day3thurs, day4thurs, day5thurs, night1thurs, night2thurs, night3thurs,
            night4thurs, night5thurs;

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


