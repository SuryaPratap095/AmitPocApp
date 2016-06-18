package com.example.surya.amitpocapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "jGdWnn4KDsrwvBRoAO3sowGJ5";
    private static final String TWITTER_SECRET = "PAeS5Kg0zwlRxzT6w9VsIOEYoEBLZsA4n5VNXSIwYkkQIL2cT5";
    private AuthCallback authCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits());
        setContentView(R.layout.activity_main);

        authCallback = new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {

            }

            @Override
            public void failure(DigitsException error) {

            }
        };

        DigitsAuthButton digitsAuthButton=(DigitsAuthButton)findViewById(R.id.auth_button);
        digitsAuthButton.setCallback(this.getAuthCallback());
        Digits.authenticate(authCallback,"+91");
    }

    public AuthCallback getAuthCallback() {

        return authCallback;
    }

}
