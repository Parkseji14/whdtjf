package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.VO.Cars;
import com.example.myapplication.utils.HttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;

/**
 * Created by thswl on 2019-10-09.
 */

public class
MyzoneActivity extends AppCompatActivity {

    Cars cars;

    Button search;
    Button map;
    Button myzone;

    ImageView car_1;
    ImageView car_2;
    ImageView car_3;
    ImageView car_4;
    ImageView car_5;
    ImageView car_6;
    ImageView car_7;
    ImageView car_8;
    ImageView car_9;
    ImageView car_10;
    ImageView car_11;
    ImageView car_12;
    ImageView car_13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myzone_activity);

        car_set2("test");

        search = (Button)findViewById(R.id.search);
        map = (Button)findViewById(R.id.map);
        myzone = (Button)findViewById(R.id.myzone);

        car_1 = (ImageView) findViewById(R.id.car_1);
        car_2 = (ImageView) findViewById(R.id.car_2);
        car_3 = (ImageView) findViewById(R.id.car_3);
        car_4 = (ImageView) findViewById(R.id.car_4);
        car_5 = (ImageView) findViewById(R.id.car_5);
        car_6 = (ImageView) findViewById(R.id.car_6);
        car_7 = (ImageView) findViewById(R.id.car_7);
        car_8 = (ImageView) findViewById(R.id.car_8);
        car_9 = (ImageView) findViewById(R.id.car_9);
        car_10 = (ImageView) findViewById(R.id.car_10);
        car_11 = (ImageView) findViewById(R.id.car_11);
        car_12 = (ImageView) findViewById(R.id.car_12);
        car_13 = (ImageView) findViewById(R.id.car_13);



        if (cars.getCar1() == 0) {
            car_1.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar2() == 0) {
            car_2.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar3() == 0) {
            car_3.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar4() == 0) {
            car_4.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar5() == 0) {
            car_5.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar6() == 0) {
            car_6.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar7() == 0) {
            car_7.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar8() == 0) {
            car_8.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar9() == 0) {
            car_9.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar10() == 0) {
            car_10.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar11() == 0) {
            car_11.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar12() == 0) {
            car_12.setVisibility(View.INVISIBLE);
        }
        if (cars.getCar13() == 0) {
            car_13.setVisibility(View.INVISIBLE);
        }

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyzoneActivity.this, SearchActivity.class);
                startActivity(intent);
                finish();
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyzoneActivity.this, MapActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void car_set2(String key) {
        cars = new Cars(0, 1, 0, 1, 0, 0, 1, 1,1,1,1,0,1);

    }

    public void car_set(String key) {
        String URL = "/signup";
        RequestParams params = new RequestParams();
        /* key : 주차장 키 */
        params.put("key", key);
        params.setUseJsonStreamer(true);

        /* car set test */
        HttpClient.get(URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responseString = new String(responseBody);
                try {
                    JSONObject result = new JSONObject(responseString);
                    Boolean isSuccess = result.getBoolean("result");

                    if (isSuccess == true) {
                        Log.i("login", "Login Success");
                        Toast.makeText(MyzoneActivity.this, "주차장 세팅 성공", Toast.LENGTH_LONG).show();

                        JSONObject user = result.getJSONObject("cars");

                        /*
                        cars = new Cars(user.getInt("car_1"), user.getInt("car_2"),user.getInt("car_3"),user.getInt("car_4"),user.getInt("car_5"),user.getInt("car_6"),user.getInt("car_7"),user.getInt("car_8"));





                        uvo.setUsr_key(user.getInt("usr_key"));
                        uvo.setUsr_id(user.getString("usr_id"));
                        uvo.setUsr_name(user.getString("usr_name"));
                        uvo.setUsr_phone(user.getString("usr_phone"));
*/

                        //overridePendingTransition(R.anim.enter_no_anim, R.anim.exit_no_anim);
                        finish();
                    } else {
                        Toast.makeText(MyzoneActivity.this, "실패했습니다", Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }

        });
    }
}
