package com.seatstir.andy.seat97;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.seatstir.andy.eventlistlib.EventList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fred on 12/2/2015.
 */
public class NetworkStringLoader {
    Context context;
    TextView display;
//    StringBuffer networkdata;
    String user_email;
    String user_password;
    String myjstr;
    int rcount;
   // String jstr = "{\"login\":\"success\",\"user_id\":\"39293\",\"event\":[{\"eid\":\"4589\",\"pid\":\"14124\",\"display_date_start\":\"2015-07-18\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-22\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/X-at-Music-Box--Cleveland--July-22-o7wvc0cXgt.jpg\",\"shortDesc\":\"X at Music Box (Cleveland) July 22\",\"eventid\":\"4589\",\"qtysum\":\"12\",\"qty\":\"2\",\"allocated\":\"20\",\"qtyalloc\":\"120\"},{\"eid\":\"4583\",\"pid\":\"14112\",\"display_date_start\":\"2015-07-15\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-20\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/Waxahatchee-at-Beachland-Ballroom---July-20--Cleveland--DH4FXri0K3.jpg\",\"shortDesc\":\"Waxahatchee at Beachland Ballroom - July 20 (Cleveland)\",\"eventid\":\"4583\",\"qtysum\":null,\"qty\":null,\"allocated\":\"10\",\"qtyalloc\":\"10\"},{\"eid\":\"4532\",\"pid\":\"14022\",\"display_date_start\":\"2015-07-09\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-08-07\",\"display_time_end\":\"11:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/cellar-door-rendezvous-ft---seafair-and-the-querencia-orchestra-sxbcum8iiv.jpg\",\"shortDesc\":\"Cellar Door Rendezvous ft.. Seafair and the Querencia Orchestra\",\"eventid\":\"4532\",\"qtysum\":\"26\",\"qty\":\"2\",\"allocated\":\"50\",\"qtyalloc\":\"650\"},{\"eid\":\"4531\",\"pid\":\"14021\",\"display_date_start\":\"2015-07-09\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-30\",\"display_time_end\":\"11:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/blues-traveler-vvcnozapze.jpg\",\"shortDesc\":\"Blues Traveler\",\"eventid\":\"4531\",\"qtysum\":\"24\",\"qty\":\"2\",\"allocated\":\"20\",\"qtyalloc\":\"240\"},{\"eid\":\"4512\",\"pid\":\"13983\",\"display_date_start\":\"2015-07-07\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-22\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/Chris-Knight-Full-Band-Show----Radio-Birds-6MKdYVtJ7G.jpg\",\"shortDesc\":\"Chris Knight - Full Band Show! (Cleveland)\",\"eventid\":\"4512\",\"qtysum\":\"11\",\"qty\":\"2\",\"allocated\":\"10\",\"qtyalloc\":\"60\"},{\"eid\":\"4510\",\"pid\":\"13976\",\"display_date_start\":\"2015-07-06\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-26\",\"display_time_end\":\"11:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/sleeping-beauty---swan-lake--olmsted-falls--ypxp4ibejf.jpg\",\"shortDesc\":\"Sleeping Beauty \\/ Swan Lake (Olmsted Falls)\",\"eventid\":\"4510\",\"qtysum\":\"22\",\"qty\":\"2\",\"allocated\":\"50\",\"qtyalloc\":\"550\"},{\"eid\":\"4507\",\"pid\":\"14085\",\"display_date_start\":\"2015-07-15\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-23\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/camelot-at-mercury-theatre-company--s--euclid--acapyiviao.jpg\",\"shortDesc\":\"Camelot  (S. Euclid)\",\"eventid\":\"4507\",\"qtysum\":\"22\",\"qty\":\"2\",\"allocated\":\"30\",\"qtyalloc\":\"270\"},{\"eid\":\"4220\",\"pid\":\"13322\",\"display_date_start\":\"2015-06-29\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-21\",\"display_time_end\":\"12:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/baseball---lake-county-captains-vs-fort-wayne---july-21--eastlake--kycbitiau3.jpg\",\"shortDesc\":\"Baseball - Lake County Captains vs Fort Wayne - July 21 (Eastlake)\",\"eventid\":\"4220\",\"qtysum\":\"56\",\"qty\":\"2\",\"allocated\":\"200\",\"qtyalloc\":\"5200\"}]}";
    String xtestJstr = "{\"login\":\"success\",\"user_id\":\"39293\",\"event\":[{\"eid\":\"4589\",\"pid\":\"14124\",\"display_date_start\":\"2015-07-18\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-22\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/X-at-Music-Box--Cleveland--July-22-o7wvc0cXgt.jpg\",\"shortDesc\":\"X at Music Box (Cleveland) July 22\",\"eventid\":\"4589\",\"qtysum\":\"12\",\"qty\":\"2\",\"allocated\":\"20\",\"qtyalloc\":\"120\"},{\"eid\":\"4583\",\"pid\":\"14112\",\"display_date_start\":\"2015-07-15\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-20\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/Waxahatchee-at-Beachland-Ballroom---July-20--Cleveland--DH4FXri0K3.jpg\",\"shortDesc\":\"Waxahatchee at Beachland Ballroom - July 20 (Cleveland)\",\"eventid\":\"4583\",\"qtysum\":null,\"qty\":null,\"allocated\":\"10\",\"qtyalloc\":\"10\"},{\"eid\":\"4532\",\"pid\":\"14022\",\"display_date_start\":\"2015-07-09\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-08-07\",\"display_time_end\":\"11:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/cellar-door-rendezvous-ft---seafair-and-the-querencia-orchestra-sxbcum8iiv.jpg\",\"shortDesc\":\"Cellar Door Rendezvous ft.. Seafair and the Querencia Orchestra\",\"eventid\":\"4532\",\"qtysum\":\"26\",\"qty\":\"2\",\"allocated\":\"50\",\"qtyalloc\":\"650\"},{\"eid\":\"4531\",\"pid\":\"14021\",\"display_date_start\":\"2015-07-09\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-30\",\"display_time_end\":\"11:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/blues-traveler-vvcnozapze.jpg\",\"shortDesc\":\"Blues Traveler\",\"eventid\":\"4531\",\"qtysum\":\"24\",\"qty\":\"2\",\"allocated\":\"20\",\"qtyalloc\":\"240\"},{\"eid\":\"4512\",\"pid\":\"13983\",\"display_date_start\":\"2015-07-07\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-22\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/Chris-Knight-Full-Band-Show----Radio-Birds-6MKdYVtJ7G.jpg\",\"shortDesc\":\"Chris Knight - Full Band Show! (Cleveland)\",\"eventid\":\"4512\",\"qtysum\":\"11\",\"qty\":\"2\",\"allocated\":\"10\",\"qtyalloc\":\"60\"},{\"eid\":\"4510\",\"pid\":\"13976\",\"display_date_start\":\"2015-07-06\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-26\",\"display_time_end\":\"11:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/sleeping-beauty---swan-lake--olmsted-falls--ypxp4ibejf.jpg\",\"shortDesc\":\"Sleeping Beauty \\/ Swan Lake (Olmsted Falls)\",\"eventid\":\"4510\",\"qtysum\":\"22\",\"qty\":\"2\",\"allocated\":\"50\",\"qtyalloc\":\"550\"},{\"eid\":\"4507\",\"pid\":\"14085\",\"display_date_start\":\"2015-07-15\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-23\",\"display_time_end\":\"16:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/camelot-at-mercury-theatre-company--s--euclid--acapyiviao.jpg\",\"shortDesc\":\"Camelot  (S. Euclid)\",\"eventid\":\"4507\",\"qtysum\":\"22\",\"qty\":\"2\",\"allocated\":\"30\",\"qtyalloc\":\"270\"},{\"eid\":\"4220\",\"pid\":\"13322\",\"display_date_start\":\"2015-06-29\",\"display_time_start\":\"00:00:00\",\"display_date_end\":\"2015-07-21\",\"display_time_end\":\"12:00:00\",\"isActive\":\"1\",\"city_id\":\"2\",\"image\":\"images\\/events\\/baseball---lake-county-captains-vs-fort-wayne---july-21--eastlake--kycbitiau3.jpg\",\"shortDesc\":\"Baseball - Lake County Captains vs Fort Wayne - July 21 (Eastlake)\",\"eventid\":\"4220\",\"qtysum\":\"56\",\"qty\":\"2\",\"allocated\":\"200\",\"qtyalloc\":\"5200\"}]}";


