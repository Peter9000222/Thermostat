package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.thermostatapp.util.HeatingSystem;

public class WeekOverview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_overview);

        HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/19";
        HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";

        Button backweek = (Button) findViewById(R.id.backweek);
        backweek.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ThermostatOverview.class);
                startActivity(intent);
            }
        });
        Button setdaynight = (Button) findViewById(R.id.setdaynight);
        setdaynight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SetTemperature.class);
                startActivity(intent);
            }
        });
        Button mon = (Button) findViewById(R.id.mon);
        mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Monday.class);
                startActivity(intent);
            }
        });
        Button tues = (Button) findViewById(R.id.tues);
        tues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Tuesday.class);
                startActivity(intent);
            }
        });
        Button wednes = (Button) findViewById(R.id.wednes);
        wednes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view) {
                Intent intent = new Intent(view.getContext(), Wednesday.class);
                startActivity(intent);
            }
        });
        Button thurs = (Button) findViewById(R.id.thurs);
        thurs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Thursday.class);
                startActivity(intent);
            }
        });
        Button fri = (Button) findViewById(R.id.fri);
        fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Friday.class);
                startActivity(intent);
            }
        });
        Button satur = (Button) findViewById(R.id.satur);
        satur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Saturday.class);
                startActivity(intent);
            }
        });
        Button sun = (Button) findViewById(R.id.sun);
        sun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Sunday.class);
                startActivity(intent);
            }
        });
    }
}
