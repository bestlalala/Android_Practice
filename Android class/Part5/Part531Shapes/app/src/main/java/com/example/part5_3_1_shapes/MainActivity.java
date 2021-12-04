package com.example.part5_3_1_shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Line Button
        Button lineButton = findViewById(R.id.ButtonLine);
        lineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ShapeDrawable d = new ShapeDrawable(new RectShape());
                d.setIntrinsicWidth(250);
                d.setIntrinsicHeight(5);
                d.getPaint().setColor(Color.BLUE);
                setShapeByDrawable(d);
            }
        });

        // Handle Rectangle Button
        final Button rectButton = findViewById(R.id.ButtonRect);
        rectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setShapeByResourceId(R.drawable.green_rect);
            }
        });

        // Handle Oval Button
        final Button ovalButton = findViewById(R.id.ButtonOval);
        ovalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setShapeByResourceId(R.drawable.red_oval);
                // Or Draw an oval programatically

                ShapeDrawable d= new ShapeDrawable(new OvalShape());
                d.setIntrinsicHeight(400);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.GREEN);
                setShapeByDrawable(d);

            }
        });

        final Button roundRectButton = findViewById(R.id.ButtonRoundrect);
        roundRectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShapeDrawable d = new ShapeDrawable(new RoundRectShape(
                        new float[]{10, 10, 5, 5, 5, 5, 15, 15}, null, null
                ));
                d.setIntrinsicHeight(50);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.CYAN);
                setShapeByDrawable(d);
            }
        });

        // Handle Path Button
        final Button pathButton = findViewById(R.id.ButtonPath);
        pathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Path p = new Path();
                p.moveTo(50, 0);
                p.lineTo(25, 100);
                p.lineTo(100, 50);
                p.lineTo(0, 50);
                p.lineTo(75, 100);
                p.lineTo(50, 0);

                ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.YELLOW);
                setShapeByDrawable(d);
            }
        });

        // Handle Path Button
        final Button path2Button = findViewById(R.id.ButtonPath2);
        path2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Path p = new Path();
                p.setFillType(Path.FillType.EVEN_ODD);
                p.moveTo(50, 0);
                p.lineTo(25, 100);
                p.lineTo(100, 50);
                p.lineTo(0, 50);
                p.lineTo(75, 100);
                p.lineTo(50, 0);

                ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.YELLOW);
                setShapeByDrawable(d);
            }
        });

        // Handle Path Button
        final Button path3Button = findViewById(R.id.ButtonPath3);
        path3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Path p = new Path();
                p.moveTo(50, 0);
                p.lineTo(25, 100);
                p.lineTo(100, 50);
                p.lineTo(0, 50);
                p.lineTo(75, 100);
                p.lineTo(50, 0);

                ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.YELLOW);
                d.getPaint().setStyle(Paint.Style.STROKE);
                setShapeByDrawable(d);
            }
        });

        // Handle Arc Button
        final Button arcButton = findViewById(R.id.ButtonArc);
        arcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShapeDrawable d = new ShapeDrawable(new ArcShape(0, 345));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.MAGENTA);
                setShapeByDrawable(d);
            }
        });
    }

    private void setShapeByDrawable(Drawable drawable){
        ImageView reusableIV = findViewById(R.id.imageViewForShape);
        reusableIV.setImageDrawable(drawable);
    }

    private void setShapeByResourceId(int resourceId){
        ImageView reusableIV = findViewById(R.id.imageViewForShape);
        reusableIV.setImageResource(resourceId);
    }
}