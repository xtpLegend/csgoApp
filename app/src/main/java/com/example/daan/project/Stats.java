package com.example.daan.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IFillFormatter;

import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Stats.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */

public class Stats extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    private Player p;
    private Friend f;
    private PieChart pieChart;
    TextView txtTotalKills;
    TextView txtTotalDeaths;
    TextView txtAccuraty;
    TextView txtHeadshotPercentage;
    TextView txtPlayerName;
    TextView txtPlayerInfo;
    ImageView imageAvatar;
    TextView txtFavWeapon;
    TextView txtFavWeaponKills;
    private static String steamid;


    private OnFragmentInteractionListener mListener;

    public Stats() {
        // Required empty public constructor
    }

    public static Stats newInstance(String p) {
        Stats fragment = new Stats();
        steamid = p;

        // Bundle bundle = new Bundle();
        // bundle.putSerializable("key", p);
        //fragment.setArguments(bundle);

        return fragment;
    }

    public Object getObjectFromSteamId(String id) {
        ArrayList<Friend> friendlist = new ArrayList<>();
        Player mp = new Player("player");
        if (id.equals(mp.getSteamId())) {
            return mp;
        } else {
            Friend tmpFriend;
            for (int i = 0; i < Friend.tempFriendlist.size(); i++) {
                if (Friend.tempFriendlist.get(i).getSteamId().equals(id)) {
                    tmpFriend = Friend.tempFriendlist.get(i);
                    return tmpFriend;
                }
            }

        }
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_stats, container, false);//Inflate Layout
        if (SplashActivity.networkStatus)
        {
            if (getObjectFromSteamId(steamid).getClass().getSimpleName().equals("Friend"))
            {
                f=(Friend) getObjectFromSteamId(steamid);

            }
            else if(getObjectFromSteamId(steamid).getClass().getSimpleName().equals("Player"))
            {
                p=(Player)getObjectFromSteamId(steamid);
            }
        }
        else
        {
            p=Player.findById(Player.class,(long)1);
        }



        txtTotalKills = (TextView) view.findViewById(R.id.txtTotalKills);
        txtTotalDeaths =(TextView) view.findViewById(R.id.txtTotalDeaths);
        txtAccuraty = (TextView) view.findViewById(R.id.txtAccuraty);
        txtHeadshotPercentage = (TextView) view.findViewById(R.id.txtHeadShotPercentage);
        txtPlayerName = (TextView) view.findViewById(R.id.txtPlayerName);
        txtPlayerInfo= (TextView) view.findViewById(R.id.txtPlayerInfo);
        imageAvatar = (ImageView) view.findViewById(R.id.avatar);

            txtFavWeapon = view.findViewById(R.id.FavoriteWeapon);
            txtFavWeaponKills = view.findViewById(R.id.FavWeaponKills);



        pieChart = (PieChart) view.findViewById(R.id.PieChart);


        //pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(90);
        pieChart.setRotationEnabled(false);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("K/D");
        pieChart.setCenterTextColor(Color.parseColor("#FF3333"));
        pieChart.setCenterTextSize(20);
        pieChart.setHoleColor(Color.TRANSPARENT);

        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!



        //pieChart.animateX(1000);
        if (SplashActivity.networkStatus)
        {
            if (getObjectFromSteamId(steamid).getClass().getSimpleName().equals("Friend"))
            {
                txtAccuraty.setText(Float.toString(f.getAccuracy()));
                txtTotalDeaths.setText(Float.toString(f.getTotalDeaths()));
                txtTotalKills.setText(Float.toString(f.getTotalKills()));
                txtHeadshotPercentage.setText(Float.toString(f.getHeadshotPercentage()));
                txtPlayerName.setText(f.getPlayerName());
                txtPlayerInfo.setText(f.getRealname()+ " " + f.getNationality());
                DownloadImageTask task = new DownloadImageTask(imageAvatar);
                task.execute(f.getProfilePicture_large());







            }
            if (getObjectFromSteamId(steamid).getClass().getSimpleName().equals("Player"))
            {
                txtAccuraty.setText(Float.toString(p.getAccuracy()));
                txtTotalDeaths.setText(Integer.toString(p.getTotalDeaths()));
                txtTotalKills.setText(Integer.toString(p.getTotalKills()));
                txtHeadshotPercentage.setText(Float.toString(p.getHeadshotPercentage()));
                txtPlayerName.setText(p.getPlayerName());
                txtPlayerInfo.setText(p.getRealname()+ " " + p.getNationality());
                DownloadImageTask task = new DownloadImageTask(imageAvatar);
                task.execute(p.getProfilePicture_large());




            }
            addDataSet(getObjectFromSteamId(steamid));
        }
        else
        {
            txtAccuraty.setText(Float.toString(p.getAccuracy()));
            txtTotalDeaths.setText(Integer.toString(p.getTotalDeaths()));
            txtTotalKills.setText(Integer.toString(p.getTotalKills()));
            txtHeadshotPercentage.setText(Float.toString(p.getHeadshotPercentage()));
            txtPlayerName.setText(p.getPlayerName());
            txtPlayerInfo.setText(p.getRealname()+ " " + p.getNationality());
            DownloadImageTask task = new DownloadImageTask(imageAvatar);
            task.execute(p.getProfilePicture_large());
            addDataSet(p);
        }

        pieChart.animateY(2000);


        Legend l = pieChart.getLegend();
        l.setEnabled(true);
        return view;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateStatsView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateStatsView(mCurrentPosition);
        }

    }

    public void updateStatsView(int position) {
        // TextView article = (TextView) getActivity().findViewById(R.id.article);
        //article.setText(Ipsum.Articles[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    ArrayList<PieEntry> yEntrys = new ArrayList<>();
    ArrayList<String> xEntrys = new ArrayList<>();

    public void addDataSet(Object p) {
        if (p.getClass().getSimpleName().equals("Player")) {
            Player tmpP = (Player) p;
            yEntrys.add(new PieEntry(tmpP.getTotalDeaths()));
            yEntrys.add(new PieEntry(tmpP.getTotalKills()));
        } else {
            Friend tmpF = (Friend) p;
            yEntrys.add(new PieEntry(tmpF.getTotalDeaths()));
            yEntrys.add(new PieEntry(tmpF.getTotalKills()));
        }


        pieChart.getDescription().setEnabled(false);
        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "");
        pieDataSet.setSliceSpace(0);
        pieDataSet.setValueTextSize(0);

        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.BLUE);

        pieDataSet.setColors(colors);

        //add legend to chart
       /* Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);*/
        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
