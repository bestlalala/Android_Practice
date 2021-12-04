package com.example.part5_2_2_photobook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);

        setTitle("Toystory character picture");
        TextView tv_title = (TextView) findViewById(R.id.title);
        TextView tv_artist = (TextView) findViewById(R.id.artist);
        ImageView iv_picture = findViewById(R.id.picture);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("click_tag");

        Resources res = getResources();
        int id_title = res.getIdentifier("title"+tag, "string", getPackageName());
        String title = res.getString(id_title);
        tv_title.setText(title);

        int id_author = res.getIdentifier("artist"+tag, "string", getPackageName());
        String author = res.getString(id_author);
        tv_artist.setText(author);

        int id_picture = res.getIdentifier("picture"+tag, "string", getPackageName());
        String picture = res.getString(id_picture);
        int id_img = res.getIdentifier(picture, "drawable", getPackageName());
        // Drawable drawable = res.getDrawable(id_img);
        Drawable drawable = getResources().getDrawable(id_img, null);
        iv_picture.setBackground(drawable);
    }
}