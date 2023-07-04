package com.marathidevelopers.bhmsnotesapp.Stuff;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;

import com.marathidevelopers.bhmsnotesapp.R;

public class otherApps extends AppCompatActivity {
    WebView app;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_apps);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        app= (WebView)findViewById(R.id.app);
        app.loadUrl("https://play.google.com/store/apps/dev?id=7639115298975832359");
    }
}