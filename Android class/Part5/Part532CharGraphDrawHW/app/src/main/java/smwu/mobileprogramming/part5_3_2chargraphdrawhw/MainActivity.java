package smwu.mobileprogramming.part5_3_2chargraphdrawhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button yearProgressBtn = findViewById(R.id.yearlyProgress);
        Button monthProgressBtn = findViewById(R.id.monthlyProgress);

        yearProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent progress = new Intent(MainActivity.this, YearProgressActivity.class);
                startActivity(progress);
            }
        });

        monthProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent progress = new Intent(MainActivity.this, MonthProgressActivity.class);
                startActivity(progress);
            }
        });
    }

}