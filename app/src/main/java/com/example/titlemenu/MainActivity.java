package com.example.titlemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.titlemenu.tb_vp_fra.TbVpAdapter;
import com.example.titlemenu.tb_vp_fra.TbVpFraActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_tb_fra_vp).setOnClickListener(this);
        findViewById(R.id.btn_rlv_frg).setOnClickListener(this);
        findViewById(R.id.btn_sl_tv_vp_fra).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        switch (id) {
            case R.id.btn_tb_fra_vp:
                intent = new Intent(this, TbVpFraActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_rlv_frg:
                break;
            case R.id.btn_sl_tv_vp_fra:
                break;
        }

    }
}
