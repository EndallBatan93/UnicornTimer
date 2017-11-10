package com.eggclock.unicorntimer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView mainListView;
    private ArrayAdapter<String> listAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainListView = findViewById(R.id.mainListView);

        String[] planets = new String[] { "Superman", "Batman", "GreenLantern", "Cyborg",
                "Wonder Woman", "Aquaman", "Flash", "Martian Manhunter", "Green Arrow"};
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow,R.id.textview, planetList);
        listAdapter.add("Martian Manhunter");
        mainListView.setAdapter( listAdapter );

    }

    public void goToTimerCreationActivity(View view) {
        Intent intent = new Intent(this, TimerCreationActivity.class);
        startActivity(intent);
    }
}
