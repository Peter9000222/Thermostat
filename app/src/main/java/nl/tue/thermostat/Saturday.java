package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Saturday extends AppCompatActivity {

    EditText day1satur, day2satur, day3satur, day4satur, day5satur, night1satur, night2satur, night3satur,
            night4satur, night5satur;

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