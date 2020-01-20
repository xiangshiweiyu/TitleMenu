package com.example.titlemenu.tb_vp2_fra;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * CreateTime: 2020/1/10 10:26
 * Author: hxd
 * Content:
 * UpdateTime:
 * UpdateName;
 * UpdateContent:
 */
public class TbVp2FraAdapter extends FragmentStateAdapter {

    private static final String TAG = "TbVp2FraActivity";

    private List<Class> fragments;

    public TbVp2FraAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        if (fragments == null)
            fragments = new ArrayList<>();
    }

    void addFragment(Fragment fragment) {
        if (fragments != null) {
            fragments.add(fragment.getClass());
        }
        notifyDataSetChanged();
    }

    void removeFragment(int index) {
        if (fragments != null && fragments.size() > 0) {
            fragments.remove(index);
            notifyItemRemoved(index);
        }
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        try {
            return (Fragment) fragments.get(position).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
