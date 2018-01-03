package com.example.daan.project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendItemFragment extends Fragment {
    static Player player;
    public static FriendItemFragment newInstance(Player p) {
        FriendItemFragment fragment = new FriendItemFragment();
        player = p;
        return fragment;
    }


    public FriendItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_item, container, false);
        ListView friendlistview = view.findViewById(R.id.friendList);
        HashMap<String,String> friendList = player.getFriendList();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friend_item, container, false);
    }

}
