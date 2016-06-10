package nl.tue.thermostat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import org.thermostatapp.util.*;

public class ThermostatOverview extends AppCompatActivity {

    int stemp=200;
    TextView temp;
    TextView program;
    SeekBar tempbar;
    View view;
    Button bweekprogram;
    Boolean on = false;
    Drawable weekon;
    Drawable weekoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HeatingSystem.BASE_ADDRESS = "http://pcwin889.win.tue.nl/2id40-ws/19/";


        setContentView(R.layout.activity_thermostat_overview);
        Button bplus = (Button) findViewById(R.id.bplus);
        Button bminus = (Button) findViewById(R.id.bminus);
        temp = (TextView) findViewById(R.id.temp);
        tempbar = (SeekBar) findViewById(R.id.tempbar);
        final Button bsetprogram = (Button) findViewById(R.id.bsetprogram);
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
                if (progress < 50) {
                    progress = 50;
                    stemp = progress;
                    temp.setText("5,0 \u2103");
                    tempbar.setProgress(progress);
                } else {
                    stemp = progress;
                    int number = stemp/10;
                    int decimal = stemp%10;
                    temp.setText(number + ","+ decimal + " \u2103");
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}});

        bplus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                stemp = (stemp + 1);
                int number = stemp/10;
                int decimal = stemp%10;
                if (stemp > 300) {
                    stemp = 300;
                    temp.setText("30,0 \u2103");
                    tempbar.setProgress(stemp);
                    burn(view);
                } else {
                    temp.setText(number + ","+ decimal + " \u2103");
                    tempbar.setProgress(stemp);
                }
            }
        });

        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stemp = (stemp - 1);
                if (stemp<50) {
                    freeze(view);
                }
                int number = stemp/10;
                int decimal = stemp%10;
                temp.setText(number + ","+ decimal + " \u2103");
                tempbar.setProgress(stemp);
            }
        });
        bweekprogram = (Button) findViewById(R.id.bweekprogram);
        Resources res = getResources();
        weekon = res.getDrawable(R.drawable.on);
        weekoff = res.getDrawable(R.drawable.off);
        bweekprogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (on == false) {
                    bweekprogram.setText("Week program on");
                    bweekprogram.setBackground(weekon);
                    on = true;
                }
                else {
                    bweekprogram.setText("Week program off");
                    bweekprogram.setBackground(weekoff);
                    on = false;
                }

            }
        });
    }
    public void freeze(View view) {
        AlertDialog.Builder freeze = new AlertDialog.Builder(this);
        freeze.setMessage("Do not freeze the pipes!! The minimum temperature is 5,0 \u2103")
                .setTitle("Warning!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        freeze.show();
    }
    public void burn(View view) {
        AlertDialog.Builder burn = new AlertDialog.Builder(this);
        burn.setMessage("Do not burn the pipes!! The maximum temperature is 30,0 \u2103")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setTitle("Warning!")
                .create();
        burn.show();
    }
}
