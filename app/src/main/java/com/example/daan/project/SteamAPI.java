package com.example.daan.project;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by daan on 11.11.17.
 */
    public class SteamAPI extends AsyncTask<Void, Void, String> {
        private Exception exception;
        protected void onPreExecute() {
            // progressBar.setVisibility(View.VISIBLE);
            // responseView.setText("");
        }

        protected  String doInBackground(Void... urls) {
            //String email = emailText.getText().toString();
          /*oauth_consumer_key=402cd382323ba752289b2d2d9973244e
          oauth_token=
          oauth_signature_method=HMAC-SHA1
          oauth_version=1.0
          */
            // Do some validation here
            try {
                URL url = new URL("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=76561198129798218");
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
                   // Log.w("test", stringBuilder.toString() );
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
                jObject = jObject.getJSONObject("playerstats");
                JSONArray jArray = jObject.getJSONArray("stats");



                for (int i=0; i < jArray.length(); i++)
                {
                    try {
                        JSONObject oneObject = jArray.getJSONObject(i);
                        // Pulling items from the array
                        int kils = oneObject.getInt("total_kills");

                       // String oneObjectsItem2 = oneObject.getString("anotherSTRINGNAMEINtheARRAY");
                    } catch (JSONException e) {
                        // Oops
                    }
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
            }








