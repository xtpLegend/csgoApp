package com.example.daan.project;

import android.util.Log;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by daan on 11.11.17.
 */

public class Player extends SugarRecord<Player>implements AsyncResponse,Serializable {
    private static RequestFinished requestFinished;
    private String[] weaponsArr= {"glock","deagle","elite","fiveseven",
    "xm1014","mac10","ump45","p90","awp","ak47","aug","famas","g3sg1","m249","hkp2000","p250",
    "sg556","scar20","mp7","mp9","nova","negev","sawedoff","bizon","tec9","mag7","m4a1","galilar"};
    private String[] specialWeaponsArr={"knife","hegrenade","molotov","taser"};
    private String[] mapsArr={"cs_office","de_cbble","de_dust2","de_dust","de_inferno","de_nuke",
    "de_train","de_lake","de_safehouse","de_stmarc","de_bank","de_shorttrain","ar_shoots","ar_baggage","ar_monastery"};
    public static String MainPlayerSteamId;
    private static HashMap<Integer,Player>friendStats = new HashMap<>();
    private HashMap<String,HashMap<String,String>>friendInfo = new HashMap<>();

    public HashMap<String, String> getFriendList() {
        return friendList;
    }

    private static HashMap<String, String> friendList = new HashMap<>();
    //Global stats
    private SteamAPI API = new SteamAPI(this);

    public String getPlayerName() {
        return playerName;
    }

    private String playerName;
    private String SteamId;

    private int totalKills;

    public float getKillDeath() {
        return killDeath;
    }

    public void setKillDeath(float killDeath) {
        this.killDeath = killDeath;
    }

    private float killDeath;
    private int totalWinsPistolRound;
    private int totalShots;
    private int totalHits;

    public int getTotalDeaths() {
        return totalDeaths;
    }

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


    public String getProfilePicture_large() {
        return profilePicture_large;
    }

    public void setProfilePicture_large(String profilePicture_large) {
        this.profilePicture_large = profilePicture_large;
    }

    public String getProfilePicture_medium() {
        return profilePicture_medium;
    }

    public void setProfilePicture_medium(String profilePicture_medium) {
        this.profilePicture_medium = profilePicture_medium;
    }

    public String getProfilePicture_small() {
        return profilePicture_small;
    }

    public void setProfilePicture_small(String profilePicture_small) {
        this.profilePicture_small = profilePicture_small;
    }

    private String profilePicture_large;
    private String profilePicture_medium;
    private String profilePicture_small;
    private String realname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Locale getNationality() {
        return nationality;
    }

    public void setNationality(Locale nationality) {
        this.nationality = nationality;
    }

    public String getSteamUrl() {
        return steamUrl;
    }

    public void setSteamUrl(String steamUrl) {
        this.steamUrl = steamUrl;
    }

    private Locale nationality;
    private String steamUrl;
    private long totalTimePlayed;
    private static HashMap<String, String> tempPlayerStats = new HashMap<>();
    private static HashMap<String, String> tempPlayerInfo = new HashMap<>();

    private int totalBomPlants;
    private int totalBomDefuses;
    private int totalDamageDone;
    private int totalMoneyEarned;
    private int totalHeadshots;




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
    private int lastMatchKills;
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
       if (tempPlayerInfo.containsKey("personaname"))
       {
           this.playerName = tempPlayerInfo.get("personaname");

       }
       else
       {
           this.playerName = "Data Not Available";
       }
        if (tempPlayerStats.containsKey("total_time_played"))
        {
            this.totalTimePlayed =Integer.parseInt(tempPlayerStats.get("total_time_played"));
        }
        else
        {
            this.totalTimePlayed = -1;
        }
        if (tempPlayerInfo.containsKey("profileurl"))
        {
            this.steamUrl=tempPlayerInfo.get("profileurl");
        }
        else
        {
            this.steamUrl="Data Not Available";
        }
        this.SteamId = tempPlayerInfo.get("steamid");

