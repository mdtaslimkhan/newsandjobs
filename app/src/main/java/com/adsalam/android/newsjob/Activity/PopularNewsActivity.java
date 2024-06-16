package com.adsalam.android.newsjob.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.adsalam.android.newsjob.NewsFragments.PopularNewsFragment;
import com.adsalam.android.newsjob.R;

public class PopularNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PopularNewsFragment())
                .commit();
    }
}