package smwu.mobileprogramming.part5_3_2chargraphdrawhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class YearProgressActivity extends AppCompatActivity {

    TextView title, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_progress);

        title=findViewById(R.id.yearlyProgress);
        year=findViewById(R.id.year);

        
    }
}