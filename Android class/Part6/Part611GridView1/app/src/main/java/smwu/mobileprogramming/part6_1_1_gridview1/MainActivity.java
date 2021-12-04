package smwu.mobileprogramming.part6_1_1_gridview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("영화 안내");

        gridView = findViewById(R.id.gridView01);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gridView.setAdapter(gAdapter);
    }
}