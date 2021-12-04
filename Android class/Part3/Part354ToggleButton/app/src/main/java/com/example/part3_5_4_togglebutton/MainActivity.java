package com.example.part3_5_4_togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    // res에 정의한 GUI component에 대한 객체 생성에 필요한 변수 선언
    ToggleButton tgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 객체 생성 및 Event를 위한 Listener 설정 및 Event 처리 구현
        tgBtn = findViewById(R.id.toggleButton1);

        tgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (tgBtn.isChecked()){
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}