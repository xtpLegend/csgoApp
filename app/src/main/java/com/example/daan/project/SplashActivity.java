package com.example.daan.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SplashActivity extends AppCompatActivity implements RequestFinished, AsyncResponse, FriendRequestFinished, FriendStatsResponse {
    static int friendCounter;
    static Player mp;
    SharedPreferences pref;
    static boolean networkStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        networkStatus=isNetworkAvailable();
        super.onCreate(savedInstanceState);
        Intent doneIntent = getIntent();
        Bundle doneBundle = doneIntent.getExtras();

        if (doneBundle != null) {
            //Log.w("TEST", "SplashActivity P1 kills : " + p1.getTotalKills() );
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            CheckFirstTime();
            SharedPreferences preferences;
            preferences = getSharedPreferences("preferences", this.MODE_PRIVATE);

            if (preferences.contains("steamid")) {
                String steamId = preferences.getString("steamid", "");
                //SteamAPI test = new SteamAPI(this);
                if (isNetworkAvailable())
                {
                    Player p2 = new Player(steamId, this);
                    p2.save();
                }
                else
                {
                    Player p = Player.findById(Player.class, (long) 1);
                    Log.w("TEST",Integer.toString(p.getTotalKills()));
                    Intent intentMain= new Intent(this, MainActivity.class);
                    startActivity(intentMain);
                    finish();

                }


                // Log.w("TEST", "Pref contains steamid");

                // Player p1=new Player("76561198129798218");
                //Log.w("TEST", "PlayerCreated");

                // profileImg.setImageURI("");
            }
        }
    }


    public void CheckFirstTime() {
        SharedPreferences dataSave;
        dataSave = getSharedPreferences("preferences", this.MODE_PRIVATE);

        if (dataSave.contains("firstTime")) { // first run is happened
            //  Log.w("TEST", "Not FirtsRun");
        } else if (!dataSave.contains("steamid")) {
            Intent intent = new Intent(this, StartScreen.class);
            //intent.putExtra("Text",text.getText().toString());
            startActivity(intent);
            finish();
        } else { //  this is the first run of application


        }


    }

    //Wordt aangeroepen als de volledige Player request klaar is
    @Override
    public void onTaskCompleted() {
        pref = getSharedPreferences("Friends",MODE_PRIVATE);
        mp = new Player();
        //friendCounter=mp.getFriendList().size();
        if (pref.contains("Friends")){
            friendCounter =pref.getStringSet("Friends",null).size() ;
        }
        else {
            friendCounter=mp.getFriendList().size();
        }

            Friend f1 = new Friend(mp.getFriendList().get("1"), this,true);




    }

    @Override
    public void onTaskCompleted(HashMap<String, String> response) {
        Log.w("TEST", "AsyncResponseSplash");
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    // Wordt aangeroepen als een friend request gedaan is
    @Override
    public void friendRequestCompleted() {
        pref=getSharedPreferences("Friends",MODE_PRIVATE);
        if (friendCounter == 0 && !pref.contains("Friends")) {
            Log.w("TEST", "IntentSplash");
            Intent intent = new Intent(this, ChooseFriends.class);
            intent.putExtra("DoneLoading", "True");
            startActivity(intent);
            // Log.w("TEST", Friend.tempFriendInfo.get(1).get("steamid") );
            finish();
        }
        else if (pref.contains("Friends")&& friendCounter != 0)
        {


            Set<String>friendList= pref.getStringSet("Friends",null);
            String test= friendList.toArray()[0].toString();
            Friend tmp = new Friend(friendList.toArray()[friendCounter-1].toString(), this,true);
            friendCounter--;
        }
        else if (pref.contains("Friends")&& friendCounter == 0)
        {

            ArrayList<Friend> te = Friend.tempFriendlist;
            Log.w("TEST", Friend.tempFriendlist.get(1).getPlayerName());
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();


        }
        else
        {
            HashMap<String, String> friendList = mp.getFriendList();
            friendCounter--;
            Friend tmp = new Friend(friendList.get(Integer.toString(friendCounter)), this);
        }

    }


    @Override
    public void onFriendResponseCompeted(HashMap<String, String> response) {
        Log.w("TEST", "FriendResponseSplash");
    }
}