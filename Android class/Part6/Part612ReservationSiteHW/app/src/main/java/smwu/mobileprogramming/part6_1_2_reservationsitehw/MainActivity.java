package smwu.mobileprogramming.part6_1_2_reservationsitehw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("영화 안내");

        gridView = findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gridView.setAdapter(gAdapter);
    }
}