package com.example.daan.project;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
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
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by daan on 11.11.17.
 */
    public class SteamAPI extends AsyncTask<String, Void, String> {
        private Exception exception;


    public interface AsyncResponse {
        void processFinish(Map<String,String> output);
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
                    JSONObject jObject = new JSONObject(stringBuilder.toString());
                    if (urls[1]=="getPlayerStats")
                    {
                        ParseJSONPlayerStats(jObject);
                    }
                    else if (urls[1]=="getPlayerInfo")
                    {
                        ParseJSONPlayerInfo(jObject);
                    }
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



                //int totalkill = stats.getJSONObject(0).getInt("value");

               // int totalkill = kils.getInt("total_kills");
                //Log.w("TEST",Integer.toString(totalkill));
               // JSONArray jArray = jObject.getJSONArray("stats");
               // JSONObject oneObject = jArray.getJSONObject(i);
                ///int kills = JStats.getInt("total_kills");




            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        protected void ParseJSONPlayerInfo(JSONObject jObject) throws JSONException {
            JSONObject JPlayerInfo = jObject.getJSONObject("response");
          Log.w("TEST",JPlayerInfo.toString());
            JSONArray stats = JPlayerInfo.getJSONArray("players");
            //Log.w("TEST",Integer.toString(stats.getJSONObject(0).getInt("value")));
           // Log.w("TEST",stats.getJSONObject(0).getString("name"));
            Map<String,String>player = new Map<String, String>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean containsKey(Object key) {
                    return false;
                }

                @Override
                public boolean containsValue(Object value) {
                    return false;
                }

                @Override
                public String get(Object key) {
                    return null;
                }

                @Override
                public String put(String key, String value) {
                    return null;
                }

                @Override
                public String remove(Object key) {
                    return null;
                }

                @Override
                public void putAll(@NonNull Map<? extends String, ? extends String> m) {

                }

                @Override
                public void clear() {

                }

                @NonNull
                @Override
                public Set<String> keySet() {
                    return null;
                }

                @NonNull
                @Override
                public Collection<String> values() {
                    return null;
                }

                @NonNull
                @Override
                public Set<Entry<String, String>> entrySet() {
                    return null;
                }
            };
            for (int i=0;i>stats.length();i++)
            {
                player.put(stats.getJSONObject(i).getString("name").toString(),stats.getJSONObject(i).getString("value"));
            }
            delegate.processFinish(player);
        }
        protected void ParseJSONPlayerStats(JSONObject  jObject) throws JSONException {
            JSONObject JPlayerStats = jObject.getJSONObject("playerstats");
            Log.w("TEST","test");
            Log.w("TEST",JPlayerStats.toString());
            JSONArray stats = JPlayerStats.getJSONArray("stats");
            //Log.w("TEST",Integer.toString(stats.getJSONObject(0).getInt("value")));
            //Log.w("TEST",stats.getJSONObject(0).getString("name"));

            Map<String,String>player= new Map<String, String>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean containsKey(Object key) {
                    return false;
                }

                @Override
                public boolean containsValue(Object value) {
                    return false;
                }

                @Override
                public String get(Object key) {
                    return null;
                }

                @Override
                public String put(String key, String value) {
                    return null;
                }

                @Override
                public String remove(Object key) {
                    return null;
                }

                @Override
                public void putAll(@NonNull Map<? extends String, ? extends String> m) {

                }

                @Override
                public void clear() {

                }

                @NonNull
                @Override
                public Set<String> keySet() {
                    return null;
                }

                @NonNull
                @Override
                public Collection<String> values() {
                    return null;
                }

                @NonNull
                @Override
                public Set<Entry<String, String>> entrySet() {
                    return null;
                }
            };
            for (int i=0;i>stats.length();i++)
            {
                player.put(stats.getJSONObject(i).getString("name").toString(),stats.getJSONObject(i).getString("value"));
            }
            delegate.processFinish(player);
        }

}








