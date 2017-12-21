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

public class SteamAPI extends AsyncTask<String, Void, Map<String,String>> {


   /* public interface AsyncResponse {
        void processFinish(Map<String,String> output);
    }*/


   // public AsyncResponse delegate = null;

   /* public SteamAPI(AsyncResponse delegate){
        this.delegate = delegate;
    }*/


    public static Map<String, String> PlayerInfoGlob = new Map<String, String>() {
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

    private Exception exception;
    static Map<String, String> PlayerStat;
    static Map<String, String> PlayerInfo;
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

    protected Map<String,String> doInBackground(String... urls) {
        String request = urls[0];

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
            Map<String,String> output=new Map<String, String>() {
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
                } else if (urls[1] == "getFriendsInfo") {
                    output=ParseJSONFriendlist(jObject);
                }


            } finally {
                //Log.w("TEST","DoInBg");
                urlConnection.disconnect();
                Log.w("TEST", "Return parsed stats");
                return output;
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            Log.w("TEST", "Error returning stats");
            return null;
        }
    }
    @Override
    protected void onPostExecute(Map<String,String> result) {
        Log.w("TEST", "onPostExecute: " );


        //delegate.processFinish(result);
    }


    protected  Map<String,String> ParseJSONPlayerInfo(JSONObject jObject) throws JSONException {
        JSONObject JPlayerInfo = jObject.getJSONObject("response");

        Log.w("TEST", JPlayerInfo.toString());
        JSONArray stats = JPlayerInfo.getJSONArray("players");
        JSONObject stat = stats.getJSONObject(0);
        Log.w("TEST", stat.toString());
        // Log.w("TEST",Integer.toString(stats.getJSONObject(0).getInt("value")));
        // Log.w("TEST",stats.getJSONObject(0).getString("name"));
        Map<String, String> player = new Map<String, String>() {
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
        for (int i = 0; i < userinfoJSON.length; i++) {
            player.put(userinfoJSON[i], stat.getString(userinfoJSON[i]));

        }
        return player;


    }

    protected  Map<String,String> ParseJSONPlayerStats(JSONObject jObject) throws JSONException {
        JSONObject JPlayerStats = jObject.getJSONObject("playerstats");
        // Log.w("TEST","test");
        //   Log.w("TEST",JPlayerStats.toString());

        JSONArray stats = JPlayerStats.getJSONArray("stats");
        //Log.w("TEST",Integer.toString(stats.getJSONObject(0).getInt("value")));
        //Log.w("TEST",stats.getJSONObject(0).getString("name"));

        Map<String, String> player = new Map<String, String>() {
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
        Log.w("TEST", "PlayerStats parsed");
       // Log.w("TEST", player.keySet().toArray()[0].toString());

        for (int i = 0; i < stats.length(); i++) {

            //Log.w("TEST", stats.getJSONObject(i).getString("name"));
           player.put(stats.getJSONObject(i).getString("name"), stats.getJSONObject(i).getString("value"));
            //Log.w("TEST", "Inside Json Parse Function" + " "+ stats.getJSONObject(i).getString("name")+ " " + stats.getJSONObject(i).getString("value"));
            //Log.w("TEST",Integer.toString(i)+ " " +stats.getJSONObject(i).getString("steamid") );

        }
       // PlayerStat = player;
        return player;

    }

    protected  Map<String,String> ParseJSONFriendlist(JSONObject jObject) throws JSONException {
        JSONObject JPlayerFriends = jObject.getJSONObject("friendslist");

        // Log.w("TEST",JPlayerFriends.toString());
        JSONArray friends = JPlayerFriends.getJSONArray("friends");
        //Log.w("TEST",Integer.toString(stats.getJSONObject(0).getInt("value")));
        //Log.w("TEST",stats.getJSONObject(0).getString("name"));

        Map<String, String> player = new Map<String, String>() {
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

        for (int i = 0; i < friends.length(); i++) {
            //  Log.w("TEST","Parsing Jason");

            player.put(Integer.toString(i), friends.getJSONObject(i).getString("steamid"));
            //Log.w("TEST",Integer.toString(i)+ " " +friends.getJSONObject(i).getString("steamid") );
        }
        return player;

    }



}








