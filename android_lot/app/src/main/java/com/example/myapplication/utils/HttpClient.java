package com.example.myapplication.utils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by thswl on 2019-10-16.
 */

public class HttpClient {
    private static final String BASE_URL = "http://13.209.64.237:8000/usermanage";
    private static AsyncHttpClient client = new AsyncHttpClient();

    private HttpClient(){

    }

    public static AsyncHttpClient getInstance(){
//        if(client == null){
//            client  =
//        }
        return client;
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void getImage(String url, AsyncHttpResponseHandler responseHandler){
        String requestURL = BASE_URL + url;
        client.get(requestURL, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String url){
        return BASE_URL + url;
    }


}