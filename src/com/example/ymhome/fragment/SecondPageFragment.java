package com.example.ymhome.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ymhome.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondPageFragment extends Fragment {


    public SecondPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_page, container, false);
    }


}
