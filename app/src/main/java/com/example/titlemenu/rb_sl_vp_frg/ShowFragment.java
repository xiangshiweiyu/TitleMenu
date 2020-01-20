package com.example.titlemenu.rb_sl_vp_frg;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.titlemenu.Constant;
import com.example.titlemenu.R;


public class ShowFragment extends Fragment {

    private static final String TAG = "RbSlVpFraActivity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, container, false);
        if (Constant.tb_vp_fra_tag != null) {
            view.<Button>findViewById(R.id.tv_title).setText(Constant.rb_sl_vp_fra_tag);
        } else {
            view.<Button>findViewById(R.id.tv_title).setText("初始化界面");
        }
        return view;
    }

}
