package com.jims.work.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import com.jims.work.MyServiceActivity;
import com.jims.work.R;

public class ServiceFragment extends Fragment   {
    private View layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       Intent intent=new Intent(getActivity(), MyServiceActivity.class);
        startActivity(intent);
        getActivity().finish();
        if (layout != null) {
            // 防止多次new出片段对象，造成图片错乱问题
            return layout;
        }
        layout = inflater.inflate(R.layout.fragment_service, container, false);



        return layout;
    }
}

