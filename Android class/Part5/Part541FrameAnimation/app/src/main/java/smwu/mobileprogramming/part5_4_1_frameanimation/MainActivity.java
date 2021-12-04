package smwu.mobileprogramming.part5_4_1_frameanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    Button startButton, stopButton;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.button1);
        stopButton = findViewById(R.id.button2);

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimation();
            }
        });
    }

    private void startAnimation(){
        img = findViewById(R.id.imageView);

        BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.wall1, null);
        BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.wall2, null);
        BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.wall3, null);
        BitmapDrawable frame4 = (BitmapDrawable) getResources().getDrawable(R.drawable.wall4, null);

        int reasonableDuration = 2000;
        animationDrawable = new AnimationDrawable();

        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(frame1, reasonableDuration);
        animationDrawable.addFrame(frame2, reasonableDuration);
        animationDrawable.addFrame(frame3, reasonableDuration);
        animationDrawable.addFrame(frame4, reasonableDuration);

        img.setImageDrawable(animationDrawable);
        animationDrawable.setVisible(true, true);
        animationDrawable.start();
    }

    private void stopAnimation(){
        animationDrawable.stop();
        animationDrawable.setVisible(false, false);
    }
}