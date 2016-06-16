package nl.tue.thermostat;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.TimePicker;
import android.support.v4.app.DialogFragment;
import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    int hourChoice, minuteChoice;

    EditText textToBeChanged;

    public TimePickerFragment(EditText textToBeChanged){
        this.textToBeChanged = textToBeChanged;
        System.out.println(textToBeChanged);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        // variables will be set if the dialog is closed
        hourChoice = view.getCurrentHour();
        minuteChoice = view.getCurrentMinute();
        int h, m;
        String seth, setm;
        if (hourChoice < 10){
            seth = "0"+hourChoice;
        }
        else {
            seth = ""+hourChoice;
        }
        if (minuteChoice < 10){
            setm = "0"+minuteChoice;
        }
        else {
            setm = ""+minuteChoice;
        }
        //textToBeChanged.setText(this.hourChoice + ":" + this.minuteChoice);
        textToBeChanged.setText(seth + ":" + setm);
    }

}