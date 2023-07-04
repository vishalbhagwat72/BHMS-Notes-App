package com.marathidevelopers.bhmsnotesapp.Stuff;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.marathidevelopers.bhmsnotesapp.R;

public class Ask_forNotes extends AppCompatActivity {
    WebView asknote;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_notes);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        asknote= (WebView)findViewById(R.id.ask);
        asknote.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfn9r-Qvj_cHVahtrg_aayR5AQOpEnakjUHqzD8WCYHDj2y5Q/viewform?usp=sf_link");
        asknote.setWebViewClient(new Client());
        WebSettings ws = asknote.getSettings();
        ws.setJavaScriptEnabled(true);
        asknote.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        asknote.clearCache(true);
        asknote.clearHistory();
    }
    private class Client extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}