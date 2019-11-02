package com.example.myapplication.utils;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by thswl on 2019-11-02.
 */

public class GetParkingLot {
    String Prkname;

    public GetParkingLot(String prkname) {
        Prkname = prkname;
    }

    /* 사용자가 입력한 주차장 이름이 포함된 주차장들을 모두 불러온다 */
    public void parkinglots(String key) {

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

                        JSONObject user = result.getJSONObject("park");
                        /* 백엔드에서 주차장 목록을 반환 형식 ?? */
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
