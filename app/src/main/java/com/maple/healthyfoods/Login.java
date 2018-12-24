package com.maple.healthyfoods;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

public class Login extends Activity implements View.OnClickListener {
    AppCompatButton login_btn;
    TextView signup_tv;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

       /* ShimmerFrameLayout container =
                (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        container.startShimmer();*/

         login_btn = findViewById(R.id.login_btn);
         login_btn.setOnClickListener(this);

         signup_tv = findViewById(R.id.signup_tv);
         signup_tv.setOnClickListener(this);
     }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                Intent home = new Intent(Login.this,OTP.class);
                startActivity(home);
                finish();
                break;

            case R.id.signup_tv:
                Intent signup_tv = new Intent(Login.this,Signup.class);
                startActivity(signup_tv);
                finish();
                break;
        }
    }
}
