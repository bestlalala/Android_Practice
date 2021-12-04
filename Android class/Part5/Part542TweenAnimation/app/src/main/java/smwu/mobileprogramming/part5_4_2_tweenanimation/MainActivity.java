package smwu.mobileprogramming.part5_4_2_tweenanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button fadeButton, growButton, moveButton, spinButton, allButton;
    ImageView reusableImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fadeButton = findViewById(R.id.buttonAlpha);
        growButton = findViewById(R.id.buttonScale);
        moveButton = findViewById(R.id.buttonTranslate);
        spinButton = findViewById(R.id.buttonRotate);
        allButton = findViewById(R.id.buttonAll);

        fadeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                performAnimation(R.anim.fade);
            }
        });

        growButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAnimation(R.anim.grow);
            }
        });

        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAnimation(R.anim.move);
            }
        });

        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAnimation(R.anim.spin);
            }
        });

        allButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAnimation(R.anim.all);
            }
        });
    }
    private void performAnimation(int animationResID){
        reusableImageView = findViewById(R.id.imageViewForTweening);
        reusableImageView.setImageResource(R.drawable.wallpaper);
        reusableImageView.setVisibility(View.VISIBLE);

        Animation animation = AnimationUtils.loadAnimation(this, animationResID);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                reusableImageView = findViewById(R.id.imageViewForTweening);
                reusableImageView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        reusableImageView.startAnimation(animation);
    }
}