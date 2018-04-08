package cn.xp.jike;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import java.lang.reflect.Array;


public class CountView extends View {
    protected static final String TAG = CountView.class.getSimpleName();

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    int transparentColor = 0xffffff;
    int originColor = 0xff0000;

    boolean plus;
    public int count;
    private int newCount;
    public int action = 0;

    public int changeNum = 0;

    private Point[] points = new Point[3];

    public void setCount(int count) {
        this.count = count;
        Log.d(TAG, "3333333333333333333");
        initData();
        postInvalidate();
    }

    public void setAction(int action) {
        this.action = action;

        postInvalidate();
//        invalidate();
    }


    public void setThumbNumber(float arg) {
        postInvalidate();
    }


    public CountView(Context context) {
        super(context);
    }

    public CountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        initData();
    }

    public CountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(50);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Log.d(TAG, "2222222222222222222");
        if (points.length == 1) {
            Log.d(TAG, "111111111111111111");
            Point point = points[0];
            canvas.drawText(point.conten, point.x, point.y, paint);
        }

//        refreshView(canvas);
    }

    public void refreshView(Canvas canvas) {
        switch (action) {
            case 0:
                canvas.drawText(String.valueOf(count), 0, 120, paint);
                break;

            case 1: {
                newCount = count + 1;
//                action = 1;
                char[] newArray = String.valueOf(newCount).toCharArray();
                char[] oldArray = String.valueOf(count).toCharArray();

//                canvas.drawText(newArray, 0, newArray.length, 0, 120, paint);

                int num = 0;
                if (newArray.length > oldArray.length) {
                    num = newArray.length;
                    canvas.drawText(newArray, 0, num, 0, 120, paint);
                } else {
                    for (int i = 0; i < newArray.length; i++) {
                        if (newArray[i] != oldArray[i]) {
                            num++;
                        }
                    }
                    float startX = paint.measureText(oldArray, 0, oldArray.length - num);
                    Log.d(TAG, "new count============" + newCount + ",length=========" + num);
                    Log.d(TAG, "startX=============" + startX);
                    canvas.drawText(newArray, 0, newArray.length - num, 0, 120, paint);
                    canvas.drawText(newArray, newArray.length - num, num, startX, 120, paint);

                }
//                animate().translationY(-100);
                Log.d(TAG, "after y================" + getY());
                count = newCount;

                break;
            }

            case 2:
                count = newCount;
                break;


        }


    }

    public void playPlusAnimation(boolean thumbUp) {
        plus = thumbUp;

//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(this, "translationY", 0, -50);
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(this, "scaleX", 1f, 0f);
//        ObjectAnimator animator3 = ObjectAnimator.ofFloat(this, "scaleY", 1f, 0f);
//
//
//        ObjectAnimator animator4 = ObjectAnimator.ofFloat(this, "translationY", -50, 25);
//
//        ObjectAnimator animator5 = ObjectAnimator.ofFloat(this, "scaleX", 0f, 1f);
//        ObjectAnimator animator6 = ObjectAnimator.ofFloat(this, "scaleY", 0f, 1f);
//        ObjectAnimator animator7 = ObjectAnimator.ofFloat(this, "translationY", 25, 0);
//
//
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.setInterpolator(new LinearInterpolator());
//        animatorSet.setDuration(100);
//        animatorSet.play(animator1).before(animator2).with(animator3).before(animator4)
//                .before(animator5).with(animator6).before(animator7);
//        animatorSet.start();


        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "thumbNumber", 0f, 0.5f);
        animator.start();


    }


    private void initData() {
        Point point1 = new Point(0, 120);
        point1.conten = String.valueOf(count);
        point1.color = originColor;
        points[0] = point1;
        Point point2 = new Point(, 120);
        point1.conten = String.valueOf(count);
        point1.color = originColor;
        points[0] = point1;
        Point point3 = new Point(0, 120);
        point1.conten = String.valueOf(count);
        point1.color = originColor;
        points[0] = point1;
        Log.d(TAG, "length===============" + points.length);
    }


    private void caculatePoints(boolean plus) {
        newCount = plus ? count + 1 : count - 1;
        char[] newArray = String.valueOf(newCount).toCharArray();
        char[] oldArray = String.valueOf(count).toCharArray();
        int num = 0;
        if (newArray.length != oldArray.length) {
            num = newArray.length;
            Point point2 = new Point();
            Point point3 = new Point();

        } else {
            for (int i = 0; i < newArray.length; i++) {
                if (newArray[i] != oldArray[i]) {
                    num++;
                }
            }
            float startX = paint.measureText(oldArray, 0, oldArray.length - num);


        }


    }


}
