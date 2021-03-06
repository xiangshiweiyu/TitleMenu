package com.example.titlemenu.tb_rlv;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.titlemenu.Constant;
import com.example.titlemenu.R;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Field;

public class TbRlvActivity extends AppCompatActivity implements View.OnClickListener,
        TabLayout.BaseOnTabSelectedListener {

    private static final String TAG = "TbRlvActivity";
    private TabLayout tbRlv;
    private RecyclerView rlvTb;
    private TbRlvAdapter mTbRlvAdapter;
    private int tag = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_rlv);
        tbRlv = findViewById(R.id.tb_rlv);
        rlvTb = findViewById(R.id.rlv_tb);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mTbRlvAdapter = new TbRlvAdapter(this);
        rlvTb.setLayoutManager(layoutManager);
        rlvTb.setAdapter(mTbRlvAdapter);


        rlvTb.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int item;
                if (dx >= 0) {
                    item = layoutManager.findLastVisibleItemPosition();
                } else {
                    item = layoutManager.findFirstVisibleItemPosition();
                }
                rlvTb.scrollToPosition(item);
                tbRlv.setScrollPosition(item, 0, true);
            }
        });

        tbRlv.addTab(tbRlv.newTab().setText("初始化界面"));
        mTbRlvAdapter.setTitle("初始化界面");
        tbRlv.addOnTabSelectedListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_add:
                tag = tag + 1;
                Constant.tb_rlv_tag = "第 " + tag + "个界面";
                tbRlv.addTab(tbRlv.newTab().setText(Constant.tb_rlv_tag), tag);
                mTbRlvAdapter.setTitle(Constant.tb_rlv_tag);
                break;
            case R.id.btn_delete:
                if (tag > 0) {
                    tag = tag - 1;
                    tbRlv.removeTabAt(tag);
                    mTbRlvAdapter.removeTitle(tag);
                } else {
                    Toast.makeText(this, "最少保留一个界面", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int id = tab.getPosition();
        //        rlvFragent.scrollToPosition(id);
        rlvTb.smoothScrollToPosition(id); //滑动存在的话效果
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
