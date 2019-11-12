package com.example.myapplication.utils;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by thswl on 2019-11-02.
 */

public class ParkinglotAdapter  extends RecyclerView.Adapter<ParkinglotAdapter.CustomViewHolder>{
    /*https://webnautes.tistory.com/1214*/

    private ArrayList<String> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView english;


        public CustomViewHolder(View view) {
            super(view);
            this.english = (TextView) view.findViewById(R.id.english_listitem);
        }
    }


    public ParkinglotAdapter(ArrayList<String> list) {
        this.mList = list;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.part_item_list, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.english.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.english.setGravity(Gravity.CENTER);
        viewholder.english.setText((CharSequence) mList.get(position));

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
