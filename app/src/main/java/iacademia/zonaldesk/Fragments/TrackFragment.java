package iacademia.zonaldesk.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import iacademia.zonaldesk.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackFragment extends android.app.Fragment {


    public TrackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.activity_track, container, false);
        return rootView;
    }

}
