package com.marathidevelopers.bhmsnotesapp.Stuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.marathidevelopers.bhmsnotesapp.MainActivity;
import com.marathidevelopers.bhmsnotesapp.R;

public class Splash_Screen extends AppCompatActivity {


    Animation topAnim;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);

        image = findViewById(R.id.image22);
        image.setAnimation(topAnim);
        Thread td = new Thread(){
            public  void run(){
                try {
                    sleep(3000);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {

                    Intent intent = new Intent(Splash_Screen.this ,MainActivity.class );
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();



    }
}
