package com.example.ymhome.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ymhome.R;
import com.example.ymhome.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdPageFragment extends BaseFragment {


    @Override
    public View initViews() {
        View view = View.inflate(mActivity,R.layout.fragment_third_page,null);
        return view;
    }
}
