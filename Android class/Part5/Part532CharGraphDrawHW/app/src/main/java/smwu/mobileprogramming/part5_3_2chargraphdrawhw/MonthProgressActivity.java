package smwu.mobileprogramming.part5_3_2chargraphdrawhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MonthProgressActivity extends AppCompatActivity {

    TextView title, month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_progress);

        title = findViewById(R.id.monthlyProgress);
        month = findViewById(R.id.month);
    }
}