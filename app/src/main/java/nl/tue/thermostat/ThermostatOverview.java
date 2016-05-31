package nl.tue.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.Math;
import java.text.DecimalFormat;


public class ThermostatOverview extends AppCompatActivity {

    Double stemp=20.0;
    TextView temp;
    SeekBar tempbar;
   // DecimalFormat df = new DecimalFormat("#.0");
    int a;
    int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat_overview);
        Button bplus = (Button) findViewById(R.id.bplus);
        Button bminus = (Button) findViewById(R.id.bminus);
        temp = (TextView) findViewById(R.id.temp);
        tempbar = (SeekBar) findViewById(R.id.tempbar);
        Button bsetprogram = (Button) findViewById(R.id.bsetprogram);
        bsetprogram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });
        tempbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int  progress, boolean fromUser) {
                b = progress;
                if (progress < 5) {
                    progress = 5;
                    temp.setText(progress + ".0 \u2103");
                    stemp = (double) progress;
                    tempbar.setProgress(progress);
                } else {
                    temp.setText(progress + ".0 \u2103");
                    stemp = (double) progress;
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}});

        bplus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                stemp = (stemp + 0.1);
                if (stemp > 30) {
                    stemp = 30.0;
                    temp.setText(stemp + ""); //df.format(stemp) + " \u2103");
                    a = stemp.intValue();
                    tempbar.setProgress(a);
                } else {
                    temp.setText(stemp + ""); //df.format(stemp) + " \u2103");
                    a = stemp.intValue();
                    tempbar.setProgress(a);
                    System.out.println(stemp);
                }
            }
        });

        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // System.out.println(stemp);
                stemp = (stemp - 0.1);
              //  System.out.println(stemp);
                temp.setText(stemp + "");//df.format(stemp) + "\u2103");
                System.out.println(stemp);
                a = stemp.intValue();
                System.out.println(stemp);
                tempbar.setProgress(a);
                System.out.println(stemp);
                System.out.println(a);
                System.out.println("b = " + b);
            }
        });

       // tempbar.setProgress(stemp);
    }
}