  //  public NetworkStringLoader(Context con, TextView tv) {
        public NetworkStringLoader(Context con, String user, String pass) {
        context = con;
            user_email = user;
            user_password = pass;
            rcount = 0;
    }

    public void requestString(String url) {
        // Tag used to cancel the request
        String tag_string_req = "string_req";
      //  jstr = xtestJstr;

        final ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading...");
        pDialog.show();


        //  StringRequest strReq = new StringRequest(Method.GET, url,
        StringRequest strReq = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      //  display.setText(response);
                        rcount++;
                        if (BuildConfig.DEBUG) {
                            int len = response.length();
                            Log.d("DEBUG", "INONR before req strlen ==" + len);
                            if (len > 0) { Log.d("DEBUG", "INONR before req str==" + response.substring(0,12)); }
                        }

                        pDialog.hide();
                        if (response.indexOf("success") != -1) {
                            Intent i = new Intent(context, EventList.class);
//                i.putExtra("jstr", jobj.toString() );
                            i.putExtra("jstr", response);
                            context.startActivity(i);
                        }
                        else {
                            Toast.makeText(context, "Login Failed Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                display.setText(error.toString());
                pDialog.hide();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                // the POST parameters:
                params.put("login_email", user_email);
                params.put("login_password", user_password);
                return params;
            }
        };

        // Adding request to request queue
        //   VolleySingleton.getInstance().addToRequestQueue(strReq, tag_string_req);
        VolleySingleton.getInstance(context).addToRequestQueue(strReq, tag_string_req);
        // return tag_string_req;
      //  return "rstr";
      //  return jstr;
    }

}
