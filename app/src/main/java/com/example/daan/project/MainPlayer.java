package com.example.daan.project;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by daan on 11.11.17.
 */

public class MainPlayer extends Player {
    private Map<String,String> friendlist = new Map<String, String>() {
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


    public MainPlayer(Map<String,String> friendlist,String playerName, String steamId, int totalTimePlayed, int totalKills, int totalWinsPistolRound, int totalShots, int totalHits, int totalDeaths, int totalBomPlants, int totalBomDefuses, int totalDamageDone, int totalMoneyEarned, int totalHeadshots, Map<String, Integer> weaponKills, Map<String, Integer> weaponAccuracy, Map<String, Integer> weaponShots, Map<String, Integer> weaponHits, Map<String, Integer> mapRounds, Map<String, Integer> mapWins, int lastMatchTwins, int lastMatchCTWins, int lastMatchWins, int lastMatchKils, int lastMatchDeaths, int lastMatchFavWeapon, int lastMatchFavWeaponShots, int lastMatchFavWeaponHits, int lastMatchFavWeaponKils, int lastMatchMVP, int lastMatchMoneySpent) {

        super(playerName, steamId, totalTimePlayed, totalKills, totalWinsPistolRound, totalShots, totalHits, totalDeaths, totalBomPlants, totalBomDefuses, totalDamageDone, totalMoneyEarned, totalHeadshots, weaponKills, weaponAccuracy, weaponShots, weaponHits, mapRounds, mapWins, lastMatchTwins, lastMatchCTWins, lastMatchWins, lastMatchKils, lastMatchDeaths, lastMatchFavWeapon, lastMatchFavWeaponShots, lastMatchFavWeaponHits, lastMatchFavWeaponKils, lastMatchMVP, lastMatchMoneySpent);
        this.friendlist=friendlist;
    }
}
