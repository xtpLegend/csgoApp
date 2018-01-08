package com.example.daan.project;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendListFragment extends ListFragment {
    ListView listview;
    OnHeadlineSelectedListener mCallback;

    static ArrayList<String> nameList=new ArrayList<>();
    static HashMap<String,String> list = new HashMap<>();
    public FriendListFragment() {
        // Required empty public constructor
    }
    public interface OnHeadlineSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected */
        public void onArticleSelected(int position, String steamid);
    }
    public static FriendListFragment init(ArrayList<String> nameList, HashMap<String,String>list)
    {
        FriendListFragment.nameList=nameList;
        FriendListFragment.list=list;
        return new FriendListFragment();
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // SharedPreferences pref =

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,nameList);
        listview = (ListView) view.findViewWithTag("fragmentfriendlist");
        listview.setAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String steamid = list.get(nameList.get(position));
        mCallback.onArticleSelected(position,steamid);
        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }
}
