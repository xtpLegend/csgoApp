package com.example.daan.project;

import android.util.Log;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by daan on 03.01.18.
 */

public class Friend implements FriendStatsResponse {
    private static FriendRequestFinished requestFinished;
    GetFriendStatsAPi API = new GetFriendStatsAPi(this);
    private static HashMap<String, String> tempPlayerStats = new HashMap<>();
    private static HashMap<String, String> tempPlayerInfo = new HashMap<>();
    private String steamid;
    private float killDeath;
    private int lastMatchDeaths;
    private int lastMatchKils;
    private int lastMatchWins;
    private int lastMatchCTWins;
    private int lastMatchTwins;
    private int totalHeadshots;
    private int totalMoneyEarned;
    private int totalDamageDone;
    private int totalBomDefuses;
    private int totalBomPlants;
    private String profilePicture_small;
    private int totalShots;
    private int totalHits;
    private int totalDeaths;
    private String profilePicture_large;
    private String profilePicture_medium;
    private int totalWinsPistolRound;
    private int totalKills;
    private String SteamId;
    private String realname;
    private Locale nationality;
    private String steamUrl;
    private int totalTimePlayed;
    private String playerName;


    private String[] weaponsArr = {"glock", "deagle", "elite", "fiveseven",
            "xm1014", "mac10", "ump45", "p90", "awp", "ak47", "aug", "famas", "g3sg1", "m249", "hkp2000", "p250",
            "sg556", "scar20", "mp7", "mp9", "nova", "negev", "sawedoff", "bizon", "tec9", "mag7", "m4a1", "galilar"};
    private String[] specialWeaponsArr = {"knife", "hegrenade", "molotov", "taser"};
    private String[] mapsArr = {"cs_office", "de_cbble", "de_dust2", "de_dust", "de_inferno", "de_nuke",
            "de_train", "de_lake", "de_safehouse", "de_stmarc", "de_bank", "de_shorttrain", "ar_shoots", "ar_baggage", "ar_monastery"};
    private HashMap<String, Integer> weaponKills = new HashMap<>();

    private HashMap<String, Integer> weaponAccuracy = new HashMap<>();
    private HashMap<String, Integer> weaponShots = new HashMap<>();
    private HashMap<String, Integer> weaponHits = new HashMap<>();

    public void getStats(String steamId) {
        this.steamid = steamId;
        API.execute("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=" + steamId, "getPlayerStats");
    }

    public void getPlayerInfo(String steamId) {
        this.steamid = steamId;
        API.execute("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamids=" + steamId, "getPlayerInfo");
    }

    public void init(String steamId, int level) {

        switch (level) {
            case 1:
                getStats(steamId);
                break;
            case 2:
                getPlayerInfo(steamId);
                break;


        }

        // getFriends(steamId);
       /* for (int i=0;i<friendList.size();i++)
        {
            getFriendStats(friendList.get(i).toString(),0);
        }*/
    }

    public Friend(String steamId, FriendRequestFinished activityContext) {
        Log.w("TEST", "Start Creating Friend");
        requestFinished = activityContext;
        init(steamId, 1);
    }

    public Friend(int i) {
    }

