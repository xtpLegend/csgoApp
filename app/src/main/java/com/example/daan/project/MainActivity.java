package com.example.daan.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AsyncResponse, Stats.OnFragmentInteractionListener, FriendListFragment.OnHeadlineSelectedListener {

    Player mainPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (SplashActivity.networkStatus) {
            mainPlayer = new Player("player");
            mainPlayer.save();

        } else {
            mainPlayer = Player.findById(Player.class, (long) 1);
        }
        Stats t = Stats.newInstance(mainPlayer.getSteamId());


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


        //Log.w("TEST", Integer.toString(mPlayer.getTotalKills()));
        //C8E2FB316FEBD12C2CD17BB2B06CDE14
        TextView view = (TextView) findViewById(R.id.hidden);
        String tag = view.getTag().toString();

        if (tag.equals("large")) {
            Player mp = mainPlayer;
            Stats s = Stats.newInstance(mp.getSteamId());
            FriendListFragment f = new FriendListFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.flContent1, s).commit();
            // ft.beginTransaction().replace(R.id.flContent2, s).commit();
            Log.w("TEST", "onNavigationItemSelected: ");
        } else if (tag.equals("normal")) {
            Player p = mainPlayer;
            Stats s = Stats.newInstance(p.getSteamId());
            FragmentManager ft = getSupportFragmentManager();
            ft.beginTransaction().replace(R.id.flContent, s).commit();
        }


    }

    @Override
    public void onArticleSelected(int position, String steamid) {
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout
        Stats stats = (Stats)
                getSupportFragmentManager().findFragmentById(R.id.fragmentFriend);

        if (stats != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            stats.updateStatsView(position);

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            Stats newFragment = Stats.newInstance(steamid);
            Bundle args = new Bundle();
            args.putInt(Stats.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            TextView view = (TextView) findViewById(R.id.hidden);
            String tag = view.getTag().toString();
            if (tag.equals("large")) {
                transaction.replace(R.id.flContent2, newFragment);
                transaction.addToBackStack(null);
            } else if (tag.equals("normal")) {
                transaction.replace(R.id.flContent, newFragment);
                transaction.addToBackStack(null);
            }

            // Commit the transaction
            transaction.commit();
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


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();
        TextView view = (TextView) findViewById(R.id.hidden);
        if (id == R.id.nav_stats) {
            Log.w("TEST", "Drawer : Stats");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_friends) {
            if (SplashActivity.networkStatus) {


                FriendListFragment fragment = new FriendListFragment();
                String tag = view.getTag().toString();


                if (tag.equals("large")) {
                    SharedPreferences pref = getSharedPreferences("Friends", MODE_PRIVATE);
                    ArrayList<String> nameList = new ArrayList<>();
                    HashMap<String, String> list = new HashMap<>();
                    Set<String> t = pref.getStringSet("Friends", null);
                    for (int i = 0; i < t.size(); i++) {

                        for (int a = 0; a < Friend.tempFriendlist.size(); a++) {
                            if (Friend.tempFriendlist.get(a).getSteamId().toString().equals(t.toArray()[i].toString())) {
                                nameList.add(Friend.tempFriendlist.get(a).getPlayerName());
                                list.put(Friend.tempFriendlist.get(a).getPlayerName(), t.toArray()[i].toString());
                            }
                        }

                    }

                    Player p = new Player("player");
                    Stats s = Stats.newInstance(Friend.tempFriendlist.get(0).getSteamId());
                    FriendListFragment f = FriendListFragment.init(nameList, list);
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentManager fm2 = getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.flContent1, f).commit();
                    fm2.beginTransaction().replace(R.id.flContent2, s).commit();
                    Log.w("TEST", "onNavigationItemSelected: ");
                } else if (tag.equals("normal")) {
                    SharedPreferences pref = getSharedPreferences("Friends", MODE_PRIVATE);
                    ArrayList<String> nameList = new ArrayList<>();
                    HashMap<String, String> list = new HashMap<>();
                    Set<String> t = pref.getStringSet("Friends", null);
                    for (int i = 0; i < t.size(); i++) {

                        for (int a = 1; a < Friend.tempFriendlist.size(); a++) {
                            if (Friend.tempFriendlist.get(a).getSteamId().equals(t.toArray()[i].toString())) {
                                nameList.add(Friend.tempFriendlist.get(a).getPlayerName());
                                list.put(Friend.tempFriendlist.get(a).getPlayerName(), t.toArray()[i].toString());

                            }

                        }


                    }

                    FriendListFragment f2 = FriendListFragment.init(nameList, list);
                    FragmentManager ft = getSupportFragmentManager();
                    ft.beginTransaction().replace(R.id.flContent, f2).commit();
                }
            }
            else {
                Snackbar noInternet = Snackbar.make(view, getResources().getString(R.string.no_internet), Snackbar.LENGTH_LONG);
                noInternet.show();
            }


            } else if (id == R.id.nav_live) {

                Snackbar noInternet = Snackbar.make(view, getResources().getString(R.string.not_yet_implemented), Snackbar.LENGTH_LONG);
                noInternet.show();
            }

             else if (id == R.id.nav_share) {

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

  /*  public void onFriendSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout
        Stats statsfrag = (Stats)
                getSupportFragmentManager().findFragmentById(R.id.);

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
    }*/

}

