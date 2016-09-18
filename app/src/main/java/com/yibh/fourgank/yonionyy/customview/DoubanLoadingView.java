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

    public DoubanLoadingView(Context context) {
        this(context, null);
    }

    public DoubanLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DoubanLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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

    }

    /**
     * 没有动画时的样子
     *
     * @param canvas
     */
    private void initView(Canvas canvas) {
        Paint mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);  //抗锯齿
        mPaint.setStyle(Paint.Style.STROKE);    //描边

        canvas.translate(mWidth / 2, mHeight / 2);   //移动中心点
        float r = Math.min(mWidth, mHeight) / 2 * 0.7f;
        float point = r / (float) Math.sqrt(2);
        canvas.drawPoints(new float[]{-point, -point, point, -point}, mPaint);    //两个点(眼睛)
        RectF rectF = new RectF(-r, -r, r, r);
        canvas.drawArc(rectF, 0, 180, false, mPaint);
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
            mValueAnimator = ValueAnimator.ofFloat(0, 720).setDuration(duration);
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
     * 具体执行过程
     */
    private void onAnimation(){

    }

}
