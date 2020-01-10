package com.example.titlemenu.tb_vp_fra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.titlemenu.R;
import com.google.android.material.tabs.TabLayout;

public class TbVpFraActivity extends AppCompatActivity implements View.OnClickListener {


    private int index = 1;
    private TbVpAdapter tbVpAdapter;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_vp_fra);
        name = "第" + index + "个界面";
        TabLayout tbVp = findViewById(R.id.tb_vp);
        ViewPager vpTb = findViewById(R.id.vp_tb);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);

        tbVpAdapter = new TbVpAdapter(getSupportFragmentManager());
        tbVpAdapter.addFragment(new ShowFragment(), "初始界面");
        tbVpAdapter.addFragment(new ShowFragment(), name);
        vpTb.setAdapter(tbVpAdapter);
        tbVp.setupWithViewPager(vpTb);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_add:
                index = index+1;
                name = "第" + index + "个界面";
                tbVpAdapter.addFragment(new ShowFragment(), name);
                break;
            case R.id.btn_delete:
                tbVpAdapter.removeIndexData(name);
                break;
        }
    }
}
