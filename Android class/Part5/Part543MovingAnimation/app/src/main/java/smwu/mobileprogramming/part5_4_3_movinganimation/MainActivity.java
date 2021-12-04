package smwu.mobileprogramming.part5_4_3_movinganimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_cloud, iv_bird, iv_mountain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cloud = (ImageView) findViewById(R.id.cloud);
        iv_bird =  (ImageView) findViewById(R.id.bird);
        iv_mountain = (ImageView) findViewById(R.id.mountain);

        Animation animation_cloud = AnimationUtils.loadAnimation(this, R.anim.cloud);
        Animation animation_mountain = AnimationUtils.loadAnimation(this, R.anim.mountain);
        Animation animation_bird = AnimationUtils.loadAnimation(this, R.anim.bird);

        iv_cloud.startAnimation(animation_cloud);
        iv_mountain.startAnimation(animation_mountain);
        iv_bird.startAnimation(animation_bird);

        AnimationDrawable animationDrawable = new AnimationDrawable();
        BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.bird1, null);
        BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.bird2, null);
        BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.bird3, null);
        animationDrawable.addFrame(frame1, 200);
        animationDrawable.addFrame(frame2, 200);
        animationDrawable.addFrame(frame3, 200);

        iv_bird.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();
    }
}