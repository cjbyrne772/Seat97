package com.seatstir.andy.eventfocus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;


import java.util.ArrayList;
import java.util.List;

public class EventFocus extends ActionBarActivity {
    TixAdapter   perfAdapter;
    TixData      thisPerfPicked;
    List<TixData>  ListOfPerf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_focus);

        ListOfPerf = new ArrayList<TixData>();
        TextView tCurrentEvent;
       // String  jstr;
        perfAdapter = new TixAdapter(getApplicationContext(), R.layout.tix_layout,ListOfPerf);

        TixData perfPlaceholder;

        perfPlaceholder = new TixData(2); //sets q to 2

        ListOfPerf.add(perfPlaceholder);
        ListOfPerf.add(perfPlaceholder);
        ListOfPerf.add(perfPlaceholder);
        ListOfPerf.add(perfPlaceholder);

        ListView possibleEvents = (ListView) findViewById(R.id.listView);
        tCurrentEvent = (TextView) findViewById(R.id.textView);
        possibleEvents.setAdapter(perfAdapter);


        // why is this redundant?
          String jstr = new String(getIntent().getStringExtra("focusstr"));
        //   jstr = new String(getIntent().getStringExtra("focusstr"));
        //   jstr = new String("focusstr");

        tCurrentEvent.setText(jstr);

     //   Toast.makeText(getApplicationContext(), jstr , Toast.LENGTH_SHORT).show();


        //   Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
    }

}
