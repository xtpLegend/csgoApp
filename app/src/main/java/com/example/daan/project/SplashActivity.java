package com.example.daan.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.util.HashMap;

public class SplashActivity extends AppCompatActivity implements RequestFinished,AsyncResponse{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent doneIntent = getIntent();
        Bundle doneBundle = doneIntent.getExtras();
        if (doneBundle!= null)
        {


            //Log.w("TEST", "SplashActivity P1 kills : " + p1.getTotalKills() );
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            CheckFirstTime();
            SharedPreferences pref;
            pref = getSharedPreferences("preferences", this.MODE_PRIVATE);

            if(pref.contains("steamid"))
            {
                String steamId = pref.getString("steamid","");
                //SteamAPI test = new SteamAPI(this);
                Player p2=new Player(steamId,this);





                // Log.w("TEST", "Pref contains steamid");

               // Player p1=new Player("76561198129798218");
                //Log.w("TEST", "PlayerCreated");

                // profileImg.setImageURI("");
            }

        }

    }



    public void CheckFirstTime()
    {
        SharedPreferences dataSave;
        dataSave = getSharedPreferences("preferences", this.MODE_PRIVATE);

        if(dataSave.contains("firstTime")){ // first run is happened
            //  Log.w("TEST", "Not FirtsRun");
        }
        else{ //  this is the first run of application
            SharedPreferences.Editor editor = dataSave.edit();
            editor.putString("firstTime", "yes");
            editor.apply();
            // Log.w("TEST", "FirtsRun");
            Intent intent = new Intent(this,StartScreen.class);
            //intent.putExtra("Text",text.getText().toString());
            startActivity(intent);
        }



    }


    @Override
    public void onTaskCompleted() {
        Log.w("TEST", "IntentSplash" );
        Intent intent = new Intent(this, SplashActivity.class);
        intent.putExtra("DoneLoading","True");
        startActivity(intent);
        finish();

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
}