package com.marathidevelopers.bhmsnotesapp.Stuff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;

import com.marathidevelopers.bhmsnotesapp.R;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WebView aboutus = findViewById(R.id.about);
        aboutus.loadUrl("file:///android_asset/bcs.html");
    }
}