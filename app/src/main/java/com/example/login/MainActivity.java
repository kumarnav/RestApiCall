package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.AsyncTask;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Pwd;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private static final String url1 = "http://illin6033:51360/aprm-portal/Login";
    private static final String BASE_URL = "https://reqres.in/api/login";
    private static AsyncHttpClient client = new AsyncHttpClient();
    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(BASE_URL, params, responseHandler);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.editText2);
        Pwd = findViewById(R.id.editText3);
        Info = findViewById(R.id.textView);
        Login = findViewById(R.id.button2);


        Info.setText("No Of Attempts Remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Pwd.getText().toString());
            }
        });
    }

    private void validate(String UserName , String Password){
        if((UserName.equals("Admin")) && (Password.equals("abc"))){
            Intent i = new Intent(MainActivity.this,APRM_Widget.class);
            startActivity(i);
        }
        else {
            counter--;
            Info.setText("No Of Attempts Remaining: " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}