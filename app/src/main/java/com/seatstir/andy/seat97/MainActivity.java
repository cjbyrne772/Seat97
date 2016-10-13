package com.seatstir.andy.seat97;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.seatstir.andy.eventlistlib.EventList;

import org.json.JSONException;
import org.json.JSONObject;

/*
public interface Constants {
    String LOG = "com.seatstir.andy.seat97";
}
*/

public class MainActivity extends Activity {

    TextView tv;
    String jstr = "testtest";
    // use a StringBuffer to hold the json coming back. This gives us some flexibility, but we
    // may want to change this back to just a String for release.
    StringBuffer jsb = new StringBuffer(4000);
    JSONObject jobj = new JSONObject();
    // String urlString = "https://seatstir.com/ptapp/jsontest.php";
    String urlString = "https://seatstir.com/ptapp/ptlogin.php";
    // String urlString = "https://httpbin.org/post";
    //  String urlString = "http://api.androidhive.info/volley/person_object.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView2);
        Button button = (Button) findViewById(R.id.button);
        try {
        jobj.put("login", "success");
        jobj.put("user_id", "23456");
        }
        catch(JSONException ex) {
            ex.printStackTrace();
        }

        if (BuildConfig.DEBUG) { Log.d("DEBUG", "On Create main");}

        // Get a RequestQueue. If the VolleySingleton has not been created, this will
// new it and return a pointer to the instance
        RequestQueue queue = VolleySingleton.getInstance(this.getApplicationContext()).
                getRequestQueue();
        // We don't need to have the queue here. Just get a string from the network
        // with networkStringLoader
        //Toast.makeText(MainActivity.this, "starting", Toast.LENGTH_SHORT).show();

        final EditText etUser = (EditText) findViewById(R.id.editText);
        final EditText etPass = (EditText) findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kbuser = etUser.getText().toString();
                String kbpass = etPass.getText().toString();
                // Each time the submit button is hit we create a new String Loader. This
                // is so we can log in as different users from the same phone
                NetworkStringLoader loader = new NetworkStringLoader(MainActivity.this, kbuser, kbpass);
                // requestString will make the request and consume the json from the url. If it is a bad
                // login, a toast will be displayed and the current activity will still have focus, so you
                // can log in again.
                loader.requestString(urlString);

                // Wait until the JSON string buffer is populated. In the future, we will call the
                // EventList activity directly from the RequestString. But for now, let's do it
                // dirty and sleep
              //  int leng;
                /*
                while (jsb.length() == 0) {
                    Toast.makeText(MainActivity.this, "strlength==" + jsb.length(), Toast.LENGTH_SHORT).show();
                    Log.d("DEBUG", "waiting strlen ==" + jsb.length() );
                }
                    */
                    //if (BuildConfig.DEBUG) { Log.d("DEBUG", "after req str==" + jsb.substring(0,12));}
               // Toast.makeText(MainActivity.this, "Button Clicked1", Toast.LENGTH_SHORT).show();
                /*
                Intent i = new Intent(getApplicationContext(), EventList.class);
//                i.putExtra("jstr", jobj.toString() );
                i.putExtra("jstr", jsb.toString() );
                startActivity(i);
                */
            }
        });


    }
}
