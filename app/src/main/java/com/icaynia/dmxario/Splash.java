package com.icaynia.dmxario;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.icaynia.dmxario.Activity.LoginActivity;
import com.icaynia.dmxario.Activity.MainActivity;
/**
 * Created by icaynia on 2016. 12. 14..
 */

public class Splash extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        viewInitialize();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean islogin = false;
                if (!islogin) {
                    onLoginButton();
                }
                //onMainActivity();
                //finish();
            }
        }, 3000);

    }

    public void onMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public void onLoginButton() {
        LinearLayout loginBox = (LinearLayout) findViewById(R.id.login);
        loginBox.setVisibility(View.VISIBLE);
    }

    private void viewInitialize() {
        LinearLayout loginAsFacebook = (LinearLayout) findViewById(R.id.login_facebook);
        LinearLayout loginAsEmail = (LinearLayout) findViewById(R.id.login_email);

        loginAsFacebook.setOnClickListener(this);
        loginAsEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_facebook:
                onMainActivity();
                break;
            case R.id.login_email:
                onLoginActivity();
                break;
        }
    }
}