    public Friend() {

        this.playerName = tempPlayerInfo.get("personaname");
        this.totalTimePlayed = Integer.parseInt(tempPlayerStats.get("total_time_played"));
        this.steamUrl = tempPlayerInfo.get("profileurl");
        this.SteamId = tempPlayerInfo.get("steamid");
        this.realname = tempPlayerInfo.get("realname");
        this.nationality = new Locale("", tempPlayerInfo.get("loccountrycode"));

        this.totalKills = Integer.parseInt(tempPlayerStats.get("total_kills"));
        this.totalWinsPistolRound = Integer.parseInt(tempPlayerStats.get("total_wins_pistolround"));
        this.totalShots = Integer.parseInt(tempPlayerStats.get("total_shots_fired"));
        this.totalHits = Integer.parseInt(tempPlayerStats.get("total_shots_hit"));
        this.totalDeaths = Integer.parseInt(tempPlayerStats.get("total_deaths"));
        this.profilePicture_large = tempPlayerInfo.get("avatarfull");
        this.profilePicture_medium = tempPlayerInfo.get("avatarmedium");
        this.profilePicture_small = tempPlayerInfo.get("avatar");
        this.totalBomPlants = Integer.parseInt(tempPlayerStats.get("total_planted_bombs"));
        this.totalBomDefuses = Integer.parseInt(tempPlayerStats.get("total_defused_bombs"));
        this.totalDamageDone = Integer.parseInt(tempPlayerStats.get("total_damage_done"));
        this.totalMoneyEarned = Integer.parseInt(tempPlayerStats.get("total_money_earned"));
        this.totalHeadshots = Integer.parseInt(tempPlayerStats.get("total_kills_headshot"));
        for (int i = 0; i < weaponsArr.length; i++) {
            weaponKills.put(weaponsArr[i].toString(), Integer.parseInt(tempPlayerStats.get("total_kills_" + weaponsArr[i])));
        }
        for (int i = 0; i < specialWeaponsArr.length; i++) {
            weaponKills.put(specialWeaponsArr[i].toString(), Integer.parseInt(tempPlayerStats.get("total_kills_" + specialWeaponsArr[i])));
        }
        for (int i = 0; i < weaponsArr.length; i++) {
            this.weaponShots.put(weaponsArr[i], Integer.parseInt(tempPlayerStats.get("total_shots_" + weaponsArr[i])));
        }
        this.weaponShots.put("taser", Integer.parseInt(tempPlayerStats.get("total_shots_taser")));

        for (int i = 0; i < weaponsArr.length; i++) {
            this.weaponHits.put(weaponsArr[i], Integer.parseInt(tempPlayerStats.get("total_hits_" + weaponsArr[i])));
        }
        for (int i = 0; i < weaponsArr.length; i++) {
            this.weaponAccuracy.put(weaponsArr[i], weaponShots.get(weaponsArr[i]) / weaponHits.get(weaponsArr[i]));

        }

        // this.mapRounds = mapRounds;
        //this.mapWins = mapWins;
        this.lastMatchTwins = Integer.parseInt(tempPlayerStats.get("last_match_t_wins"));
        this.lastMatchCTWins = Integer.parseInt(tempPlayerStats.get("last_match_ct_wins"));
        this.lastMatchWins = Integer.parseInt(tempPlayerStats.get("last_match_wins"));
        this.lastMatchKils = Integer.parseInt(tempPlayerStats.get("last_match_kills"));
        this.lastMatchDeaths = Integer.parseInt(tempPlayerStats.get("last_match_deaths"));
        this.killDeath = this.getTotalKills() / this.getTotalDeaths();
    /* this.lastMatchFavWeapon = lastMatchFavWeapon;
     this.lastMatchFavWeaponShots = lastMatchFavWeaponShots;
     this.lastMatchFavWeaponHits = lastMatchFavWeaponHits;
     this.lastMatchFavWeaponKils = lastMatchFavWeaponKils;
     this.lastMatchMVP = lastMatchMVP;
     this.lastMatchMoneySpent = lastMatchMoneySpent;*/
    }


    public float getKillDeath() {
        return killDeath;
    }

    public int getLastMatchDeaths() {
        return lastMatchDeaths;
    }

    public void setLastMatchDeaths(int lastMatchDeaths) {
        this.lastMatchDeaths = lastMatchDeaths;
    }

    public int getLastMatchKils() {
        return lastMatchKils;
    }

    public void setLastMatchKils(int lastMatchKils) {
        this.lastMatchKils = lastMatchKils;
    }

    public int getLastMatchWins() {
        return lastMatchWins;
    }

    public void setLastMatchWins(int lastMatchWins) {
        this.lastMatchWins = lastMatchWins;
    }

    public int getLastMatchCTWins() {
        return lastMatchCTWins;
    }

    public void setLastMatchCTWins(int lastMatchCTWins) {
        this.lastMatchCTWins = lastMatchCTWins;
    }

    public int getLastMatchTwins() {
        return lastMatchTwins;
    }

