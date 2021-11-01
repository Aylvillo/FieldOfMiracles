package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class Finish extends AppCompatActivity {

    private ImageView baraban_onStart;
    private int last;
    private boolean spinning = false;
    Intent intent = new Intent(this, Menu.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);
        baraban_onStart = findViewById(R.id.imageView2);

    }
    public void BTN_restart (View view){
        startActivity(intent);
    }

    //[!\?]Анимация поворота барабана
    public void BTN_rollBaraban_onFinish(View view) {
        if (!spinning) {
            int min = 10000;
            int max = 30000;
            int diff = max - min;
            Random random = new Random();
            int new_rand = random.nextInt(diff + 1);
            float pointWidth = baraban_onStart.getWidth() / 2;
            float pointHeight = baraban_onStart.getHeight() / 2;
            Animation rotation = new RotateAnimation(last, new_rand, pointWidth, pointHeight);
            rotation.setDuration(2700);
            rotation.setFillAfter(true);
            rotation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            last = new_rand;
            baraban_onStart.startAnimation(rotation);
        }
    }

}