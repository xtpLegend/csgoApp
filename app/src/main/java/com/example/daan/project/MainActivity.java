package com.example.daan.project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AsyncResponse, Stats.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Player mainPlayer = new Player();
        Stats t = Stats.newInstance(mainPlayer);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flContent, t).commit();

        //Map<String,String> test2= test.doInBackground("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=","getPlayerStats");


        // t=(TextView) findViewById(R.id.MainText);
        //  t.setText(Integer.toString(MainPlayer.getTotalKills()));
        //  TextView a;
        //  // a=(TextView) findViewById(R.id.SecondeText);
        //  a.setText(MainPlayer.getPlayerName());
        //  TextView z;
        // z=(TextView) findViewById(R.id.SecondeText);
        //z.setText(MainPlayer.);


        Intent doneIntent = getIntent();
        Bundle doneBundle = doneIntent.getExtras();
        if (doneBundle != null) {
            String data = getIntent().getExtras().get("DoneLoading").toString();

        }


        //  Log.w("TEST", mainPlayer.getProfilePicture_large() );
        new DownloadImageTask((ImageView) findViewById(R.id.avatar))
                .execute(mainPlayer.getProfilePicture_large());


        //Log.w("TEST", Integer.toString(mPlayer.getTotalKills()));
        //C8E2FB316FEBD12C2CD17BB2B06CDE14


    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            //bmImage.setImageBitmap(result);
        }
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
        FriendItemFragment fragment = null;
        Class fragmentClass;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_stats) {
            Log.w("TEST", "Drawer : Stats");
            // Handle the camera action
        } else if (id == R.id.nav_friends) {
            if (findViewById(R.id.flContent) != null) {
                FriendItemFragment t= new FriendItemFragment();

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flContent, t);
                ft.commit();
            }

        } else if (id == R.id.nav_live) {
            Log.w("TEST", "Drawer : Live");

        } else if (id == R.id.nav_share) {

            Log.w("TEST", "Drawer : Share");
        } else if (id == R.id.nav_send) {
            Log.w("TEST", "Drawer : Send");

        } else {

        }
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //  fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        //  item.setChecked(true);
        // Set action bar title
        // setTitle(item.getTitle());
        // Close the navigation drawer


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        onNavigationItemSelected(menuItem);
                        return true;
                    }
                });
    }


    @Override
    public void onTaskCompleted(HashMap<String, String> response) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onFriendSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout
        Stats statsfrag = (Stats)
                getSupportFragmentManager().findFragmentById(R.id.statsFragment);

        if (statsfrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            statsfrag.updateStatsView(position);

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            Stats newFragment = new Stats();
            Bundle args = new Bundle();
            args.putInt(Stats.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.flContent, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

}

