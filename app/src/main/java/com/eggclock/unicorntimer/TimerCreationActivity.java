package com.eggclock.unicorntimer;

import android.app.ActionBar;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

import com.eggclock.unicorntimer.domain.UnicornTimer;

import java.sql.Timestamp;

public class TimerCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_creation);
        final EditText nameField = (EditText) findViewById(R.id.editText);
        final Button createButton = (Button) findViewById(R.id.createButton);

        //Get the widgets reference from XML layout
        final NumberPicker hourpicker = (NumberPicker) findViewById(R.id.np2);
        final NumberPicker minutePicker = (NumberPicker) findViewById(R.id.np1);
        hourpicker.setMinValue(0);
        hourpicker.setMaxValue(24);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        hourpicker.setWrapSelectorWheel(true);
        hourpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            }
        });

        minutePicker.setMinValue(0);
        minutePicker.setMaxValue(60);
        minutePicker.setWrapSelectorWheel(true);
        minutePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            }
        });

        TimerCreationActivity that = this;
        //Create the timer on okbuton click
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UnicornTimer unicornTimer = getTimerObject(nameField, hourpicker, minutePicker);
                if (unicornTimer.getDuration() != 0) {

                    unicornTimer.startTimer();
                    goToMainActivity(view);
                }
            }
        });
    }


    // redirect to Main Activity
    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public UnicornTimer getTimerObject(EditText nameField, NumberPicker hourpicker, NumberPicker minutePicker) {
        int hours = hourpicker.getValue();
        int minutes = minutePicker.getValue();
        String timerName = nameField.getText().toString();

        System.out.println(String.valueOf("hours" + hours));
        System.out.println(String.valueOf("minutes" + minutes));

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        minutes = minutes + (hours * 60);
        int duration = minutes * 60 * 1000;

        return new UnicornTimer(timerName, duration, currentTime, "default");
    }
}
