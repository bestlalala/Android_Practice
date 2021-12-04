package com.example.part5_2_1_mybitmaphw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

public class MyBitMap extends View {
    public MyBitMap(Context context){
        super(context);
    }

    public MyBitMap(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyBitMap(Context context, AttributeSet attrs, int defaultStyle){
        super(context, attrs, defaultStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);

        Bitmap myPicture = BitmapFactory.decodeResource(getResources(), R.drawable.jessy);
        Bitmap Rex = BitmapFactory.decodeResource(getResources(), R.drawable.rex2);

        Bitmap RexMedium = Bitmap.createScaledBitmap(Rex, 150, 240, false);
        canvas.drawBitmap(RexMedium, 300, 600, null);

        Matrix Rex2 = new Matrix();
        Rex2.setScale(-1, 1);
        Bitmap myRex = Bitmap.createBitmap(RexMedium, 0, 0, RexMedium.getWidth(), RexMedium.getHeight(), Rex2, false);
        canvas.drawBitmap(myRex, 750, 600, null);


        Bitmap myPicMedium = Bitmap.createScaledBitmap(myPicture, 200, 300, false);
        canvas.drawBitmap(myPicMedium, 500, 600, null);

        // Create the thumbnail
        Bitmap myPicSmall = Bitmap.createScaledBitmap(myPicture, 50, 75, false);

        Matrix maxTopLeft = new Matrix();
        maxTopLeft.preRotate(30);

        Matrix maxBottomLeft = new Matrix();
        maxBottomLeft.preRotate(-30);

        Matrix maxTopRight = new Matrix();
        maxTopRight.preRotate(-30);
        maxTopRight.preScale(-1, 1);

        Matrix maxBottomRight = new Matrix();
        maxBottomRight.preRotate(30);
        maxBottomRight.preScale(-1, 1);

        Bitmap myPicTopLeft = Bitmap.createBitmap(myPicSmall, 0, 0, myPicSmall.getWidth(), myPicSmall.getHeight(), maxTopLeft, false);
        Bitmap myPicBottomLeft = Bitmap.createBitmap(myPicSmall, 0, 0, myPicSmall.getWidth(), myPicSmall.getHeight(), maxBottomLeft, false);

        Bitmap myPicTopRight = Bitmap.createBitmap(myPicSmall, 0, 0, myPicSmall.getWidth(), myPicSmall.getHeight(), maxTopRight, false);
        Bitmap myPicBottomRight = Bitmap.createBitmap(myPicSmall, 0, 0, myPicSmall.getWidth(), myPicSmall.getHeight(), maxBottomRight, false);

        // Free up some memory by dumping bitmaps we don't need anymore
        myPicSmall.recycle();
        myPicture.recycle();
        Rex.recycle();
        RexMedium.recycle();

        canvas.drawBitmap(myPicTopLeft, 430, 550, null);
        canvas.drawBitmap(myPicBottomLeft, 430, 860, null);
        canvas.drawBitmap(myPicTopRight, 690, 550, null);
        canvas.drawBitmap(myPicBottomRight, 690, 860, null);
    }
}
