package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class Menu extends AppCompatActivity {

    Intent intent = new Intent(this, Game.class);
    int lvl_game = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        RadioGroup radioGroup = findViewById(R.id.RadioGpoup_changeLVL);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.radioButton:
                        lvl_game = 0;
                        break;
                    case R.id.radioButton2:
                        lvl_game = 1;
                        break;
                    case R.id.radioButton3:
                        lvl_game = 2;
                        break;
                }
                intent.putExtra("lvl_gameMail",lvl_game);
            }
        });

    }
    public void BTN_goStartGame(View view){
        startActivity(intent);
    }














}