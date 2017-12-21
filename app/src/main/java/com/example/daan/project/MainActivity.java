package com.example.daan.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener, AsyncResponse {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CheckFirstTime();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // AsyncTask task = new SteamAPI().execute("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=76561198129798218");
        Intent intent = getIntent();
        SharedPreferences pref;
        pref = getSharedPreferences("preferences", this.MODE_PRIVATE);

       //Map<String,String> test2= test.doInBackground("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=","getPlayerStats");










        if(pref.contains("steamid"))
        {
            String steamId = pref.getString("steamid","");
            SteamAPI test = new SteamAPI(MainActivity.this);


            test.execute("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=" + steamId, "getPlayerStats");




            // Log.w("TEST", "Pref contains steamid");

            Player p1=new Player("76561198129798218");
            //Log.w("TEST", "PlayerCreated");
            ImageView profileImg = (ImageView) findViewById(R.id.ProfileImage);
            TextView main = (TextView) findViewById(R.id.MainText);
            main.setText(Integer.toString(p1.getTotalKills()));
           // profileImg.setImageURI("");
        }

        //Log.w("TEST", Integer.toString(mPlayer.getTotalKills()));
        //C8E2FB316FEBD12C2CD17BB2B06CDE14


    }

    @Override
    protected void onResume() {


        super.onResume();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_stats) {
            // Handle the camera action
        } else if (id == R.id.nav_friends) {

        } else if (id == R.id.nav_live) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
    public void onTaskCompleted(HashMap<String, String> response) {

    }
}