        if (tempPlayerInfo.containsKey("relname"))
        {
            this.realname=tempPlayerInfo.get("realname");
        }
        else
        {
            this.realname="Data Not Available";
        }
        if (tempPlayerInfo.containsKey("loccountrycode"))
        {
            this.nationality=new Locale("",tempPlayerInfo.get("loccountrycode"));

        }
        if (tempPlayerStats.containsKey("total_kills"))
        {
            this.totalKills = Integer.parseInt(tempPlayerStats.get("total_kills"));

        }
        else
        {
            this.totalKills=-1;
        }
        if (tempPlayerStats.containsKey("total_wins_pistolround"))
        {
            this.totalWinsPistolRound = Integer.parseInt(tempPlayerStats.get("total_wins_pistolround"));
        }
        else
        {
            this.totalWinsPistolRound=-1;
        }
        if (tempPlayerStats.containsKey("total_shots_fired"))
        {
            this.totalShots = Integer.parseInt(tempPlayerStats.get("total_shots_fired"));

        }
        else
        {
            this.totalShots=-1;
        }
        if (tempPlayerStats.containsKey("total_shots_hit"))
        {
            this.totalHits = Integer.parseInt(tempPlayerStats.get("total_shots_hit"));

        }
        else
        {
            this.totalHits=-1;
        }
        if (tempPlayerStats.containsKey("total_deaths"))
        {
            this.totalDeaths = Integer.parseInt(tempPlayerStats.get("total_deaths"));

        }
        else
        {
            this.totalDeaths=-1;
        }
        if (tempPlayerInfo.containsKey("avatarfull"))
        {
            this.profilePicture_large = tempPlayerInfo.get("avatarfull");

        }
        else
        {
            this.profilePicture_large="Data Not Available";
        }
        if (tempPlayerInfo.containsKey("avatarmedium"))
        {
            this.profilePicture_medium = tempPlayerInfo.get("avatarmedium");

        }
        else
        {
            this.profilePicture_medium="Data Not Available";
        }
        if (tempPlayerInfo.containsKey("avatar"))
        {
            this.profilePicture_small = tempPlayerInfo.get("avatar");

        }
        else
        {
            this.profilePicture_small="Data Not Available";
        }
        if (tempPlayerStats.containsKey("total_planted_bombs"))
        {
            this.totalBomPlants = Integer.parseInt(tempPlayerStats.get("total_planted_bombs"));

        }
        else
        {
          this.totalBomPlants=-1;
        }
        if (tempPlayerStats.containsKey("total_defused_bombs"))
        {
            this.totalBomDefuses = Integer.parseInt(tempPlayerStats.get("total_defused_bombs"));

        }
        else
        {
            this.totalBomDefuses=-1;
        }
        if (tempPlayerStats.containsKey("total_damage_done"))
        {
            this.totalDamageDone = Integer.parseInt(tempPlayerStats.get("total_damage_done"));

        }
        else
        {
            this.totalDamageDone=-1;
        }
        if (tempPlayerStats.containsKey("total_money_earned"))
        {
            this.totalMoneyEarned =  Integer.parseInt(tempPlayerStats.get("total_money_earned"));

        }
        else
        {
            this.totalMoneyEarned=-1;
        }
        if (tempPlayerStats.containsKey("total_kills_headshot"))
        {
            this.totalHeadshots = Integer.parseInt(tempPlayerStats.get("total_kills_headshot"));

        }
        else
        {
            this.totalHeadshots=-1;
        }
        for (int i=0;i<weaponsArr.length;i++)
        {
            if (tempPlayerStats.containsKey("total_kills_"+weaponsArr[i]))
            {
                weaponKills.put(weaponsArr[i].toString(),Integer.parseInt(tempPlayerStats.get("total_kills_"+weaponsArr[i])));

            }
            else
            {
                weaponKills.put(weaponsArr[i].toString(),-1);
            }
        }
        for (int i=0;i<specialWeaponsArr.length;i++)
        {
            if (tempPlayerStats.containsKey("total_kills_"+specialWeaponsArr[i]))
            {
                weaponKills.put(specialWeaponsArr[i].toString(),Integer.parseInt(tempPlayerStats.get("total_kills_"+specialWeaponsArr[i])));

            }
            else
            {
                weaponKills.put(specialWeaponsArr[i].toString(),-1);

            }
        }
        for (int i=0;i<weaponsArr.length;i++) {
            if (tempPlayerStats.containsKey("total_shots_" + weaponsArr[i]))
            {
                this.weaponShots.put(weaponsArr[i],Integer.parseInt(tempPlayerStats.get("total_shots_" + weaponsArr[i])));

            }
            else
            {
                this.weaponShots.put(weaponsArr[i],-1);

            }
        }
        if (tempPlayerStats.containsKey("total_shots_taser"))
        {
            this.weaponShots.put("taser",Integer.parseInt(tempPlayerStats.get("total_shots_taser")));

        }
        else
        {
            this.weaponShots.put("taser",-1);

        }


