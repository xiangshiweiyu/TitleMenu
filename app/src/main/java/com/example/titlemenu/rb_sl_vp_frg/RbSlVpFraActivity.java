package com.example.titlemenu.rb_sl_vp_frg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.titlemenu.Constant;
import com.example.titlemenu.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class RbSlVpFraActivity extends AppCompatActivity implements View.OnClickListener
        , RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private static final String TAG = "RbSlVpFraActivity";

    private RadioGroup rgSlVpFra;
    private RbSlVpFraAdapter mRbSlVpFraAdapter;
    private ViewPager mViewPager;
    private int tag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rb_sl_vp_fra);

        mRbSlVpFraAdapter = new RbSlVpFraAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        rgSlVpFra = findViewById(R.id.rg_rb_sl_vp_fra);
        mViewPager = findViewById(R.id.vp_tb_sl_vp_frg);
        mViewPager.setAdapter(mRbSlVpFraAdapter);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        rgSlVpFra.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        RadioButton radioButton;
        int id = v.getId();
        switch (id) {
            case R.id.btn_add:
                radioButton = new RadioButton(this);
                if (tag > 0)
                    Constant.rb_sl_vp_fra_tag = "第 " + tag + " 个界面";
                radioButton.setId(tag);
                tag = tag + 1;
                radioButton.setPadding(40, 45, 45, 40);
                radioButton.setButtonDrawable(null);
                radioButton.setBackgroundResource(R.drawable.select_color);
                radioButton.setText(Constant.rb_sl_vp_fra_tag);
                mRbSlVpFraAdapter.addFragment(new ShowFragment());
                rgSlVpFra.addView(radioButton);
                break;
            case R.id.btn_delete:
                radioButton = findViewById(tag);
                if (radioButton != null) {
                    tag = tag - 1;
                    if (tag > 0)
                        rgSlVpFra.removeView(radioButton);
                    boolean isDelete = mRbSlVpFraAdapter.removeFragment(tag);
                    if (!isDelete)
                        Toast.makeText(this, "最少保证有一个界面", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        mViewPager.setCurrentItem(checkedId);
    }

    @Override
    public void onPageSelected(int position) {
        ((RadioButton) findViewById(position)).setChecked(true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
