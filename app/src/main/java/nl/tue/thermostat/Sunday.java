package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sunday extends AppCompatActivity {

    EditText day1sun, day2sun, day3sun, day4sun, day5sun, night1sun, night2sun, night3sun,
            night4sun, night5sun;

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
