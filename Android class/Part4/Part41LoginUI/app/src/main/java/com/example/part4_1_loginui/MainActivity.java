package com.example.part4_1_loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit_id, edit_pw;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_id=(EditText) findViewById(R.id.editText1);
        edit_pw=(EditText) findViewById(R.id.editText2);
        edit_id.setBackgroundColor(Color.rgb(100, 100, 100));

        btn=(Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String idText, pwText;

                idText=edit_id.getText().toString();
                pwText=edit_pw.getText().toString();

                Intent lintent = new Intent(MainActivity.this, LoginActivity.class);

                Bundle extras = new Bundle();
                extras.putString("id", idText);
                extras.putString("pw", pwText);

                lintent.putExtras(extras);

                startActivity(lintent);
            }
        });
    }
}