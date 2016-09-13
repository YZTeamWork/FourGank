package com.yibh.fourgank.yonionyy.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yibh on 2016/9/13 16:17 .
 */

public class CoordinateView extends View {

    private float mWidth;
    private float mHeight;
    private Paint mPaint;

    public CoordinateView(Context context) {
        this(context, null);
    }

    public CoordinateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CoordinateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);  //填充
        mPaint.setAntiAlias(true);  //抗锯齿

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);   //将原点移动到中心

        mPaint.setColor(Color.RED); //设置画笔颜色
        mPaint.setStrokeWidth(5);  //设置宽度
        canvas.drawPoint(0, 0, mPaint); //画原点

        //画4个点
        mPaint.setColor(Color.BLUE);
        canvas.drawPoints(new float[]{
                -mWidth / 2 * 0.7f, 0f
                , mWidth / 2 * 0.7f, 0f
                , 0f, -mHeight / 2 * 0.7f
                , 0f, mHeight / 2 * 0.7f
        }, mPaint);

        //画线(x,y轴)
        mPaint.setStrokeWidth(1);
        mPaint.setColor(Color.BLACK);
        canvas.drawLines(new float[]{
                -mWidth / 2 * 0.7f, 0f
                , mWidth / 2 * 0.7f, 0f
                , 0f, -mHeight / 2 * 0.7f
                , 0f, mHeight / 2 * 0.7f
        }, mPaint);

        //画坐标轴箭头
        canvas.drawLines(new float[]{
                //x轴箭头
                mWidth / 2 * 0.7f, 0f, mWidth / 2 * 0.7f * 0.95f, mWidth / 2 * 0.7f * 0.05f,
                mWidth / 2 * 0.7f, 0f, mWidth / 2 * 0.7f * 0.95f, -mWidth / 2 * 0.7f * 0.05f,
                //y轴箭头
                0f, mHeight / 2 * 0.7f, mWidth / 2 * 0.7f * 0.05f, mHeight / 2 * 0.7f * 0.8f,
                0f, mHeight / 2 * 0.7f, -mWidth / 2 * 0.7f * 0.05f, mHeight / 2 * 0.7f * 0.8f
        }, mPaint);

    }
}
