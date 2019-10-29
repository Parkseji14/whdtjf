package com.example.myapplication.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.myapplication.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by thswl on 2019-10-09.
 */

public class SearchActivity extends AppCompatActivity{

    EditText searchline;
    ImageButton searchbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        searchbutton = (ImageButton) findViewById(R.id.search_button);
        searchline = (EditText) findViewById(R.id.search_line);

        searchbutton.setOnClickListener(new Button.OnClickListener(){

            String searchstr = searchline.getText().toString();

            @Override
            public void onClick(View v) {
                /* search 값을 */


            }
        });

    }

}
