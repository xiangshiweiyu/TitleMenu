package com.example.titlemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.titlemenu.rb_sl_vp_frg.RbSlVpFraActivity;
import com.example.titlemenu.tb_rlv.TbRlvActivity;
import com.example.titlemenu.tb_vp2_fra.TbVp2FraActivity;
import com.example.titlemenu.tb_vp2_fra.TbVp2FraAdapter;
import com.example.titlemenu.tb_vp_fra.TbVpFraActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_tb_fra_vp).setOnClickListener(this);
        findViewById(R.id.btn_tb_rlv).setOnClickListener(this);
        findViewById(R.id.btn_rb_sl_vp_frg).setOnClickListener(this);
        findViewById(R.id.btn_tb_fra_vp2).setOnClickListener(this);
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
            case R.id.btn_tb_rlv:
                intent = new Intent(this, TbRlvActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_rb_sl_vp_frg:
                intent = new Intent(this, RbSlVpFraActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_tb_fra_vp2:
                intent = new Intent(this, TbVp2FraActivity.class);
                startActivity(intent);
                break;
        }

    }
}
