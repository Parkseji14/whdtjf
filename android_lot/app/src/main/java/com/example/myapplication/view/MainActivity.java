package com.example.myapplication.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

import androidx.appcompat.app.AppCompatActivity;

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

            /* 입력값 가져오기*/
            String eml = email.getText().toString();
            String pwl = pw.getText().toString();

            @Override
            public void onClick(View v) {
                /* eml, pwl 값을 백앤드로 보낸다 */

            }
        });
    }
}
