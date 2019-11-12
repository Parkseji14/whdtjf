package com.example.myapplication.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.myapplication.R;
import com.example.myapplication.utils.ParkinglotAdapter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by thswl on 2019-10-09.
 */

public class SearchActivity extends AppCompatActivity{

    EditText searchline;
    ImageButton searchbutton;

    private ArrayList<String> mArrayList;
    private ParkinglotAdapter mAdapter;
    private int count = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        searchbutton = (ImageButton) findViewById(R.id.search_button);
        searchline = (EditText) findViewById(R.id.search_line);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        mArrayList = new ArrayList<>();

        mAdapter = new ParkinglotAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        searchbutton.setOnClickListener(new Button.OnClickListener(){

            String searchstr = searchline.getText().toString();

            @Override
            public void onClick(View v) {
                /* search 값을 */

                mArrayList.add("test...");
                mArrayList.add("hello world..");

                mAdapter.notifyDataSetChanged();
            }
        });

    }

}
