package com.example.titlemenu.tb_vp_fra;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CreateTime: 2020/1/10 10:26
 * Author: hxd
 * Content:
 * UpdateTime:
 * UpdateName;
 * UpdateContent:
 */
public class TbVpAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "标题";

    private List<Class> fragmentNames;   //创建List来管理 Fragment的 Class
    private List<String> mTitles;
    private Map<String, Class> mStringClassMap;


    TbVpAdapter(FragmentManager fm) {
        super(fm);
        fragmentNames = new ArrayList<>();
        mTitles = new ArrayList<>();
        mStringClassMap = new HashMap<>();
    }

    void addFragment(Fragment fragment, String title) {

        if (mTitles != null) {
            mTitles.add(title);
        }

        if (mStringClassMap != null) {
            mStringClassMap.put(title, fragment.getClass());
        }

        if (fragment != null) {
            fragmentNames.add(fragment.getClass());
            //更新界面
            notifyDataSetChanged();
        }
    }

    void removeIndexData(String title) {

        if (fragmentNames.size() <= 2) {
            Log.d(TAG, "数据禁止小于2");
            return;
        }

        if (mTitles != null) {
            mTitles.remove(title);
        }
        Class fragment = null;
        if (mStringClassMap != null) {
            fragment = mStringClassMap.get(title);
        }
        if (fragmentNames != null) {
            fragmentNames.remove(fragment);
            //更新界面
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) fragmentNames.get(position).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragmentNames.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d(TAG, String.valueOf(mTitles));
        return mTitles.get(position);
    }

}
