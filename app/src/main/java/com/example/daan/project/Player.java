package com.example.daan.project;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.util.LogWriter;
import android.util.Log;

import com.orm.SugarRecord;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by daan on 11.11.17.
 */

public class Player extends SugarRecord<Player>implements AsyncResponse  {
    private static RequestFinished requestFinished;

    public static String MainPlayerSteamId;
    private HashMap<String,HashMap<String,String>>friendStats = new HashMap<>();
    private HashMap<String,HashMap<String,String>>friendInfo = new HashMap<>();
    private HashMap<String, String> friendList = new HashMap<>();
    //Global stats
    private SteamAPI API = new SteamAPI(this);

    public String getPlayerName() {
        return playerName;
    }

    private String playerName;
    private String SteamId;
    private int totalTimePlayed;
    private int totalKills;
    private int totalWinsPistolRound;
    private int totalShots;
    private int totalHits;
    private int totalDeaths;
   static HashMap<String, String> TempStats = new HashMap<>();


 /*   private Map<String, String> getAllPlayerStatsApi(String steamId) {
        SteamAPI getPlayerStatsAsync = (SteamAPI) new SteamAPI(new SteamAPI.AsyncResponse() {
            // MainPlayer mPlayer=new MainPlayer();

            @Override
            public void processFinish(Map<String, String> output) {
                tempPlayerStats = output;
                // Mplayer.setTotalKills((Integer)output.get("total_kills"));


                //Log.w("TEST", Integer.toString(output) );
                Log.w("TEST", "GetAllPlayerStats");
            }
        }).execute("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=" + steamId, "getPlayerStats");

        return tempPlayerStats;
    }*/


