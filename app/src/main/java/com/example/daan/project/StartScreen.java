package com.example.daan.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }


    public void saveSteamId(View v)
    {
        EditText steamIdtext=(EditText)findViewById(R.id.SteamIDText);
        String steamId = steamIdtext.getText().toString();
           Intent intent = new Intent(this,SplashActivity.class);
        //intent.putExtra("SteamId",steamId.getText().toString());
        //steamId.getText();

        SharedPreferences dataSave;
        dataSave = getSharedPreferences("preferences", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = dataSave.edit();
        Log.w("TEST", steamId.toString() );
        editor.putString("steamid", steamId.toString());
        editor.apply();

        startActivity(intent);
    }
}
