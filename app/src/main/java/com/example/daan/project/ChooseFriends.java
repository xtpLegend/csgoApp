package com.example.daan.project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class ChooseFriends extends Activity {
    ArrayList dataModels;
    ListView listView;

   FriendListWithCheckboxAdapter adapter;
    SharedPreferences dataSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_friends);
        listView = (ListView) findViewById(R.id.listView);
        final Button btn = (Button) findViewById(R.id.btnSave);
        ArrayList<String> playerList = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        ArrayList<Friend> test=Friend.tempFriendlist;
        for (int i=0;i<Friend.tempFriendlist.size();i++)
        {
            playerList.add(Friend.tempFriendlist.get(i).getPlayerName());
            id.add(Friend.tempFriendlist.get(i).getSteamId());

        }
        adapter =new FriendListWithCheckboxAdapter(playerList,id,getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

              //  String dataModel= dataModels.get(position);

                adapter.changeChecked(position);

                adapter.notifyDataSetChanged();




            }
        });

        dataSave = getSharedPreferences("preferences", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = dataSave.edit();
        editor.putString("firstTime", "yes");
        editor.apply();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void Onclick(View v)
    {
        ArrayList<Boolean> checked = adapter.getCheckedBox();
        ArrayList<String> friendlist = adapter.getDataSet();
        ArrayList<String> id = adapter.getId();
        HashSet<String> savedFriends=new HashSet<>();
        for (int i=0;i<friendlist.size();i++)
        {
            if (checked.get(i))
            {
                savedFriends.add(id.get(i));
            }

        }
        SharedPreferences prefs = getSharedPreferences("Friends", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putStringSet("Friends",savedFriends);
        editor.commit();

        Intent intent = new Intent(this,SplashActivity.class);
        editor.putString("FriendPref","done" );
        editor.apply();
        startActivity(intent);
    }


}

