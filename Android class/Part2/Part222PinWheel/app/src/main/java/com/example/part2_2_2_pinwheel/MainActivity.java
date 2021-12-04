package com.example.part2_2_2_pinwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ImageView 객체 생성: resource 저장한 image에 대한 객체 생성
        ImageView iv_pinwheel = (ImageView) findViewById(R.id.pinView);

        // image rotation : Animator class using
        ObjectAnimator object = ObjectAnimator.ofFloat(iv_pinwheel, "rotation", 360);
        object.setInterpolator(new LinearInterpolator());   //일정한 속도로 회전
        object.setDuration(2000);   //animation interval time 2 sec
        object.setRepeatCount(ValueAnimator.INFINITE); //loop
        object.start(); //animation start
    }
}