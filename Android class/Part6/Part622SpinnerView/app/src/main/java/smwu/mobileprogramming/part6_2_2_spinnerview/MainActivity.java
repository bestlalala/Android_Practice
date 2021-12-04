package smwu.mobileprogramming.part6_2_2_spinnerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Spinner 실습");

        final Integer[] posterId = {R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4, R.drawable.mov5};
        String[] movie_names = getResources().getStringArray(R.array.movie_titles);

        spinner = (Spinner) findViewById(R.id.spinner1);
        imageView = (ImageView) findViewById(R.id.posterImageView);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, movie_names);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5, 5, 5, 5);
                imageView.setImageResource(posterId[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}