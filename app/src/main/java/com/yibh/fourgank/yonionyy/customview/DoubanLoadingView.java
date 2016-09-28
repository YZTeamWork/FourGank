package com.yibh.fourgank.yonionyy.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by yibh on 2016/9/18 17:06 .
 * 学习地址: https://github.com/Idtk/Blog/blob/master/Blog/2%E3%80%81CanvasAndValueAnimator.md
 */

public class DoubanLoadingView extends View {

    private float mWidth;
    private float mHeight;
    private ValueAnimator mValueAnimator;
    private float mAniValue;
    private Paint mPaint;
    private float mR;
    private float mPoint;
    private RectF mRectF;

    public DoubanLoadingView(Context context) {
        this(context, null);
    }

    public DoubanLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DoubanLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);  //抗锯齿
        mPaint.setStyle(Paint.Style.STROKE);    //描边
        mPaint.setStrokeCap(Paint.Cap.ROUND);//圆角笔触
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
        initView(canvas);
//        rotateingArc(canvas);
        onAnimation(canvas);

    }

    /**
     * 没有动画时的样子
     *
     * @param canvas
     */
    private void initView(Canvas canvas) {

        canvas.translate(mWidth / 2, mHeight / 2);   //移动中心点
        mR = Math.min(mWidth, mHeight) / 2 * 0.7f;
        mPoint = mR / (float) Math.sqrt(2); //计算眼睛点所在的位置
//        canvas.drawPoints(new float[]{-point, -point, point, -point}, mPaint);    //两个点(眼睛)
        mRectF = new RectF(-mR, -mR, mR, mR);
//        canvas.drawArc(rectF, 0, 180, false, mPaint);
    }

    /**
     * author: yibh
     * Date: 2016/9/19  15:39 .
     * 旋转过程中270'的圆弧
     */
    private void rotateingArc(Canvas canvas) {
        RectF rectF = new RectF(-mR, -mR, mR, mR);
        canvas.drawArc(rectF, 0, 270, false, mPaint);
    }


    /**
     * 执行动画操作
     *
     * @param duration
     */
    public void startAnimator(long duration) {
        if (null != mValueAnimator) {
            if (mValueAnimator.isRunning()) {
                mValueAnimator.cancel();
            }
            mValueAnimator.start();
        } else {
            mValueAnimator = ValueAnimator.ofFloat(0, 855).setDuration(duration);
            mValueAnimator.setInterpolator(new DecelerateInterpolator());
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mAniValue = (float) animation.getAnimatedValue();
                    Log.w("mAniValue ", mAniValue + "");
                    invalidate();
                }
            });
            mValueAnimator.start();
        }
    }

    /**
     * author: yibh
     * Date: 2016/9/19  15:13 .
     * 具体执行过程
     */
    private void onAnimation(Canvas canvas) {
        float startAngle = 0;
        float sweepAngle = 0;
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, mPaint);
        canvas.drawPoints(new float[]{-mPoint, -mPoint, mPoint, -mPoint}, mPaint);


    }

}
