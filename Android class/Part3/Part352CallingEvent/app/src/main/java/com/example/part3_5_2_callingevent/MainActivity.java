package com.example.part3_5_2_callingevent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText objET;
    Button btnCall, btnStop;
    String mNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objET = findViewById(R.id.editText1);
        btnCall = findViewById(R.id.button1);
        btnStop = findViewById(R.id.button2);

        String[] permissions = {
                Manifest.permission.CALL_PHONE
        };

        btnCall.setOnClickListener(view -> {
            checkPermissions(permissions);
            callAction();

//                objET.setText("Calling...");
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(callnum())));
//                objET.setText("통화가 종료되었습니다.");
            }
        });

    }

    public void checkPermissions(String[] permissions){
        ArrayList<String> targetList = new ArrayList<String>();

        for (String curPermission : permissions) {
            int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, curPermission + " 권한 있음.", Toast.LENGTH_LONG).show();

                callAction();

            } else {
                Toast.makeText(this, curPermission + " 권한 없음.", Toast.LENGTH_LONG).show();
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, curPermission)) {
                    Toast.makeText(this, curPermission + " 권한 설명 필요함.", Toast.LENGTH_LONG).show();
                } else {
                    targetList.add(curPermission);
                }
            }
        }

        String[] targets = new String[targetList.size()];
        targetList.toArray(targets);

        ActivityCompat.requestPermissions(this, targets, 1000);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            // 요청한 권한을 사용자가 허용했다면
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    callAction();
                }
            } else {
                Toast.makeText(MainActivity.this, "권한 요청을 거부했습니다.", Toast.LENGTH_SHORT).show();
            }
            return;
        }
    }

    public String callnum() {
        mNum = objET.getText().toString();
        String tel = "tel:" + mNum;
        return tel;
    }

    public void callAction(){
        String tel = callnum();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(tel)));
    }

}