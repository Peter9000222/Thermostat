package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Wednesday extends AppCompatActivity {

    EditText day1wed, day2wed, day3wed, day4wed, day5wed, night1wed, night2wed, night3wed, night4wed, night5wed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);
        Button backtemp = (Button) findViewById(R.id.backtemp);
        backtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        day1wed = (EditText) findViewById(R.id.day1wed);
        day1wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day1wed); // show dialog
            }
        });

        day2wed = (EditText) findViewById(R.id.day2wed);
        day2wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day2wed); // show dialog
            }
        });

        day3wed = (EditText) findViewById(R.id.day3wed);
        day3wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day3wed); // show dialog
            }
        });

        day4wed = (EditText) findViewById(R.id.day4wed);
        day4wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day4wed); // show dialog
            }
        });

        day5wed = (EditText) findViewById(R.id.day5wed);
        day5wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, day5wed); // show dialog
            }
        });

        night1wed = (EditText) findViewById(R.id.night1wed);
        night1wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night1wed); // show dialog
            }
        });

        night2wed = (EditText) findViewById(R.id.night2wed);
        night2wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night2wed); // show dialog
            }
        });

        night3wed = (EditText) findViewById(R.id.night3wed);
        night3wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night3wed); // show dialog
            }
        });

        night4wed = (EditText) findViewById(R.id.night4wed);
        night4wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night4wed); // show dialog
            }
        });

        night5wed = (EditText) findViewById(R.id.night5wed);
        night5wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showTimePickerDialog(view, night5wed); // show dialog
            }
        });

    }

    public void showTimePickerDialog(View v, EditText id) {
        TimePickerFragment newFragment = new TimePickerFragment(id);
        newFragment.show(getSupportFragmentManager(), "time");
    }
}
