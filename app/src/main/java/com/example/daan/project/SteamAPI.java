package com.example.daan.project;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by daan on 11.11.17.
 */
    public class SteamAPI extends AsyncTask<String, Void, String> {
        private Exception exception;


    public interface AsyncResponse {
        void processFinish(int output);
    }

    public AsyncResponse delegate = null;

    public SteamAPI(AsyncResponse delegate){
        this.delegate = delegate;
    }


    private String request;
        protected void onPreExecute() {

            //progressBar.setVisibility(View.VISIBLE);
           // responseView.setText("");
        }

        protected  String doInBackground(String... urls) {
            String request =  urls[0];
            //String email = emailText.getText().toString();
          /*oauth_consumer_key=402cd382323ba752289b2d2d9973244e
          oauth_token=
          oauth_signature_method=HMAC-SHA1
          oauth_version=1.0
          */
            // Do some validation here

            try {
                URL url = new URL(request);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                //alleen als het een beveiligde api is
                //urlConnection.setRequestProperty("", API_KEY);
                //Get of Post
                urlConnection.setRequestMethod("GET");
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                   //Log.w("test", stringBuilder.toString() );
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {


            try {

             //   JSONObject on=response.getJSONObject("data");
              //  jsonarray = on.getJSONArray("current_condition");

                JSONObject jObject = new JSONObject(response);
                JSONObject JPlayerStats = jObject.getJSONObject("playerstats");
                Log.w("TEST",JPlayerStats.toString());
                JSONArray stats = JPlayerStats.getJSONArray("stats");
                Log.w("TEST",Integer.toString(stats.getJSONObject(0).getInt("value")));
                int totalkill = stats.getJSONObject(0).getInt("value");

               // int totalkill = kils.getInt("total_kills");
                //Log.w("TEST",Integer.toString(totalkill));
               // JSONArray jArray = jObject.getJSONArray("stats");
               // JSONObject oneObject = jArray.getJSONObject(i);
                ///int kills = JStats.getInt("total_kills");


                delegate.processFinish(totalkill);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


}








