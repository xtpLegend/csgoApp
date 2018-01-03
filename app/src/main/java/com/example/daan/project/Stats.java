package com.example.daan.project;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

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

    private PieChart pieChart;

    private Player player;


    private OnFragmentInteractionListener mListener;

    public Stats() {
        // Required empty public constructor
    }

    public static Stats newInstance(Player p) {
        Stats fragment = new Stats();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", p);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


      View view = inflater.inflate(R.layout.fragment_stats, container, false);//Inflate Layout



        pieChart = view.findViewById(R.id.PieChart);


        //pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(90);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("K/D");
        pieChart.setCenterTextColor(Color.parseColor("#FF3333"));
        pieChart.setCenterTextSize(20);
        pieChart.setHoleColor(Color.TRANSPARENT);

        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!
        addDataSet(player);

        //pieChart.animateX(1000);
        pieChart.animateY(2000);

        Legend l = pieChart.getLegend();
        l.setEnabled(false);
        return inflater.inflate(R.layout.fragment_stats, container, false);


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

    public void addDataSet(Player p) {
        Player t = new Player();
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        yEntrys.add(new PieEntry(t.getTotalDeaths()));
        yEntrys.add(new PieEntry(t.getTotalKills()));

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
        pieChart.invalidate();
    }
}
