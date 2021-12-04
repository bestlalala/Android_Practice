package com.example.part5_1_4_targethw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyTarget view = new MyTarget(this);
        setContentView(view);
    }

}