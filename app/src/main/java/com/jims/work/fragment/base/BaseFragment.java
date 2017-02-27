package com.jims.work.fragment.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jims.work.LoginActivity;
import com.jims.work.application.JimsApplication;
import com.jims.work.bean.User;

/**
 * Created by gong on 2016/12/27.
 */
public class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void startActivity(Intent intent, boolean isNeedLogin){


        if(isNeedLogin){

            User user = JimsApplication.getInstance().getUser();
            if(user !=null){
                super.startActivity(intent);
            }
            else{

                JimsApplication.getInstance().putIntent(intent);
                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                super.startActivity(loginIntent);

            }

        }
        else{
            super.startActivity(intent);
        }

    }

}
