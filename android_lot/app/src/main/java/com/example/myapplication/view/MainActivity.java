package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.utils.HttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button singup;
    EditText email;
    EditText pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login_submit);
        singup = (Button) findViewById(R.id.sign_up);
        email = (EditText) findViewById(R.id.login_email);
        pw = (EditText) findViewById(R.id.login_pw);




        /* 로그인 버튼 */
        login.setOnClickListener(new Button.OnClickListener(){



            @Override
            public void onClick(View v) {
                /* 입력값 가져오기*/
                String eml = email.getText().toString();
                String pwl = pw.getText().toString();

                /* eml, pwl 값을 백앤드로 보낸다 */
                /* true 값을 받는다면 다음 페이지로 넘어간다 */
                    login(eml,pwl);



            }
        });
    }

    public void login(String eml, String pwl) {
        String URL = "/signup";
        RequestParams params = new RequestParams();
        params.put("id", eml);
        params.put("pw", pwl);
        params.setUseJsonStreamer(true);

        HttpClient.get(URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responseString = new String(responseBody);
                try {
                    JSONObject result = new JSONObject(responseString);
                    Boolean isSuccess = result.getBoolean("result");

                    if (isSuccess == true) {
                        Log.i("login", "Login Success");
                        Toast.makeText(MainActivity.this, "로그인성공", Toast.LENGTH_LONG).show();
                        /*
                        JSONObject user = result.getJSONObject("user");
                        uvo.setUsr_key(user.getInt("usr_key"));
                        uvo.setUsr_id(user.getString("usr_id"));
                        uvo.setUsr_name(user.getString("usr_name"));
                        uvo.setUsr_phone(user.getString("usr_phone"));
*/
                        ////////////////////// 세션저장 //////////////////////

                        Intent intent = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent);

                        //overridePendingTransition(R.anim.enter_no_anim, R.anim.exit_no_anim);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "실패했습니다", Toast.LENGTH_LONG).show();
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
