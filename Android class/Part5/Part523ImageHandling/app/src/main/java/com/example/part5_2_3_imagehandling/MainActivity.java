package com.example.part5_2_3_imagehandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton ibZoomIn, ibZoomOut, ibRotate, ibBright, ibDark, ibGray;
    MyGraphicView graphicView;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static float satur = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Image Handling");

        LinearLayout pictureLayout  = findViewById(R.id.imageLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private void clickIcons(){
        ibZoomIn = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });

        ibZoomOut = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomOut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                color = color + 0.2f;
                graphicView.invalidate();
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                angle = angle + 20;
                graphicView.invalidate();
            }
        });

        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                color = color - 0.2f;
                graphicView.invalidate();
            }
        });

        ibGray = (ImageButton) findViewById(R.id.ibGray);
        ibGray.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if (satur == 0)
                    satur = 1;
                else
                    satur = 0;
                graphicView.invalidate(); // 화면 재생성
            }
        });
    }
}