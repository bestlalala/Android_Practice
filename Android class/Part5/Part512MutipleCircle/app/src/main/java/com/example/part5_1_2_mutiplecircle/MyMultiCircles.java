package com.example.part5_1_2_mutiplecircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

public class MyMultiCircles extends View {
    public MyMultiCircles(Context context) {
        super(context);
    }
    public MyMultiCircles(Context context, AttributeSet attrs){
        super(context, attrs);
    }
    public MyMultiCircles(Context context, AttributeSet attrs, int style){
        super(context, attrs, style);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // circle 1
        LinearGradient linearGradient = new LinearGradient(1, 1, 25, 25, Color.RED, Color.GREEN, Shader.TileMode.MIRROR);
        circlePaint.setShader(linearGradient);
        canvas.drawCircle(300, 300, 300, circlePaint);

        // circle 2
        RadialGradient radialGradient = new RadialGradient(750, 475, 150, Color.GREEN, Color.BLACK, Shader.TileMode.MIRROR);
        circlePaint.setShader(radialGradient);
        canvas.drawCircle(750, 475, 150, circlePaint);

        // circle 3
        SweepGradient sweepGradient = new SweepGradient(getWidth() -475, getHeight()-475,
                new int[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA}, null);
        circlePaint.setShader(sweepGradient);
        canvas.drawCircle(getWidth()-475, getHeight()-475, 300, circlePaint);
    }
}
