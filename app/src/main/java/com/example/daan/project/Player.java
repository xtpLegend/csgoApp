package com.example.daan.project;

import android.support.annotation.NonNull;
import android.support.v4.util.LogWriter;
import android.util.Log;

import com.orm.SugarRecord;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Created by daan on 11.11.17.
 */

public class Player extends SugarRecord<Player> {
    //Global stats
    private String playerName;
    private String SteamId;
    private int totalTimePlayed;
    private int totalKills;
    private int totalWinsPistolRound;
    private int totalShots;
    private int totalHits;
    private int totalDeaths;
    Map<String, String> TempStats = null;


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
    private Map<String, String> tempPlayerStats = new Map<String, String>() {
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
    private Map<String, String> tempPlayerInfo = new Map<String, String>() {
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    private Map<String, String> friendList = new Map<String, String>() {
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

    private Map<String, Integer> weaponAccuracy = new Map<String, Integer>() {
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


    private Map<String, String> friendlist = new Map<String, String>() {
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
    Map<String, String> tempPlayerFriends = new Map<String, String>() {
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


    public Player() {

        // Log.w("TEST","CreatedPlayer");

    }

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
    private void getStats(Map<String, String> test) {
        tempPlayerStats = test;
        Log.w("TEST", test.keySet().toString());
    }


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

    public Player(String steamId) {
        Log.w("TEST", "Start Creating Player");

        Log.w("TEST", "Start Request");

        SteamAPI test = new SteamAPI();

        try {
            test.execute("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=C8E2FB316FEBD12C2CD17BB2B06CDE14&steamid=" + steamId, "getPlayerStats").get();
        } catch (InterruptedException e) {
            Log.w("TEST", "ERROR1");

        } catch (ExecutionException e) {
            Log.w("TEST", "ERROR2");


        }

        Log.w("TEST", "PlayerInfo");
        // Log.w("TEST", tempPlayerStat.keySet().toString());
        //Map<String, String> tempPlayerInfo = getAllPlayerInfoApi(steamId);

        //    Map<String,String> tempPlayerFriends = getAllPlayerFriendsApi(steamId);
        // this.totalKills=tempPlayerStat.get()


        //  Log.w("TEST","GotPlayerFriends");
        //friendList = tempPlayerFriends;
        //   this.playerName = playerName;
        // SteamId = steamId;
        //  this.totalTimePlayed = totalTimePlayed;
        this.totalKills = Integer.parseInt(TempStats.get("total_kills"));
        this.totalWinsPistolRound = Integer.parseInt(TempStats.get("total_wins_pistolround"));
        this.totalShots = Integer.parseInt(TempStats.get("total_shots_fired"));
        this.totalHits = Integer.parseInt(TempStats.get("total_shots_hit"));
        this.totalDeaths = Integer.parseInt(TempStats.get("total_deaths"));
        this.totalBomPlants = Integer.parseInt(TempStats.get("total_planted_bombs"));
        this.totalBomDefuses = Integer.parseInt(TempStats.get("total_defused_bombs"));
        this.totalDamageDone = Integer.parseInt(TempStats.get("total_damage_done"));
        this.totalMoneyEarned = Integer.parseInt(TempStats.get("total_money_earned"));
        this.totalHeadshots = Integer.parseInt(TempStats.get("total_kills_headshot"));
        //  this.weaponKills = weaponKills;
        /*this.weaponAccuracy = weaponAccuracy;
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
        this.lastMatchMVP = lastMatchMVP;*/
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


}
