package com.maple.healthyfoods;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signup extends Activity implements View.OnClickListener {
    TextView login_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        login_tv = findViewById(R.id.login_tv);
        login_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_tv:
                Intent login = new Intent(Signup.this, Login.class);
                startActivity(login);
                finish();
                break;
        }
    }
}
