package com.landsoft.intentchangeactivivy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage, mTextEmail, mTextPassword;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    getIntentBundle();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    mTextEmail.setText("");
                    mTextPassword.setText("");
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    mTextEmail.setText("");
                    mTextPassword.setText("");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextEmail = (TextView) findViewById(R.id.tv_email);
        mTextPassword = (TextView) findViewById(R.id.tv_password);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void getIntentBundle(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(LoginActivity.BUNDLE);
        String mEmail = bundle.getString(LoginActivity.EMAIL);
        String mPassword = bundle.getString(LoginActivity.PASSWORD);
        mTextEmail.setText(mEmail);
        mTextPassword.setText(mPassword);
    }

}
