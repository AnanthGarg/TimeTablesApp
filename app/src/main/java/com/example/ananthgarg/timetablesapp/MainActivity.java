package com.example.ananthgarg.timetablesapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    final int min=1;

    public void timetab(int i) {
        ArrayList<String> arrayList = new ArrayList<String>();


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);


        for (int j = 1; j <= 20; j++) {
            arrayList.add(Integer.toString((i * j)));

        }
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar volumeControl = (SeekBar) findViewById(R.id.seekBar);
        int max=20;
        volumeControl.setMax(max);
volumeControl.setProgress(min);

timetab(min);


        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(i<min)
                {
                    i=min;
                    volumeControl.setProgress(min);
                }


                timetab(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
