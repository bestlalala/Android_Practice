package com.example.part5_1_4_targethw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyTarget extends View {
    private Paint paint;

    public MyTarget(Context context) {
        super(context);
        init(context);
    }
    public MyTarget(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }
    public MyTarget(Context context, AttributeSet attrs, int style){
        super(context, attrs, style);
    }
    private void init(Context context){
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);
        canvas.drawCircle(300, 500, 100, paint);
        canvas.drawLine(600, 600, 650, 470, paint);
        canvas.drawLine(650, 470, 700, 600, paint);
        canvas.drawLine(600, 600, 700, 600, paint);
        canvas.drawRect(750, 400, 900, 550, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawRect(200, 700, 500, 1000, paint);
        paint.setColor(Color.BLUE);
        canvas.drawRect(700, 700, 1000, 1000, paint);
        paint.setColor(Color.BLACK);
        canvas.drawLine(200, 700, 500, 1000, paint);
        canvas.drawLine(500, 700, 200, 1000, paint);

        canvas.drawLine(700, 700, 1000, 1000, paint);
        canvas.drawLine(1000, 700, 700, 1000, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Toast.makeText(super.getContext(), "MotionEvent.ACTION_DOWN : " +
                    event.getX() + ", " + event.getY(), Toast.LENGTH_LONG).show();
        }
        return super.onTouchEvent(event);
    }
}
