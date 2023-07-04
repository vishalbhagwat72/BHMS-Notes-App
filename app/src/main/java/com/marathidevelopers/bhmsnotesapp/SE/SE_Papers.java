package com.marathidevelopers.bhmsnotesapp.SE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.marathidevelopers.bhmsnotesapp.BE.BE_Books;
import com.marathidevelopers.bhmsnotesapp.R;

public class SE_Papers extends AppCompatActivity {
    WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se_papers);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        wb = (WebView) findViewById(R.id.web);
        wb.loadUrl("https://drive.google.com/drive/folders/1hTRJ_yMek_etR5Zh5uMGCT9Krnb06JC5?usp=drive_link");
        wb.setWebViewClient(new SE_Papers.Client());
        WebSettings ws = wb.getSettings();
        ws.setJavaScriptEnabled(true);
        wb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wb.clearCache(true);
        wb.clearHistory();
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

    public void onStart() {
        super.onStart();
        this.wb.setDownloadListener(new DownloadListener() {
            @SuppressLint("WrongConstant")
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                request.addRequestHeader("cookie", CookieManager.getInstance().getCookie(str));
                request.addRequestHeader("User-Agent", str2);
                request.setDescription("Downloading file...");
                request.setTitle(URLUtil.guessFileName(str, str3, str4));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str3, str4));
                ((DownloadManager)
                        SE_Papers.this.getSystemService("download")).enqueue(request);
                Toast.makeText(getApplicationContext(),"Downloading Started",Toast.LENGTH_SHORT).show();
                SE_Papers.this.registerReceiver(new BroadcastReceiver() {
                                                   public void onReceive(Context context, Intent intent) {
                                                       Toast.makeText(getApplicationContext(),"Download Completed",Toast.LENGTH_SHORT).show();
                                                       SE_Papers.this.unregisterReceiver(this); }},
                        new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            }
        });
    }
}