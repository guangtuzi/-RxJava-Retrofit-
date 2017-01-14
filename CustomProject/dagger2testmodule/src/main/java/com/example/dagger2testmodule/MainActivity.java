package com.example.dagger2testmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Human human;

    private static final String TAG = "Dagger2 Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerHumanComponent.builder().humanModule(new HumanModule(this)).build().inject(this);

        Log.i(TAG, "onCreate: " + human);

        startActivity(new Intent(this, Main2Activity.class));
    }
}
