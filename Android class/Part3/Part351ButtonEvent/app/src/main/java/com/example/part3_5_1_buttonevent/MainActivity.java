package com.example.part3_5_1_buttonevent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView        tv;
    LinearLayout    objMainLL, objSubLL;
    Button          btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        objSubLL = (LinearLayout) findViewById(R.id.subLayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 각자가 구현: RGB 값을 Random class를 활용하여 설정
                int random1 = new Random().nextInt(256);
                int random2 = new Random().nextInt(256);
                int random3 = new Random().nextInt(256);

                // Color 지정
                int color = Color.rgb(random1, random2, random3);
                // Sub LinearLayout의 배경색 변경
                objSubLL.setBackgroundColor(color);
                tv.setText("RGB(" + random1 + ", " + random2 + ", " + random3 + ")");
            }
        });
    }
}