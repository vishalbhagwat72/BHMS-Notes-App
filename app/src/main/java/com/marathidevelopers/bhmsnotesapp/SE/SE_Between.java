package com.marathidevelopers.bhmsnotesapp.SE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.marathidevelopers.bhmsnotesapp.FE.FE_Between;
import com.marathidevelopers.bhmsnotesapp.FE.FE_Books;
import com.marathidevelopers.bhmsnotesapp.FE.FE_Notes;
import com.marathidevelopers.bhmsnotesapp.FE.FE_Papers;
import com.marathidevelopers.bhmsnotesapp.MainActivity;
import com.marathidevelopers.bhmsnotesapp.R;
import com.marathidevelopers.bhmsnotesapp.Stuff.Ask_forNotes;
import com.marathidevelopers.bhmsnotesapp.Stuff.otherApps;

public class SE_Between extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, share, ask, rate, other;
    private AdView mAdView;

    CardView box1;
    CardView box2;
    CardView box3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se_between);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawerLayout = findViewById(R.id.nav_view);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        ask = findViewById(R.id.ask);
        share = findViewById(R.id.share);
        other = findViewById(R.id.other);
        rate = findViewById(R.id.rate);

        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);
        box3 = findViewById(R.id.box3);

        MobileAds.initialize(this, initializationStatus -> {
        });

//        AdView adView = new AdView(this);
//        adView.setAdSize(AdSize.SMART_BANNER);
//        adView.setAdUnitId(getString(R.string.banner));
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

        box1.setOnClickListener(v -> startActivity(new Intent(SE_Between.this, SE_Notes.class)));

        box2.setOnClickListener(v -> startActivity(new Intent(SE_Between.this, SE_Books.class)));

        box3.setOnClickListener(v -> startActivity(new Intent(SE_Between.this, SE_Papers.class)));

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SE_Between.this, MainActivity.class));
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SE_Between.this, otherApps.class));
            }
        });

        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SE_Between.this, Ask_forNotes.class));
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareintent = new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
                shareintent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.marathidevelopers.bhmsnotesapp");
                shareintent.setType("text/plain");
                startActivity(Intent.createChooser(shareintent, "Share Via"));
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + getPackageName())));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
            }
        });
    }



    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer((GravityCompat.START));
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }


}
