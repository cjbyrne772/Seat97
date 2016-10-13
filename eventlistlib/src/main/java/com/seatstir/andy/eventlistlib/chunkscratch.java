/*

        //////////////////////////////////////////
        //get the data for the list of res
        VolleyResponseListener listener = new VolleyResponseListener() {
            @Override
            public void onError(String m) {Toast.makeText(resact.this, "login error", Toast.LENGTH_SHORT).show();}

            @Override
            public void onResponse(String response) {
                if (response.contains("success")){
                    /*
                    Intent i = new Intent(getApplicationContext(), EventList.class);
                    i.putExtra("jstr", response);
                    startActivity(i);
                    */
                    ParseAndFill(response);
                }
                else
                    Toast.makeText(resact.this, "Login failure, try again", Toast.LENGTH_SHORT).show();
            }
        };
        // Get the list of reservations for this user
        String urlString = "https://seatstir.com/ptapp/ptreslist.php";
        JsonObject json=new JsonObject();
        json.addProperty("act", "canceljso");
        //  JsonObject json=new JsonObject();
        json.addProperty("email", "info@seat.com");
        String jstr2 = json.toString();
        MakeStringRequest custr = new MakeStringRequest();
        custr.MakeCustomStringRequest(resact.this, urlString, listener, jstr);
       // String urlresupcaString = "https://seatstir.com/ptapp/ptresupca.php";

        ////////////////////////////////////////////////////
       // String jstr = new String(getIntent().getStringExtra("jstr"));
      //  ListOfRes = new ArrayList<ResactData>();
      //  resactAdapter = new ResactAdapter(getApplicationContext(), R.layout.custom_res, ListOfRes);
      //  resactAdapter = new ResactAdapter(Context.this, R.layout.custom_res, ListOfRes); //not an enclosing class
      //  resactAdapter = new ResactAdapter(getBaseContext(), R.layout.custom_res, ListOfRes); //rte dialog show

        /*
        /// start of old res filler
        ListOfRes = new ArrayList<ResactData>();
        tCurrentRes = (TextView) findViewById(R.id.textView2);
        resactAdapter = new ResactAdapter(getApplicationContext(), R.layout.custom_res, ListOfRes);
        //String jstr = getIntent().getStringExtra("jstr");
         String jstr = new String(getIntent().getStringExtra("jstr"));
         //  jstr = new String(getIntent().getStringExtra("jstr"));
        //   jstr = new String("focusstr");

        tCurrentRes.append(jstr);

        ResactData  resPlaceholder;
        resPlaceholder = new ResactData(32345); //sample data for test
        ListOfRes.add(resPlaceholder);
        resPlaceholder = new ResactData(32347);
        ListOfRes.add(resPlaceholder);
        resPlaceholder = new ResactData(32349);
        ListOfRes.add(resPlaceholder);
        /////// end of old Res Filler
        */
        //////////////////// new Res filler
        /*
        try {
            JSONObject jobjTop = new JSONObject(jstr);
            //we're really interested only in the event array
            JSONArray jsResList = jobjTop.getJSONArray("upcoming");

            int length = jsResList.length();
            Toast.makeText(getApplicationContext(), length + " Reservations ", Toast.LENGTH_LONG).show();

            for (int ic = 0; ic < length; ic++) {
                JSONObject c = jsResList.getJSONObject(ic);
                int rid = c.getInt("rid");
                String d = c.getString("shortDesc");
                ResactData itemPlaceholder = new ResactData(rid, d); // add a json constructor later new Resactdata(c)
                ListOfRes.add(itemPlaceholder);
            }
            //   myEvents.setAdapter(new CustomAdapter(this,testContents));
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        //////////////////////////////////// end of new res filler
        */
                */