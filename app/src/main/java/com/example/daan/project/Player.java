package com.example.daan.project;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by daan on 11.11.17.
 */

public class Player {

    //Global stats
    private String playerName;
    private  String SteamId;
    private int totalTimePlayed;
    private int totalKills;
    private int totalWinsPistolRound;
    private int totalShots;
    private int totalHits;
    private int totalDeaths;
    private Map<String,String> tempPlayerStats = new Map<String, String>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public String get(Object key) {
            return null;
        }

        @Override
        public String put(String key, String value) {
            return null;
        }

        @Override
        public String remove(Object key) {
            return null;
        }

        @Override
        public void putAll(@NonNull Map<? extends String, ? extends String> m) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public Set<String> keySet() {
            return null;
        }

        @NonNull
        @Override
        public Collection<String> values() {
            return null;
        }

        @NonNull
        @Override
        public Set<Entry<String, String>> entrySet() {
            return null;
        }
    };
    private Map<String,String>tempPlayerInfo=new Map<String, String>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public String get(Object key) {
            return null;
        }

        @Override
        public String put(String key, String value) {
            return null;
        }

        @Override
        public String remove(Object key) {
            return null;
        }

        @Override
        public void putAll(@NonNull Map<? extends String, ? extends String> m) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public Set<String> keySet() {
            return null;
        }

        @NonNull
        @Override
        public Collection<String> values() {
            return null;
        }

        @NonNull
        @Override
        public Set<Entry<String, String>> entrySet() {
            return null;
        }
    };
    private int totalBomPlants;
    private int totalBomDefuses;
    private int totalDamageDone;
    private int totalMoneyEarned;
    private int totalHeadshots;
    //WeaponStats
    private Map<String, Integer> weaponKills = new Map<String, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Integer get(Object key) {
            return null;
        }

        @Override
        public Integer put(String key, Integer value) {
            return null;
        }

        @Override
        public Integer remove(Object key) {
            return null;
        }

        @Override
        public void putAll(@NonNull Map<? extends String, ? extends Integer> m) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public Set<String> keySet() {
            return null;
        }

        @NonNull
        @Override
        public Collection<Integer> values() {
            return null;
        }

        @NonNull
        @Override
        public Set<Entry<String, Integer>> entrySet() {
            return null;
        }
    };
    private Map<String, Integer> weaponAccuracy= new Map<String, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Integer get(Object key) {
            return null;
        }

        @Override
        public Integer put(String key, Integer value) {
            return null;
        }

        @Override
        public Integer remove(Object key) {
            return null;
        }

        @Override
        public void putAll(@NonNull Map<? extends String, ? extends Integer> m) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public Set<String> keySet() {
            return null;
        }

        @NonNull
        @Override
        public Collection<Integer> values() {
            return null;
        }

        @NonNull
        @Override
        public Set<Entry<String, Integer>> entrySet() {
            return null;
        }
    };
    private Map<String, Integer> weaponShots = new Map<String, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Integer get(Object key) {
            return null;
        }

        @Override
        public Integer put(String key, Integer value) {
            return null;
        }

        @Override
        public Integer remove(Object key) {
            return null;
        }

        @Override
        public void putAll(@NonNull Map<? extends String, ? extends Integer> m) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public Set<String> keySet() {
            return null;
        }

        @NonNull
        @Override
        public Collection<Integer> values() {
            return null;
        }

        @NonNull
        @Override
        public Set<Entry<String, Integer>> entrySet() {
            return null;
        }
    };
    private Map<String, Integer> weaponHits = new Map<String, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Integer get(Object key) {
            return null;
        }

        @Override
        public Integer put(String key, Integer value) {
            return null;
        }

        @Override
        public Integer remove(Object key) {
            return null;
        }

        @Override
        public void putAll(@NonNull Map<? extends String, ? extends Integer> m) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public Set<String> keySet() {
            return null;
        }

        @NonNull
        @Override
        public Collection<Integer> values() {
            return null;
        }

        @NonNull
        @Override
        public Set<Entry<String, Integer>> entrySet() {
            return null;
        }
    };
    private Map<String, Integer> mapRounds = new Map<String, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Integer get(Object key) {
            return null;
        }

        @Override
        public Integer put(String key, Integer value) {
            return null;
        }

        @Override
        public Integer remove(Object key) {
            return null;
        }

        @Override
        public void putAll(@NonNull Map<? extends String, ? extends Integer> m) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public Set<String> keySet() {
            return null;
        }

        @NonNull
        @Override
        public Collection<Integer> values() {
            return null;
        }

        @NonNull
        @Override
        public Set<Entry<String, Integer>> entrySet() {
            return null;
        }
    };
    private Map<String, Integer> mapWins = new Map<String, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Integer get(Object key) {
            return null;
        }

        @Override
        public Integer put(String key, Integer value) {
            return null;
        }

        @Override
        public Integer remove(Object key) {
            return null;
        }

        @Override
        public void putAll(@NonNull Map<? extends String, ? extends Integer> m) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public Set<String> keySet() {
            return null;
        }

        @NonNull
        @Override
        public Collection<Integer> values() {
            return null;
        }

        @NonNull
        @Override
        public Set<Entry<String, Integer>> entrySet() {
            return null;
        }
    };
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

    public Player()
    {}

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


    public Player(String steamId)
    {
       Map<String,String> tempPlayerInfo = getAllPlayerInfoApi(steamId);
       Map<String,String> tempPlayerStat = getAllPlayerStatsApi(steamId);
        this.playerName = playerName;
        SteamId = steamId;
        this.totalTimePlayed = totalTimePlayed;
        this.totalKills = totalKills;
        this.totalWinsPistolRound = totalWinsPistolRound;
        this.totalShots = totalShots;
        this.totalHits = totalHits;
        this.totalDeaths = totalDeaths;
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
        lastMatchWins = lastMatchWins;
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


    private Map<String,String> getAllPlayerStatsApi(String steamId)
    {
        SteamAPI getPlayerStatsAsync = (SteamAPI) new SteamAPI(new SteamAPI.AsyncResponse(){
            MainPlayer mPlayer=new MainPlayer();

            @Override
            public void processFinish(Map output) {
               tempPlayerStats = output;
                // Mplayer.setTotalKills((Integer)output.get("total_kills"));

                //Log.w("TEST", "calledFunction")
                //Log.w("TEST", Integer.toString(output) );
            }
        }).execute("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid="+steamId,"getPlayerStats");

        return tempPlayerStats;

    }





    private Map<String,String> getAllPlayerInfoApi(String steamId)
    {
        SteamAPI getPlayerInfoAsync = (SteamAPI) new SteamAPI(new SteamAPI.AsyncResponse(){
            MainPlayer mPlayer=new MainPlayer();


            @Override
            public void processFinish(Map output) {
                tempPlayerInfo = output;

                // Mplayer.setTotalKills((Integer)output.get("total_kills"));
                // Log.w("TEST", Integer.toString(Mplayer.getTotalKills()));
                //Log.w("TEST", Integer.toString(output) );

            }
        }).execute("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamids="+steamId,"getPlayerInfo");



            return tempPlayerInfo;
    }

}
