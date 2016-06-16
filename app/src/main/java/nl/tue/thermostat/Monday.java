package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Monday extends AppCompatActivity {

    EditText day1mon, day2mon, day3mon, day4mon, day5mon, night1mon, night2mon, night3mon, night4mon, night5mon;

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
