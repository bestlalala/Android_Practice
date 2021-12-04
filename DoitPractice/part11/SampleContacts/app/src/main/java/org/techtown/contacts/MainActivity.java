package org.techtown.contacts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseContacts();
            }
        });
        checkDangerousPermissions();
    }

    public void chooseContacts(){
        Intent contatctPickerIntent = new Intent(Intent.ACTION_PICK,
                ContactsContract.Contacts.CONTENT_URI); // 1. 연락처 화면을 띄우기 위한 인텐트 만들기
        startActivityForResult(contatctPickerIntent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == 101){
                try {
                    Uri contactsUri = data.getData();
                    String id = contactsUri.getLastPathSegment(); // 2. 선택한 연락처의 id 값 확인하기

                    getContacts(id);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
    public void getContacts(String id){
        Cursor cursor = null;
        String name = "";

        try {
            cursor = getContentResolver().query(ContactsContract.Data.CONTENT_URI,
                    null,
                    ContactsContract.Data.CONTACT_ID + "=?",
                    new String[] { id },
                    null);

            if (cursor.moveToFirst()) {
                name = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                println("Name: " + name);

                String columns[] = cursor.getColumnNames();
                for (String column : columns) {
                    int index = cursor.getColumnIndex(column);
                    String columnOutput = ("#" + index + " -> [" + column + "] " + cursor.getString(index));
                    println(columnOutput);
                }
                cursor.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void println(String data){
        textView.append(data + "\n");
    }

    private void checkDangerousPermissions(){
        String[] permissions={
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        permissionCheck = ContextCompat.checkSelfPermission(this, permissions[0]);
        if (permissionCheck != PackageManager.PERMISSION_DENIED) {
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