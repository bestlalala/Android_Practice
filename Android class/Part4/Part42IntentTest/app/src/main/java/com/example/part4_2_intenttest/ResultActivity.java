package com.example.part4_2_intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView results;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        results = (TextView) findViewById(R.id.textView2);
        ok=(Button) findViewById(R.id.button2);

        Bundle extras=getIntent().getExtras();
        results.setText("ID = "+extras.getString("id")+
                "\nPassword =" +extras.getString("pw")+"\n");

        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent confirm = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(confirm);
            }
        });
    }
}