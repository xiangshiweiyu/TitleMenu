package com.example.titlemenu.tb_vp_fra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.titlemenu.Constant;
import com.example.titlemenu.R;
import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT;

public class TbVpFraActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TbVpFraActivity";
    private int tag = 1;
    private TbVpFraAdapter mTbVpFraAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_vp_fra);
        TabLayout tbVp = findViewById(R.id.tb_vp);
        ViewPager vpTb = findViewById(R.id.vp_tb);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);

        mTbVpFraAdapter = new TbVpFraAdapter(getSupportFragmentManager(),BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mTbVpFraAdapter.addFragment(new ShowFragment(), "初始界面");
        vpTb.setAdapter(mTbVpFraAdapter);
        tbVp.setupWithViewPager(vpTb);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_add:
                tag = tag + 1;
                Constant.tb_vp_fra_tag = "第" + tag + "个界面";
                mTbVpFraAdapter.addFragment(new ShowFragment(), Constant.tb_vp_fra_tag);
                break;
            case R.id.btn_delete:
                mTbVpFraAdapter.removeIndexData(Constant.tb_vp_fra_tag);
                break;
        }
    }
}
