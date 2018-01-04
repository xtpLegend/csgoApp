package com.example.daan.project;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by daan on 11.11.17.
 */

public class GetFriendStatsAPi extends AsyncTask<String, Void, HashMap<String,String>> {
    private FriendStatsResponse taskCompleted;


   /* public interface AsyncResponse {
        void processFinish(Map<String,String> output);
    }*/
   public GetFriendStatsAPi(FriendStatsResponse activityContext){
       this.taskCompleted = activityContext;
   }

   // public AsyncResponse delegate = null;

   /* public SteamAPI(AsyncResponse delegate){
        this.delegate = delegate;
    }*/


    public static HashMap<String, String> PlayerInfoGlob = new HashMap<>();

    private Exception exception;
    static HashMap<String, String> PlayerStat;
    static HashMap<String, String> PlayerInfo;
    private String[] userinfoJSON = {"steamid", "communityvisibilitystate", "profilestate", "personaname",
            "lastlogoff", "commentpermission", "profileurl", "avatar", "avatarmedium", "avatarfull", "personastate",
            "realname", "primaryclanid", "timecreated", "personastateflags", "loccountrycode", "locstatecode", "loccityid"
    };
   // private String[] userinfoJSON ={};


    //  public AsyncResponse delegate = null;

  /*  public SteamAPI(AsyncResponse delegate) {
        this.delegate = delegate;
    }*/


    private String request;

    protected void onPreExecute() {


    }

    protected HashMap<String,String> doInBackground(String... urls) {
        String request = urls[0];

        //String email = emailText.getText().toString();
          /*oauth_consumer_key=402cd382323ba752289b2d2d9973244e
          oauth_token=
          oauth_signature_method=HMAC-SHA1
          oauth_version=1.0
          */
        // Do some validation here
         HashMap<String,String> output=new HashMap<>();

        try {
            URL url = new URL(request);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            //alleen als het een beveiligde api is
            //urlConnection.setRequestProperty("", API_KEY);
            //Get of Post
            urlConnection.setRequestMethod("GET");
            try {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                Log.w("TEST", "BufferedReader");
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                //Log.w("test", stringBuilder.toString() );
                JSONObject jObject = new JSONObject(stringBuilder.toString());
                if (urls[1] == "getPlayerStats") {
                    Log.w("TEST", "JASON Stats");
                    output= ParseJSONPlayerStats(jObject);
                } else if (urls[1] == "getPlayerInfo") {
                    Log.w("TEST", "JASON Info");
                    output=ParseJSONPlayerInfo(jObject);
                }
            } finally {
                //Log.w("TEST","DoInBg");
                urlConnection.disconnect();


            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            Log.w("TEST", "Error returning stats");
            return null;
        }
        Log.w("TEST", output.toString());
        return output;
    }

    @Override
    protected void onPostExecute(HashMap<String,String> result) {
        Log.w("TEST", "onPostExecute: " );



        taskCompleted.onFriendResponseCompeted(result);


        //delegate.processFinish(result);
    }


    protected  HashMap<String,String> ParseJSONPlayerInfo(JSONObject jObject) throws JSONException {
        JSONObject JPlayerInfo = jObject.getJSONObject("response");

        Log.w("TEST", JPlayerInfo.toString());
        JSONArray stats = JPlayerInfo.getJSONArray("players");
        JSONObject stat = stats.getJSONObject(0);
        Log.w("TEST", stat.toString());
        // Log.w("TEST",Integer.toString(stats.getJSONObject(0).getInt("value")));
        // Log.w("TEST",stats.getJSONObject(0).getString("name"));
        HashMap<String, String> player = new HashMap<>();
        player.put("Type","PlayerInfo");
        for (int i = 0; i < stat.length(); i++) {
            if (stat.has(userinfoJSON[i]))
            {
                player.put(userinfoJSON[i], stat.get(userinfoJSON[i]).toString());

            }
            else
            {
                player.put(userinfoJSON[i].toString(),"NotImplemented");

            }
        }
        Log.w("TEST", player.toString() );
        return player;


    }

    protected  HashMap<String,String> ParseJSONPlayerStats(JSONObject jObject) throws JSONException {
        JSONObject JPlayerStats = jObject.getJSONObject("playerstats");
        // Log.w("TEST","test");
        //   Log.w("TEST",JPlayerStats.toString());

        JSONArray stats = JPlayerStats.getJSONArray("stats");
        //Log.w("TEST",Integer.toString(stats.getJSONObject(0).getInt("value")));
        //Log.w("TEST",stats.getJSONObject(0).getString("name"));

        HashMap<String,String> player = new HashMap<>();
        Log.w("TEST", "PlayerStats parsed");
       // Log.w("TEST", player.keySet().toArray()[0].toString());
       player.put("Type","PlayerStats");
        for (int i = 0; i < stats.length(); i++) {

            //Log.w("TEST", stats.getJSONObject(i).getString("name"));
          player.put(stats.getJSONObject(i).getString("name").trim(), stats.getJSONObject(i).getString("value").trim());

           // Log.w("TEST", "Inside Json Parse Function" + " "+ stats.getJSONObject(i).getString("name")+ " " + stats.getJSONObject(i).getString("value"));
            //Log.w("TEST",Integer.toString(i)+ " " +stats.getJSONObject(i).getString("steamid") );

        }
       // PlayerStat = player;
      //  Log.w("TEST", "killssss : "+player.get("total_kills") );
        //Log.w("TEST", player.get("total_kills"));
        return player;

    }

    protected  HashMap<String,String> ParseJSONFriendlist(JSONObject jObject) throws JSONException {
        JSONObject JPlayerFriends = jObject.getJSONObject("friendslist");

        // Log.w("TEST",JPlayerFriends.toString());
        JSONArray friends = JPlayerFriends.getJSONArray("friends");
        //Log.w("TEST",Integer.toString(stats.getJSONObject(0).getInt("value")));
        //Log.w("TEST",stats.getJSONObject(0).getString("name"));

        HashMap<String, String> player = new HashMap<>();
        player.put("Type","Friendlist");
        for (int i = 0; i < JPlayerFriends.length(); i++) {
            //  Log.w("TEST","Parsing Jason");

            player.put(Integer.toString(i), friends.getJSONObject(i).getString("steamid"));
            //Log.w("TEST",Integer.toString(i)+ " " +friends.getJSONObject(i).getString("steamid") );
        }
        return player;

    }



}








