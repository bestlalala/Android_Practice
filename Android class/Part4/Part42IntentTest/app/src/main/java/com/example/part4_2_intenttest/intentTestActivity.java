package com.example.part4_2_intenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class intentTestActivity extends AppCompatActivity {

    ListView actionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);

        actionList = findViewById(R.id.intentList);
        actionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 0:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01056069635"));
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01056069635"));
                        checkDangerousPermissions();
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_SEARCH);
                        intent.putExtra(SearchManager.QUERY, "abc");
                    case 3:
                        intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("tel:01056069635"));
                        intent.putExtra("sms_body", "안녕하세요. 저는 이연수입니다.");
                        break;
                    case 4:
                        intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        intent.putExtra(SearchManager.QUERY, "android");
                        break;
                    case 5:
                        intent = new Intent(Intent.ACTION_PICK, Uri.parse("contact://contacts/people"));
                        break;
                    case 6:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://daum.net"));
                        break;
                    case 7:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:01056069635"));
                        break;
                    case 8:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.501079, 127.061194"));
                        break;
                }
                try{
                    startActivity(intent);
                } catch (ActivityNotFoundException e){
                    Toast.makeText(intentTestActivity.this,
                            "지정한 동작을 실행할 App이 설치되어 있지 않습니다.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void checkDangerousPermissions(){
        String[] permissions={
                Manifest.permission.CALL_PHONE
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i=0; i< permissions.length;i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])){
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults); //2021 added
        if (requestCode == 1){
            for (int i = 0; i < permissions.length; i++){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, permissions[i] + "권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + "권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}