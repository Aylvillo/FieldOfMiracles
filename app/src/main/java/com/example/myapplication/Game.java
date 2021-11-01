package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

/*

[*] - не обязательное сообщение
[!] - не разобрался\ошибка
[!\?] - вроде сделано но требуется проверка
[?] - необходимо сделать модуль кода
[?*] - ВОЗМОЖНО требуется сделать (из-за не точности тз)

если нет обозначения но стоит комент то это пояснение

 */

public class Game extends AppCompatActivity {

    private ImageView baraban, p1_on,p2_on,p3_on,p1_off,p2_off,p3_off;
    private ImageView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
    private int last;
    int lvl_game;
    private boolean spinning = false;
    int switchPlayers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);


        init_ImageView();
        Name();

    }



    // определение сложности и отоброжение соответсующего количества клеток
    public void Name(){
        Bundle arguments= getIntent().getExtras();
        lvl_game = arguments.getInt("lvl_gameMail");

        if (lvl_game == 0){
            c1.setVisibility(View.VISIBLE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
        }
        else if(lvl_game == 1){
            c1.setVisibility(View.VISIBLE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
            c5.setVisibility(View.VISIBLE);
            c6.setVisibility(View.VISIBLE);
        }
        else if(lvl_game == 2){
            c1.setVisibility(View.VISIBLE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            c4.setVisibility(View.VISIBLE);
            c5.setVisibility(View.VISIBLE);
            c6.setVisibility(View.VISIBLE);
            c7.setVisibility(View.VISIBLE);
            c8.setVisibility(View.VISIBLE);
            c9.setVisibility(View.VISIBLE);
            c10.setVisibility(View.VISIBLE);
            c11.setVisibility(View.VISIBLE);
            c12.setVisibility(View.VISIBLE);
        }
        else {
            Toast.makeText(Game.this, R.string.Error01, Toast.LENGTH_LONG).show();
        }
    }

    // привязка картинок к переменным (барабан, игроки, клетки для слов)
    @SuppressLint("WrongViewCast")
    public void init_ImageView(){

        // другое
        baraban = findViewById(R.id.Baraban);

        // обьявление игрококов (вкл\выкл)
        p1_on = findViewById(R.id.player1_on);
        p2_on = findViewById(R.id.player2_on);
        p3_on = findViewById(R.id.player3_on);

        p1_off = findViewById(R.id.player1_off);
        p2_off = findViewById(R.id.player2_off);
        p3_off = findViewById(R.id.player3_off);

        // обьявление клеток
        c1 = findViewById(R.id.character);
        c2 = findViewById(R.id.character2);
        c3 = findViewById(R.id.character3);
        c4 = findViewById(R.id.character4);
        c5 = findViewById(R.id.character5);
        c6 = findViewById(R.id.character6);
        c7 = findViewById(R.id.character7);
        c8 = findViewById(R.id.character8);
        c9 = findViewById(R.id.character9);
        c10 = findViewById(R.id.character10);
        c11 = findViewById(R.id.character11);
        c12 = findViewById(R.id.character12);

        // скрытие клеток
        c1.setVisibility(View.GONE);
        c2.setVisibility(View.GONE);
        c3.setVisibility(View.GONE);
        c4.setVisibility(View.GONE);
        c5.setVisibility(View.GONE);
        c6.setVisibility(View.GONE);
        c7.setVisibility(View.GONE);
        c8.setVisibility(View.GONE);
        c9 .setVisibility(View.GONE);
        c10.setVisibility(View.GONE);
        c11.setVisibility(View.GONE);
        c12.setVisibility(View.GONE);

    }

    public void goGame(View view) {
        /*

        кнопка отвечающая за:
         - [?]проверку,
         - [?]начисление очков текущему игроку,
         - [!\?]кручение барабана (вроде сделал)
         - [?]и отоброжение отгаданых букв в клетках

        */

        // [!\?]прокрутка барабана (в данный момент по сути бпрпбпн ни на что не влияет т.к.
        // не помню чтобы в тз говорилось про барабан([?*]хотя это вроде определяет количество
        // очков в случае победы ... тогда это надо сделать[/?*])):
        if (!spinning) {
            int min = 10000;
            int max = 30000;
            int diff = max - min;
            Random random = new Random();
            int new_rand = random.nextInt(diff + 1);
            float pointWidth = baraban.getWidth() / 2;
            float pointHeight = baraban.getHeight() / 2;
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
            baraban.startAnimation(rotation);
        }

        if(switchPlayers == 0){ // [*] да я понимаю что это можно было бы сделать через switch но оставим это для создания разнообразия между нашими кодами
            p1_off.setVisibility(View.GONE);
            p1_on.setVisibility(View.VISIBLE);


            //[?] тут нужен модуль считывания буквы проверки зачисления очков а так же проверка на окончательную победу с последующим переходом


            p1_on.setVisibility(View.GONE);
            p1_off.setVisibility(View.VISIBLE);
            switchPlayers = 1;
        }
        else if(switchPlayers == 1){
            p2_off.setVisibility(View.GONE);
            p2_on.setVisibility(View.VISIBLE);


            //[?]тут нужен модуль считывания буквы проверки зачисления очков а так же проверка на окончательную победу с последующим переходом


            p2_on.setVisibility(View.GONE);
            p2_off.setVisibility(View.VISIBLE);
            switchPlayers = 2;
        }
        else if(switchPlayers == 2){
            p3_off.setVisibility(View.GONE);
            p3_on.setVisibility(View.VISIBLE);


            //[?]тут нужен модуль считывания буквы проверки зачисления очков а так же проверка на окончательную победу с последующим переходом


            p3_on.setVisibility(View.GONE);
            p3_off.setVisibility(View.VISIBLE);
            switchPlayers = 0;
        }
        else {
            Toast.makeText(Game.this, R.string.Error02, Toast.LENGTH_LONG).show();
        }








    }
}