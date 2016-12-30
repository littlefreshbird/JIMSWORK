package com.jims.work.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jims.work.R;
import com.jims.work.fragment.base.BaseFragment;

/**
 * Created by gong on 2016/12/27.
 */

public class HomeFragment extends BaseFragment {
    private View layout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (layout != null) {
            // 防止多次new出片段对象，造成图片错乱问题
            return layout;
        }
        layout = inflater.inflate(R.layout.fragment_home, container, false);


        return layout;
    }
}
