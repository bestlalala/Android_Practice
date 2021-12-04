package com.example.part5_1_1_mypaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyPaint extends View {
    public MyPaint(Context context) {
        super(context);
    }
    public MyPaint(Context context, AttributeSet attrs){
        super(context, attrs);
    }
    public MyPaint(Context context, AttributeSet attrs, int style){
        super(context, attrs, style);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);

        Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(Color.GREEN);
        canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2, circlePaint);
    }
}
