package com.example.titlemenu.rb_sl_vp_frg;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * CreateTime: 2020/1/14 11:28
 * Author: hxd
 * Content:
 * UpdateTime:
 * UpdateName;
 * UpdateContent:
 */
public class RbSlVpFraAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "RbSlVpFraActivity";
    private List<Class> fragments;
    private int mChildCount = 0;


    RbSlVpFraAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        if (fragments == null)
            fragments = new ArrayList<>();
    }

    void addFragment(Fragment fragment) {
        if (fragments != null) {
            fragments.add(fragment.getClass());
        }
        notifyDataSetChanged();
    }

    /**
     * 删除指定的 Fragment
     *
     * @param index Fragment 位置
     * @return 返回是否删除成功
     */
    boolean removeFragment(int index) {
        if (fragments != null && fragments.size() > 1) {
            fragments.remove(index);
            notifyDataSetChanged();
            return true;
        } else {
            return false;
        }
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
            return (Fragment) fragments.get(position).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
