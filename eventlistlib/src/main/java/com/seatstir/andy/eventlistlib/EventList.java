package com.seatstir.andy.eventlistlib;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.seatstir.andy.eventfocus.EventFocus;
//import com.seatstir.andy.eventfocus.TixAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class EventList extends ActionBarActivity {
    //TixAdapter adapter;
    String xtestJstr = "{\"login\":\"success\",\"user_id\":\"39293\",\"event\":[{\"eid\":\"4589\",\"pid\":\"14124\",\"display_date_start\":\"2015-07-18\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-22\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/X-at-Music-Box--Cleveland--July-22-o7wvc0cXgt.jpg\",\"shortDesc\":\"X at Music Box (Cleveland) July 22\",\"eventid\":\"4589\",\"qtysum\":\"12\",\"qty\":\"2\",\"allocated\":\"20\",\"qtyalloc\":\"120\"},{\"eid\":\"4583\",\"pid\":\"14112\",\"display_date_start\":\"2015-07-15\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-20\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/Waxahatchee-at-Beachland-Ballroom---July-20--Cleveland--DH4FXri0K3.jpg\",\"shortDesc\":\"Waxahatchee at Beachland Ballroom - July 20 (Cleveland)\",\"eventid\":\"4583\",\"qtysum\":null,\"qty\":null,\"allocated\":\"10\",\"qtyalloc\":\"10\"},{\"eid\":\"4532\",\"pid\":\"14022\",\"display_date_start\":\"2015-07-09\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-08-07\",\"display_time_end\":\"11:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/cellar-door-rendezvous-ft---seafair-and-the-querencia-orchestra-sxbcum8iiv.jpg\",\"shortDesc\":\"Cellar Door Rendezvous ft.. Seafair and the Querencia Orchestra\",\"eventid\":\"4532\",\"qtysum\":\"26\",\"qty\":\"2\",\"allocated\":\"50\",\"qtyalloc\":\"650\"},{\"eid\":\"4531\",\"pid\":\"14021\",\"display_date_start\":\"2015-07-09\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-30\",\"display_time_end\":\"11:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/blues-traveler-vvcnozapze.jpg\",\"shortDesc\":\"Blues Traveler\",\"eventid\":\"4531\",\"qtysum\":\"24\",\"qty\":\"2\",\"allocated\":\"20\",\"qtyalloc\":\"240\"},{\"eid\":\"4512\",\"pid\":\"13983\",\"display_date_start\":\"2015-07-07\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-22\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/Chris-Knight-Full-Band-Show----Radio-Birds-6MKdYVtJ7G.jpg\",\"shortDesc\":\"Chris Knight - Full Band Show! (Cleveland)\",\"eventid\":\"4512\",\"qtysum\":\"11\",\"qty\":\"2\",\"allocated\":\"10\",\"qtyalloc\":\"60\"},{\"eid\":\"4510\",\"pid\":\"13976\",\"display_date_start\":\"2015-07-06\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-26\",\"display_time_end\":\"11:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/sleeping-beauty---swan-lake--olmsted-falls--ypxp4ibejf.jpg\",\"shortDesc\":\"Sleeping Beauty \\/ Swan Lake (Olmsted Falls)\",\"eventid\":\"4510\",\"qtysum\":\"22\",\"qty\":\"2\",\"allocated\":\"50\",\"qtyalloc\":\"550\"},{\"eid\":\"4507\",\"pid\":\"14085\",\"display_date_start\":\"2015-07-15\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-23\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/camelot-at-mercury-theatre-company--s--euclid--acapyiviao.jpg\",\"shortDesc\":\"Camelot  (S. Euclid)\",\"eventid\":\"4507\",\"qtysum\":\"22\",\"qty\":\"2\",\"allocated\":\"30\",\"qtyalloc\":\"270\"},{\"eid\":\"4220\",\"pid\":\"13322\",\"display_date_start\":\"2015-06-29\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-21\",\"display_time_end\":\"12:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/baseball---lake-county-captains-vs-fort-wayne---july-21--eastlake--kycbitiau3.jpg\",\"shortDesc\":\"Baseball - Lake County Captains vs Fort Wayne - July 21 (Eastlake)\",\"eventid\":\"4220\",\"qtysum\":\"56\",\"qty\":\"2\",\"allocated\":\"200\",\"qtyalloc\":\"5200\"}]}";
    String testJstr = "Patriots at Seahawks Super Bowl";
    EventData thisEventPicked;
    CustomAdapter eventAdapter;
    List<EventData> ListOfEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        //  String jstr = new String(getIntent().getStringExtra("jstr"));
        //  String jstr = String(getIntent().getStringExtra("jstr"));
        String jstr = getIntent().getStringExtra("jstr");


        ListOfEvents = new ArrayList<EventData>();
        // first, get the json data into a list container. Then an
        // adapter can fill the ListView with that list.
        try {
            JSONObject jobjTop = new JSONObject(jstr);
            //we're really interested only in the event array
            JSONArray jsEvents = jobjTop.getJSONArray("event");

            int length = jsEvents.length();
            Toast.makeText(getApplicationContext(), length + " Events Available ", Toast.LENGTH_LONG).show();

            for (int i = 0; i < length; i++) {
                JSONObject c = jsEvents.getJSONObject(i);
                String d = c.getString("shortDesc");
                EventData itemPlaceholder = new EventData(d,"   ph");
                ListOfEvents.add(itemPlaceholder);
            }
            //   myEvents.setAdapter(new CustomAdapter(this,testContents));
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        eventAdapter = new CustomAdapter(getApplicationContext(), R.layout.custom_event,
                ListOfEvents);
        ListView myEvents = (ListView) findViewById(R.id.listView);
        myEvents.setAdapter(eventAdapter);
        myEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //   thisEventPicked = ListOfEvents[position];
                thisEventPicked = ListOfEvents.get(position);
                String sTheEvent = thisEventPicked.getShortdesc();
                Toast.makeText(getApplicationContext(), sTheEvent , Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), EventFocus.class);
                i.putExtra("focusstr", sTheEvent);
                startActivity(i);  // goes into login success
            }
        });

    }
}
