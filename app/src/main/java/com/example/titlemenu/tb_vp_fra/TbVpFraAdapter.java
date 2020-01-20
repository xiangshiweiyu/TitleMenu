package com.example.titlemenu.tb_vp_fra;

import android.util.Log;

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
public class TbVpFraAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "TbVpFraActivity";

    private List<Class> fragmentNames;   //创建List来管理 Fragment的 Class
    private List<String> mTitles;
    private Map<String, Class> mStringClassMap;
    //    private FragmentManager fm;
    private int mChildCount = 0;

    TbVpFraAdapter(FragmentManager fm) {
        super(fm);
        //        this.fm = fm;
        fragmentNames = new ArrayList<>();
        mTitles = new ArrayList<>();
        mStringClassMap = new HashMap<>();
    }

    TbVpFraAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        //        this.fm = fm;
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
        }
        notifyDataSetChanged();
    }

    void removeIndexData(String title) {

        if (fragmentNames.size() <= 1) {
            Log.d(TAG, "至少保留一个界面");
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
        }
        notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (mChildCount > 0) {
            mChildCount--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
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
        Log.d(TAG, String.valueOf(fragmentNames.size()));
        return mTitles.get(position);
    }

    //    @NonNull
    //    @Override
    //    public Fragment instantiateItem(@NonNull ViewGroup container, int position) {
    //        Fragment fragment = (Fragment) super.instantiateItem(container, position);
    //        fm.beginTransaction().show(fragment).commit();
    //        return fragment;
    //    }
    //
    //    @Override
    //    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    //        if (position >= getCount()) {
    //            return;
    //        }
    //        Fragment fragment = null;
    //        try {
    //            fragment = (Fragment) fragmentNames.get(position).newInstance();
    //        } catch (IllegalAccessException | InstantiationException e) {
    //            e.printStackTrace();
    //        }
    //        if (fragment != null)
    //            fm.beginTransaction().detach(fragment).commit();
    //    }
}
