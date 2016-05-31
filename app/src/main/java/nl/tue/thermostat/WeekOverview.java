package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeekOverview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_overview);
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
    }
}
