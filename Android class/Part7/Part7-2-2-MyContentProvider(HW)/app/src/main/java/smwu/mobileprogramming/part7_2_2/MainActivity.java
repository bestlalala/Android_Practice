package smwu.mobileprogramming.part7_2_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView profile, textView;
    EditText editName, editPhone, editEmail;
    String name, phone, email;

    int flag;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.profile);
        imageView = findViewById(R.id.imageView);
        textView= findViewById(R.id.textView);

        editName=findViewById(R.id.editTextName);
        editPhone=findViewById(R.id.editTextPhone);
        editEmail=findViewById(R.id.editTextEmailAddress);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                openGallery();
            }
        });

        Button saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=editName.getText().toString();
                phone=editPhone.getText().toString();
                email=editEmail.getText().toString();

                insertCustomer();
            }
        });
        Button updateBtn = findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCustomer();
            }
        });
        Button deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteCustomer();
            }
        });

        Button queryBtn = findViewById(R.id.queryBtn);
        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryCustomer();
            }
        });


        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 2;
                chooseContacts();
            }
        });
        checkDangerousPermissions();
    }

    public void openGallery(){
        Intent intent = new Intent();
        intent.setType(" image/* ");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                    Uri fileUri = data.getData();
                    ContentResolver resolver = getContentResolver(); // 1. ContentResolver 객체 참조하기
                if (flag ==1){
                    try {
                        InputStream instream = resolver.openInputStream(fileUri);   // 2. 파일 읽어 들이기
                        Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
                        imageView.setImageBitmap(imgBitmap);

                        instream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (flag==2) {
                    try {
                        Uri contactsUri = data.getData();
                        String id = contactsUri.getLastPathSegment(); // 2. 선택한 연락처의 id 값 확인하기

                        getContacts(id);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
    public void chooseContacts(){
        Intent contatctPickerIntent = new Intent(Intent.ACTION_PICK,
                ContactsContract.Contacts.CONTENT_URI); // 1. 연락처 화면을 띄우기 위한 인텐트 만들기
        startActivityForResult(contatctPickerIntent, 101);
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

    public void insertCustomer() {

        String uriString = "content://org.smwuMP.provider/customer";
        Uri uri = new Uri.Builder().build().parse(uriString);

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        String[] columns = cursor.getColumnNames();
        println("columns count -> " + columns.length);
        for (int i = 0; i < columns.length; i++) {
            println("#" + i + " : " + columns[i]);
        }

        ContentValues values = new ContentValues();
        values.put("name", name);
                values.put("mobile", phone);
        values.put("email", email);

        uri = getContentResolver().insert(uri, values);
        println("insert 결과 -> " + uri.toString());
        Toast.makeText(getApplicationContext(), "고객 정보를 추가했습니다.", Toast.LENGTH_LONG).show();
    }


    public void queryCustomer() {
        try {
            String uriString = "content://org.smwuMP.provider/customer";
            Uri uri = new Uri.Builder().build().parse(uriString);

            String[] columns = new String[] {"name", "mobile", "email"};
            Cursor cursor = getContentResolver().query(uri, columns, null, null, "name ASC");
            println("query 결과 : " + cursor.getCount());

            int index = 0;
            while(cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(columns[0]));
                String mobile = cursor.getString(cursor.getColumnIndex(columns[1]));
                String email = cursor.getString(cursor.getColumnIndex(columns[2]));

                println("#" + index + " -> " + name + ", " + mobile + ", " + email);
                index += 1;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer() {
        String uriString = "content://org.smwuMP.provider/customer";
        Uri uri = new Uri.Builder().build().parse(uriString);

        String selection = "mobile = ?";
        String[] selectionArgs = new String[] {phone};
        ContentValues updateValue = new ContentValues();
        updateValue.put("mobile", editPhone.getText().toString());

        int count = getContentResolver().update(uri, updateValue, selection, selectionArgs);
        println("update 결과 : " + count);
    }

    public void deleteCustomer() {
        String uriString = "content://org.smwuMP.provider/customer";
        Uri uri = new Uri.Builder().build().parse(uriString);

        String selection = "name = ?";
        String[] selectionArgs = new String[] {name};

        int count = getContentResolver().delete(uri, selection, selectionArgs);
        println("delete 결과 : " + count);
    }

    public void println(String data) { textView.append(data + "\n"); }

    private void checkDangerousPermissions(){
        String[] permissions={
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
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