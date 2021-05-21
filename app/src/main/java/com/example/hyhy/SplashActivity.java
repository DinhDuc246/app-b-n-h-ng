package com.example.hyhy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.airbnb.lottie.LottieAnimationView;
import static com.example.hyhy.R.anim.bottom_animation;
import static com.example.hyhy.R.anim.top_animation;


public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 3000;
    LottieAnimationView animation_view;
    Animation topanimation,bottomanimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        animation_view = findViewById(R.id.animation_view);

        // Animation//
        topanimation = AnimationUtils.loadAnimation(this,top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this,bottom_animation);
        /////////////status bar hide start ///////////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /////////////status bar hide end ///////////////

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}