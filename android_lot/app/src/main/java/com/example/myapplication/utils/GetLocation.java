package com.example.myapplication.utils;

import com.google.android.gms.maps.model.LatLng;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by thswl on 2019-10-29.
 */
/* 사용자 key를 넣으면 ;myzon e에 해당하는 location 을 double 형태로 json 에 담아서 보냄 */
public class GetLocation {
    LatLng lng;

    public GetLocation(String key) {
        login(key);
    }

    public LatLng getLng() {
        return lng;
    }

    public void login(String key) {

        String URL = "/signup";
        RequestParams params = new RequestParams();
        params.put("key", key);
        params.setUseJsonStreamer(true);

        HttpClient.get(URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responseString = new String(responseBody);
                try {
                    JSONObject result = new JSONObject(responseString);
                    Boolean isSuccess = result.getBoolean("result");

                    if (isSuccess == true) {


                        JSONObject user = result.getJSONObject("user");

                        double latitude = Double.parseDouble(user.getString("latitude"));
                        double longitude = Double.parseDouble(user.getString("longtitude"));

                        lng = new LatLng(latitude,longitude);
                        /*
                        uvo.setUsr_key(user.getInt("usr_key"));
                        uvo.setUsr_id(user.getString("usr_id"));
                        uvo.setUsr_name(user.getString("usr_name"));
                        uvo.setUsr_phone(user.getString("usr_phone"));
*/
                    } else {

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

