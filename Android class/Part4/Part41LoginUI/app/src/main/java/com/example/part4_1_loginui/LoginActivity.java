package com.example.part4_1_loginui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    TextView results;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_result);

        results = (TextView) findViewById(R.id.textView2);
        ok=(Button) findViewById(R.id.button2);

        Bundle extras=getIntent().getExtras();
        results.setText("ID = "+extras.getString("id")+
                "\nPassword =" +extras.getString("pw")+"\n");

        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent confirm = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(confirm);
            }
        });
    }
}