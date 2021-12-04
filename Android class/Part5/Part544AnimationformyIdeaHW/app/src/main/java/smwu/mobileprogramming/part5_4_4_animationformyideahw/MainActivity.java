package smwu.mobileprogramming.part5_4_4_animationformyideahw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcome, welcomeText;
    ImageView logoImage;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = findViewById(R.id.welcome);
        welcomeText = findViewById(R.id.welcomeText);
        logoImage = findViewById(R.id.logo);
        startButton = findViewById(R.id.startBtn);
        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.welcome);
        Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo);
        Animation anim3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.welcometext);

        welcome.startAnimation(anim1);
        logoImage.startAnimation(anim2);
        welcomeText.startAnimation(anim3);

    }
}