package com.example.docking_milkyway;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class Matching extends AppCompatActivity {
    boolean matchSuccess = false;
    boolean matchAccept = false;
    Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matching);
        intent = new Intent(this.getIntent());

        View animView1 = (View) findViewById(R.id.animView1);
        View animView2 = (View) findViewById(R.id.animView2);
        View animView3 = (View) findViewById(R.id.animView3);

        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotatealpha);
        Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotatealpha);
        anim2.setStartTime(-1000);
        anim2.setDuration(6000);
        Animation anim3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotatealpha);
        anim3.setStartTime(-2000);
        anim3.setDuration(4000);

        animView1.setAnimation(anim1);
        animView2.setAnimation(anim2);
        animView3.setAnimation(anim3);

        Toast.makeText(getApplicationContext(), "산책메이트 매칭을 시작합니다.", Toast.LENGTH_SHORT).show();

        while(!matchAccept){
            match();
        }

    }

    void match(){
        // find and match appropriate user

        /*
         * matching
         * code
         * space
         */


        // Successfully matched
        Toast.makeText(getApplicationContext(), "매칭 성공", Toast.LENGTH_SHORT).show();
        Log.d("상아","매칭성공");
        matchSuccess = true;
        matchAccept = true;

        if (matchAccept){
            // 테스트를 위해 8초 대기화면으로 설정했습니다만 이후 매칭과정을 추가하겠습니다.
            Handler hd = new Handler();
            hd.postDelayed(new Runnable() {
                public void run() {
                    Toast.makeText(getApplicationContext(), "산책을 시작합니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }, 15000);
        }


    }



}