        for (int i=0;i<weaponsArr.length;i++) {
            if (tempPlayerStats.containsKey("total_hits_"+weaponsArr[i]))
            {
                this.weaponHits.put(weaponsArr[i],Integer.parseInt(tempPlayerStats.get("total_hits_"+weaponsArr[i])));

            }
            else
            {
                this.weaponHits.put(weaponsArr[i],-1);

            }
        }
        for (int i=0;i<weaponsArr.length;i++)
        {
            if (weaponShots.get(weaponsArr[i])!=-1 && weaponHits.get(weaponsArr[i])!=-1)
            {
                this.weaponAccuracy.put(weaponsArr[i],weaponShots.get(weaponsArr[i])/weaponHits.get(weaponsArr[i]));

            }
            else
            {
                this.weaponAccuracy.put(weaponsArr[i],-1);
            }


        }

       // this.mapRounds = mapRounds;
        //this.mapWins = mapWins;
        if (tempPlayerStats.containsKey("last_match_t_wins"))
        {
            this.lastMatchTwins = Integer.parseInt(tempPlayerStats.get("last_match_t_wins"));

        }
        else
        {
            this.lastMatchTwins=-1;
        }
        if (tempPlayerStats.containsKey("last_match_ct_wins"))
        {
            this.lastMatchCTWins = Integer.parseInt(tempPlayerStats.get("last_match_ct_wins"));

        }
        else
        {
            this.lastMatchCTWins=-1;
        }
        if (tempPlayerStats.containsKey("last_match_wins"))
        {
            this.lastMatchWins = Integer.parseInt(tempPlayerStats.get("last_match_wins"));

        }
        else
        {
            this.lastMatchWins=-1;
        }
        if (tempPlayerStats.containsKey("last_match_kills"))
        {
            this.lastMatchKills = Integer.parseInt(tempPlayerStats.get("last_match_kills"));

        }
        else
        {
            this.lastMatchKills =-1;
        }
        if (tempPlayerStats.containsKey("last_match_deaths"))
        {
            this.lastMatchDeaths = Integer.parseInt(tempPlayerStats.get("last_match_deaths"));

        }
        else
        {
            this.lastMatchDeaths=-1;
        }
        if (getTotalKills()!=-1 && getTotalDeaths()!=-1)
        {
            this.killDeath = this.getTotalKills()/this.getTotalDeaths();

        }
        else
        {
            this.killDeath=-1;
        }



       /* this.lastMatchFavWeapon = lastMatchFavWeapon;
        this.lastMatchFavWeaponShots = lastMatchFavWeaponShots;
        this.lastMatchFavWeaponHits = lastMatchFavWeaponHits;
        this.lastMatchFavWeaponKils = lastMatchFavWeaponKils;
        this.lastMatchMVP = lastMatchMVP;
        this.lastMatchMoneySpent = lastMatchMoneySpent;*/
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

    public int getLastMatchKills() {
        return lastMatchKills;
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

    public void setLastMatchKills(int lastMatchKills) {
        this.lastMatchKills = lastMatchKills;
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
            Log.w("TEST", tempPlayerStats.get("total_kills"));

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
        else
        {
            Log.w("TEST", "ERROR");
        }
     //   Intent intent = new Intent(this,
       // startActivity(intent);
        //Hier moet ik de naar de splash page sturen dat alles geladen is

    }



}
