package com.liupeng.lp.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;


/**
 * 创建者：liupeng
 * 类描述：
 * 创建时间：on 2017/10/31
 * 修改人：***
 * 修改时间：on 2017/10/31
 * 修改备注：
 */

public class CustomAttributeView extends View {
    private String myName;
    private int myAge;
    private String myBg;
    private Bitmap bgBitmap;

    public CustomAttributeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取属性的三种方式
        //1.用命名空间获取
//        myName = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","my_name");
//        myAge = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","my_age");
//        myBg = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","my_bg");
//        System.out.println("myName="+myName+"myAge="+myAge+"myBg="+myBg);
        //  2.遍历属性集合
//        for(int i=0;i<attrs.getAttributeCount();i++){
//            System.out.println(attrs.getAttributeName(i)+"=="+attrs.getAttributeValue(i));
//        }
        //3.使用系统工具
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomAttributeView);
        final int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.CustomAttributeView_my_name:
                    myName = typedArray.getString(attr);
                    break;
                case R.styleable.CustomAttributeView_my_age:
                    myAge = typedArray.getInt(attr, 0);
                    break;
                case R.styleable.CustomAttributeView_my_bg:
                    Drawable drawable = typedArray.getDrawable(attr);
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                    bgBitmap = bitmapDrawable.getBitmap();
                    break;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawText(myName+"===="+myAge,50,50,paint);
        canvas.drawBitmap(bgBitmap,50,50,paint);

    }
}
