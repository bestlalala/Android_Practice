package com.example.part5_2_2_photobook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Photo Book");
    }

    public void displayPicture(View view){
        int id = view.getId();

        LinearLayout layout = view.findViewById(id);
        String tag = (String) layout.getTag();

        Intent intent = new Intent(this, PhotoActivity.class);
        intent.putExtra("click_tag", tag);
        startActivity(intent);
    }
}