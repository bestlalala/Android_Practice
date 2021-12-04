package com.example.part3_5_3_checkradioevent;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout   linearLayout;
    TextView       objTV;
    RadioButton    rbSet, rbReset;
    CheckBox       colorRed, colorYellow, colorBlue;

    int bkColor = 0xff000000;   // 배경색 저장
    String strData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTV = (TextView) findViewById(R.id.textView3);
        linearLayout = (LinearLayout) findViewById(R.id.mainLayout);

        // radio button 객체 생성 및 Event Listener 등록
        rbSet = (RadioButton) findViewById(R.id.radioButton1);
        rbReset = (RadioButton) findViewById(R.id.radioButton2);
        rbSet.setOnClickListener(rdbListener);
        rbReset.setOnClickListener(rdbListener);

        // checkbox button 객체 생성 및 Event Listener 등록
        colorRed = (CheckBox) findViewById(R.id.checkBox1);
        colorYellow = (CheckBox) findViewById(R.id.checkBox2);
        colorBlue = (CheckBox) findViewById(R.id.checkBox3);
        colorRed.setOnClickListener(setColorListener);
        colorYellow.setOnClickListener(setColorListener);
        colorBlue.setOnClickListener(setColorListener);

    }

    // Radio Button Event 구현
    View.OnClickListener rdbListener = new View.OnClickListener() {
        @Override
        public void onClick(View view){
            if (rbSet.isChecked()){
                strData = "Color Setting Mode : " + rbSet.getText().toString();
            } else {
                strData = "Color Setting Mode : " + rbReset.getText().toString();
                colorRed.setChecked(false);
                colorYellow.setChecked(false);
                colorBlue.setChecked(false);
                objTV.setBackgroundColor(0xffffffff);
                objTV.setTextColor(0xff000000);
                linearLayout.setBackgroundColor(0xffffffff);
            }
            objTV.setText(strData);
        }
    };

    // CheckBox Event 구현
    View.OnClickListener setColorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view){
            CheckBox chColor = (CheckBox) view;
            if (rbSet.isChecked()){
                strData = "Color Setting Mode : " + rbReset.getText().toString();
                if (colorRed.isChecked()) bkColor |= 0xFFFF0000;
                if (colorYellow.isChecked()) bkColor |= 0xFF00FF00;
                if (colorBlue.isChecked()) bkColor |= 0xFF0000FF;
                objTV.setTextColor(0xFF000000);
                linearLayout.setBackgroundColor(bkColor);
                objTV.setBackgroundColor(bkColor);
                bkColor = 0xFF000000;
            } else {
                objTV.setTextColor(0xFF000000);
                objTV.setText("Color Setting Mode를 Set으로 지정하세요.");
                chColor.setChecked(false);
            }
        }
    };
}