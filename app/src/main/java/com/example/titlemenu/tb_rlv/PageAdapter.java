package com.example.titlemenu.tb_rlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titlemenu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * CreateTime: 2020/1/10 17:28
 * Author: hxd
 * Content:
 * UpdateTime:
 * UpdateName;
 * UpdateContent:
 */
public class PageAdapter extends RecyclerView.Adapter<PageAdapter.PageViewHolder> {

    private static final String TAG = "TbRlvActivity";
    private Context mContext;
    private List<String> mTitle;
    //    private HashMap<String, Integer> mMap;


    public PageAdapter(Context context) {
        mContext = context;
        if (mTitle == null)
            mTitle = new ArrayList<>();
        //
        //        if (mMap == null)
        //            mMap = new HashMap<>();
    }

    public void setTitle(String title) {
        if (mTitle != null)
            mTitle.add(title);
        notifyDataSetChanged();
    }

    public void removeTitle(int pos) {
        if (mTitle != null)
            mTitle.remove(pos);
        notifyItemRemoved(pos);
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.page_fra_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {
        String title = mTitle.get(position);
        holder.mButton.setText(title);
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }


    class PageViewHolder extends RecyclerView.ViewHolder {
        Button mButton;

        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.btn_page);
        }
    }
}
