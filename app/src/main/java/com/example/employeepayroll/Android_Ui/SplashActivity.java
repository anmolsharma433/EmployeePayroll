package com.example.employeepayroll.Android_Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.employeepayroll.R;

public class SplashActivity extends Activity {
    private boolean isFirstAnimation = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        * Duration of wait **/
        final ImageView imageView = findViewById(R.id.header_icon);
        Animation hold = AnimationUtils.loadAnimation(this, R.anim.hold);


        final Animation translateScale = AnimationUtils.loadAnimation(this, R.anim.translate_scale);
        translateScale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isFirstAnimation) {
                    imageView.clearAnimation();
                    Intent intent = new Intent(SplashActivity.this, LogIn.class);
                    startActivity(intent);
                    finish();
                }

                isFirstAnimation = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        hold.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.clearAnimation();
                imageView.startAnimation(translateScale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(hold);

        final int SPLASH_DISPLAY_LENGTH = 1000;
//            /* New Handler to start the Menu-Activity
//             * and close this Splash-Screen after some seconds.*/
//            new Handler().postDelayed(new Runnable(){
//                @Override
//                public void run() {
//                    /* Create an Intent that will start the Menu-Activity. */
//                    Intent mainIntent = new Intent(SplashActivity.this, LogIn.class);
//                    SplashActivity.this.startActivity(mainIntent);
//                    SplashActivity.this.finish();
//                }
//            }, SPLASH_DISPLAY_LENGTH);
//        imageView.startAnimation(hold);
//        }
    }
    }

