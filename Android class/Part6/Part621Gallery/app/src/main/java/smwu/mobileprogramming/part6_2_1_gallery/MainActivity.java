package smwu.mobileprogramming.part6_2_1_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static ImageView ivPoster;
    Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Gallery 영화 포스터");

        gallery = (Gallery) findViewById(R.id.galleryView);
        ivPoster = (ImageView) findViewById(R.id.imageView);

        MyGalleryView galAdapter = new MyGalleryView(this);
        gallery.setAdapter(galAdapter);
    }
}