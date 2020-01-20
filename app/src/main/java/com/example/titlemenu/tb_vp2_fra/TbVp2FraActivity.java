package com.example.titlemenu.tb_vp2_fra;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.titlemenu.Constant;
import com.example.titlemenu.R;
import com.google.android.material.tabs.TabLayout;

public class TbVp2FraActivity extends AppCompatActivity implements View.OnClickListener
        , TabLayout.OnTabSelectedListener {

    private static final String TAG = "TbVp2FraActivity";
    private int tag = 0;
    private TbVp2FraAdapter mTbVpFraAdapter;
    private TabLayout tbVp;
    private ViewPager2 vpTb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_vp2_fra);
        tbVp = findViewById(R.id.tb_vp);
        vpTb = findViewById(R.id.vp2_tb);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        mTbVpFraAdapter = new TbVp2FraAdapter(this);
        vpTb.setAdapter(mTbVpFraAdapter);

        vpTb.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tbVp.setScrollPosition(position, 0, false);
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_add:
                if (tag == 0) {
                    tbVp.addTab(tbVp.newTab().setText("初始化界面"));
                } else {
                    Constant.tb_vp2_fra_tag = "第" + tag + "个界面";
                    tbVp.addTab(tbVp.newTab().setText(Constant.tb_vp2_fra_tag));
                }
                tag = tag + 1;
                mTbVpFraAdapter.addFragment(new ShowFragment());
                break;
            case R.id.btn_delete:
                if (tag > 1) {
                    tag = tag - 1;
                    mTbVpFraAdapter.removeFragment(tag);
                    tbVp.removeTabAt(tag);
                    Constant.tb_vp2_fra_tag = "第" + tag + "个界面";
                } else {
                    Constant.tb_vp2_fra_tag = "初始化界面";
                }
                break;
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vpTb.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