    public void setLastMatchTwins(int lastMatchTwins) {
        this.lastMatchTwins = lastMatchTwins;
    }

    public int getTotalHeadshots() {
        return totalHeadshots;
    }

    public void setTotalHeadshots(int totalHeadshots) {
        this.totalHeadshots = totalHeadshots;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public void setTotalMoneyEarned(int totalMoneyEarned) {
        this.totalMoneyEarned = totalMoneyEarned;
    }

    public int getTotalDamageDone() {
        return totalDamageDone;
    }

    public void setTotalDamageDone(int totalDamageDone) {
        this.totalDamageDone = totalDamageDone;
    }

    public int getTotalBomDefuses() {
        return totalBomDefuses;
    }

    public void setTotalBomDefuses(int totalBomDefuses) {
        this.totalBomDefuses = totalBomDefuses;
    }

    public int getTotalBomPlants() {
        return totalBomPlants;
    }

    public void setTotalBomPlants(int totalBomPlants) {
        this.totalBomPlants = totalBomPlants;
    }

    public String getProfilePicture_small() {
        return profilePicture_small;
    }

    public void setProfilePicture_small(String profilePicture_small) {
        this.profilePicture_small = profilePicture_small;
    }

    public int getTotalShots() {
        return totalShots;
    }

    public void setTotalShots(int totalShots) {
        this.totalShots = totalShots;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

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

    public int getTotalWinsPistolRound() {
        return totalWinsPistolRound;
    }

    public void setTotalWinsPistolRound(int totalWinsPistolRound) {
        this.totalWinsPistolRound = totalWinsPistolRound;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public String getSteamId() {
        return SteamId;
    }

    public void setSteamId(String steamId) {
        SteamId = steamId;
    }

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

    public int getTotalTimePlayed() {
        return totalTimePlayed;
    }

    public void setTotalTimePlayed(int totalTimePlayed) {
        this.totalTimePlayed = totalTimePlayed;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String[] getWeaponsArr() {
        return weaponsArr;
    }

    public void setWeaponsArr(String[] weaponsArr) {
        this.weaponsArr = weaponsArr;
    }

    public String[] getSpecialWeaponsArr() {
        return specialWeaponsArr;
    }

    public void setSpecialWeaponsArr(String[] specialWeaponsArr) {
        this.specialWeaponsArr = specialWeaponsArr;
    }

    public String[] getMapsArr() {
        return mapsArr;
    }

    public void setMapsArr(String[] mapsArr) {
        this.mapsArr = mapsArr;
    }

    public HashMap<String, Integer> getWeaponKills() {
        return weaponKills;
    }

    public void setWeaponKills(HashMap<String, Integer> weaponKills) {
        this.weaponKills = weaponKills;
    }

    public HashMap<String, Integer> getWeaponAccuracy() {
        return weaponAccuracy;
    }

    public void setWeaponAccuracy(HashMap<String, Integer> weaponAccuracy) {
        this.weaponAccuracy = weaponAccuracy;
    }

    public HashMap<String, Integer> getWeaponShots() {
        return weaponShots;
    }

    public void setWeaponShots(HashMap<String, Integer> weaponShots) {
        this.weaponShots = weaponShots;
    }

    public HashMap<String, Integer> getWeaponHits() {
        return weaponHits;
    }

    public void setWeaponHits(HashMap<String, Integer> weaponHits) {
        this.weaponHits = weaponHits;
    }

    @Override
    public void onFriendResponseCompeted(HashMap<String, String> response) {
        Friend temp = new Friend(1);

        if (response != null) {


            if (response.get("Type") == "PlayerStats") {
                Log.w("TEST", "OnTaskCompletedPlayer");
                tempPlayerStats = response;
                //Player();
                Log.w("TEST", tempPlayerStats.get("total_kills"));
                requestFinished.friendRequestCompleted();
                // temp.init(steamid, 2);


            } else if (response.get("Type") == "PlayerInfo") {

                tempPlayerInfo = response;

                requestFinished.friendRequestCompleted();

            } else {
                Log.w("TEST", "ERROR");
            }
        } else {
                requestFinished.friendRequestCompleted();
        }
    }
}