    private String profilePicture;
    private static HashMap<String, String> tempPlayerStats = new HashMap<>();
    private static HashMap<String, String> tempPlayerInfo = new HashMap<>();
    private int totalBomPlants;
    private int totalBomDefuses;
    private int totalDamageDone;
    private int totalMoneyEarned;
    private int totalHeadshots;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }


    //WeaponStats
    private HashMap<String, Integer> weaponKills = new HashMap<>();

    private HashMap<String, Integer> weaponAccuracy = new HashMap<>();
    private HashMap<String, Integer> weaponShots = new HashMap<>();
    private HashMap<String, Integer> weaponHits = new HashMap<>();
    private HashMap<String, Integer> mapRounds = new HashMap<>();
    private HashMap<String, Integer> mapWins = new HashMap<>();
    //lastMtachStats
    private int lastMatchTwins;
    private int lastMatchCTWins;
    private int lastMatchWins;
    private int lastMatchKils;
    private int lastMatchDeaths;
    private int lastMatchFavWeapon;
    private int lastMatchFavWeaponShots;
    private int lastMatchFavWeaponHits;
    private int lastMatchFavWeaponKils;
    private int lastMatchMVP;
    private int lastMatchMoneySpent;


    private static HashMap<String, String> friendlist = new HashMap<>();




    //Steam profile info
    //http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamids=76561197960435530

    //Inventory
    //http://api.steampowered.com/IEconItems_440/GetPlayerItems/v0001/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=76561198129798218

    //Games play time
    //http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=76561198129798218&format=json

    //Better api doc
    //http://steamwebapi.azurewebsites.net/

    //get friends
    //http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=76561198129798218&relationship=friend
    /*private Map<String, String> getAllPlayerInfoApi(String steamId) {
        SteamAPI getPlayerInfoAsync = (SteamAPI) new SteamAPI(new SteamAPI.AsyncResponse() {
            // MainPlayer mPlayer=new MainPlayer();


            @Override
            public void processFinish(Map<String, String> output) {
                tempPlayerInfo = output;

                // Mplayer.setTotalKills((Integer)output.get("total_kills"));
                // Log.w("TEST", Integer.toString(Mplayer.getTotalKills()));
                //Log.w("TEST", Integer.toString(output) );
            }
        }).execute("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamids=" + steamId, "getPlayerInfo");

        Log.w("TEST", "1234");
        return tempPlayerInfo;
    }*/


  /*  private Map<String, String> getAllPlayerFriendsApi(String steamId) {


        SteamAPI getPlayerFriendsAsync = (SteamAPI) new SteamAPI(new SteamAPI.AsyncResponse() {
            //MainPlayer mPlayer=new MainPlayer();

            @Override
            public void processFinish(Map output) {
                tempPlayerFriends = output;
                // Mplayer.setTotalKills((Integer)output.get("total_kills"));
                // Log.w("TEST", Integer.toString(Mplayer.getTotalKills()));
                //Log.w("TEST", Integer.toString(output) );

            }
        }).execute("http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=" + steamId + "&relationship=friend", "getFriendsInfo");
        return tempPlayerFriends;

    }*/
    public  void getStats(String steamId)
    {
        API.execute("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=" + steamId, "getPlayerStats");


    }
    public  void getFriends(String steamId)
    {
        API.execute("http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid="+ steamId +"&relationship=friend" , "getPlayerFriends");

    }
    public  void getPlayerInfo(String steamId)
    {
        API.execute("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamids=" + steamId, "getPlayerInfo");
    }

    public void init(String steamId,int level)
    {
        MainPlayerSteamId = steamId;
        switch (level)
        {
            case 1 :getStats(steamId);
            break;
            case 2:getPlayerInfo(steamId);
            break;
            case 3:getFriends(steamId);
            break;

        }


       // getFriends(steamId);
       /* for (int i=0;i<friendList.size();i++)
        {
            getFriendStats(friendList.get(i).toString(),0);
        }*/
    }

    public Player(String steamId,RequestFinished activityContext) {
        Log.w("TEST", "Start Creating Player");
        requestFinished=activityContext;
       init(steamId,1);


    }

    public Player() {
        //this.friendStats = friendStats;
        //this.friendInfo = friendInfo;
       // this.friendList = ;

        this.playerName = tempPlayerInfo.get("personaname");
        SteamId = tempPlayerInfo.get("steamid");
        this.totalTimePlayed =Integer.parseInt(tempPlayerStats.get("total_time_played"));
        this.totalKills = Integer.parseInt(tempPlayerStats.get("total_kills"));
        this.totalWinsPistolRound = totalWinsPistolRound;
        this.totalShots = totalShots;
        this.totalHits = totalHits;
        this.totalDeaths = totalDeaths;
        this.profilePicture = profilePicture;
        this.totalBomPlants = totalBomPlants;
        this.totalBomDefuses = totalBomDefuses;
        this.totalDamageDone = totalDamageDone;
        this.totalMoneyEarned = totalMoneyEarned;
        this.totalHeadshots = totalHeadshots;
        this.weaponKills = weaponKills;
        this.weaponAccuracy = weaponAccuracy;
        this.weaponShots = weaponShots;
        this.weaponHits = weaponHits;
        this.mapRounds = mapRounds;
        this.mapWins = mapWins;
        this.lastMatchTwins = lastMatchTwins;
        this.lastMatchCTWins = lastMatchCTWins;
        this.lastMatchWins = lastMatchWins;
        this.lastMatchKils = lastMatchKils;
        this.lastMatchDeaths = lastMatchDeaths;
        this.lastMatchFavWeapon = lastMatchFavWeapon;
        this.lastMatchFavWeaponShots = lastMatchFavWeaponShots;
        this.lastMatchFavWeaponHits = lastMatchFavWeaponHits;
        this.lastMatchFavWeaponKils = lastMatchFavWeaponKils;
        this.lastMatchMVP = lastMatchMVP;
        this.lastMatchMoneySpent = lastMatchMoneySpent;
    }

    //"http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=76561198129798218"
    public int getTotalBomPlants() {
        return totalBomPlants;
    }

    public int getTotalBomDefuses() {
        return totalBomDefuses;
    }

    public int getTotalDamageDone() {
        return totalDamageDone;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public int getTotalHeadshots() {
        return totalHeadshots;
    }

    public int getLastMatchTwins() {
        return lastMatchTwins;
    }

    public int getLastMatchCTWins() {
        return lastMatchCTWins;
    }

    public int getLastMatchWins() {
        return lastMatchWins;
    }

    public int getLastMatchKils() {
        return lastMatchKils;
    }

    public int getLastMatchDeaths() {
        return lastMatchDeaths;
    }

    public int getLastMatchFavWeapon() {
        return lastMatchFavWeapon;
    }

    public int getLastMatchFavWeaponShots() {
        return lastMatchFavWeaponShots;
    }

    public int getLastMatchFavWeaponHits() {
        return lastMatchFavWeaponHits;
    }

    public int getLastMatchFavWeaponKils() {
        return lastMatchFavWeaponKils;
    }

    public int getLastMatchMVP() {
        return lastMatchMVP;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public int getLastMatchMoneySpent() {
        return lastMatchMoneySpent;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setSteamId(String steamId) {
        SteamId = steamId;
    }

    public void setTotalTimePlayed(int totalTimePlayed) {
        this.totalTimePlayed = totalTimePlayed;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public void setTotalWinsPistolRound(int totalWinsPistolRound) {
        this.totalWinsPistolRound = totalWinsPistolRound;
    }

    public void setTotalShots(int totalShots) {
        this.totalShots = totalShots;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public void setTotalBomPlants(int totalBomPlants) {
        this.totalBomPlants = totalBomPlants;
    }

    public void setTotalBomDefuses(int totalBomDefuses) {
        this.totalBomDefuses = totalBomDefuses;
    }

    public void setTotalDamageDone(int totalDamageDone) {
        this.totalDamageDone = totalDamageDone;
    }

    public void setTotalMoneyEarned(int totalMoneyEarned) {
        this.totalMoneyEarned = totalMoneyEarned;
    }

    public void setTotalHeadshots(int totalHeadshots) {
        this.totalHeadshots = totalHeadshots;
    }

    public void setLastMatchTwins(int lastMatchTwins) {
        this.lastMatchTwins = lastMatchTwins;
    }

    public void setLastMatchCTWins(int lastMatchCTWins) {
        this.lastMatchCTWins = lastMatchCTWins;
    }

    public void setLastMatchWins(int lastMatchWins) {
        lastMatchWins = lastMatchWins;
    }

    public void setLastMatchKils(int lastMatchKils) {
        this.lastMatchKils = lastMatchKils;
    }

    public void setLastMatchDeaths(int lastMatchDeaths) {
        this.lastMatchDeaths = lastMatchDeaths;
    }

    public void setLastMatchFavWeapon(int lastMatchFavWeapon) {
        this.lastMatchFavWeapon = lastMatchFavWeapon;
    }

    public void setLastMatchFavWeaponShots(int lastMatchFavWeaponShots) {
        this.lastMatchFavWeaponShots = lastMatchFavWeaponShots;
    }

    public void setLastMatchFavWeaponHits(int lastMatchFavWeaponHits) {
        this.lastMatchFavWeaponHits = lastMatchFavWeaponHits;
    }

    public void setLastMatchFavWeaponKils(int lastMatchFavWeaponKils) {
        this.lastMatchFavWeaponKils = lastMatchFavWeaponKils;
    }

    public void setLastMatchMVP(int lastMatchMVP) {
        this.lastMatchMVP = lastMatchMVP;
    }

    public void setLastMatchMoneySpent(int lastMatchMoneySpent) {
        this.lastMatchMoneySpent = lastMatchMoneySpent;
    }
    public Player(int i)
    {

    }


    @Override
    public void onTaskCompleted(HashMap<String, String> response) {
        Player temp=new Player(1);


        if (response.get("Type")=="PlayerStats") {
            Log.w("TEST", "OnTaskCompletedPlayer");
            tempPlayerStats = response;
            //Player();
            tempPlayerStats.get("total_kills");

            temp.init(MainPlayerSteamId,2);



        } else if (response.get("Type")=="Friendlist") {
            friendList=response;
            requestFinished.onTaskCompleted();

        }
        else if(response.get("Type")=="PlayerInfo")
        {

            tempPlayerInfo=response;
            temp.init(MainPlayerSteamId,3);


        }
     //   Intent intent = new Intent(this,
       // startActivity(intent);
        //Hier moet ik de naar de splash page sturen dat alles geladen is

    }



}
