package com.maple.healthyfoods;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Prelogin extends Activity implements View.OnClickListener {
    TextView sign_tv, signup_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prelogin);

        signup_tv = findViewById(R.id.signup_tv);
        sign_tv = findViewById(R.id.sign_tv);

        sign_tv.setOnClickListener(this);
        signup_tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signup_tv:
                Intent signup_tv = new Intent(Prelogin.this, Signup.class);
                startActivity(signup_tv);
                break;

            case R.id.sign_tv:
                Intent sign_tv = new Intent(Prelogin.this, Login.class);
                startActivity(sign_tv);
                break;
        }
    }
}
