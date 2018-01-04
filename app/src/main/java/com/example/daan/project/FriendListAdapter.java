package com.example.daan.project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by daan on 02.01.18.
 */

public class FriendListAdapter extends ArrayAdapter {
    private ArrayList<String> dataSet= new ArrayList<>();
    private ArrayList<Boolean> checkedBox= new ArrayList<>();


    private ArrayList<String> id= new ArrayList<>();
    Context mContext;

    private static class ViewHolder {
        TextView txtName;
        CheckBox checkBox;
    }

    public FriendListAdapter(ArrayList data,ArrayList id, Context context) {
        super(context, R.layout.fragment_friend_item, data);
        this.dataSet = data;
        this.mContext = context;
        for(int i=0;i<dataSet.size();i++)
        {
            checkedBox.add(false);
        }
        this.id=id;

    }
    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public String getItem(int position) {
        return dataSet.get(position);
    }
    public void changeChecked(int position)
    {
        checkedBox.set(position,!checkedBox.get(position));
    }



    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

            result=convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        String item = getItem(position);
        boolean checked = checkedBox.get(position);

        viewHolder.txtName.setText(item);
        viewHolder.checkBox.setChecked(checked);


        return result;
    }
    public ArrayList<Boolean> getCheckedBox() {
        return checkedBox;
    }

    public void setCheckedBox(ArrayList<Boolean> checkedBox) {
        this.checkedBox = checkedBox;
    }
    public ArrayList<String> getDataSet() {
        return dataSet;
    }

    public void setDataSet(ArrayList<String> dataSet) {
        this.dataSet = dataSet;
    }

    public ArrayList<String> getId() {
        return id;
    }

    public void setId(ArrayList<String> id) {
        this.id = id;
    }
}
