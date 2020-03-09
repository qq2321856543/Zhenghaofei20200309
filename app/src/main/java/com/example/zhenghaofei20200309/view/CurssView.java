package com.example.zhenghaofei20200309.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhenghaofei20200309.R;

import java.util.ArrayList;
/**
 * Zhenghaofei20200309
 * 折线图
 * 2020-03-09
 */
public class CurssView extends View {
    ArrayList<Integer> list = new ArrayList<>();
    private Paint paint;
    int color =Color.RED;
    public CurssView(Context context) {
        super(context);
        init();
    }

    public CurssView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CurssView);
        color = typedArray.getColor(R.styleable.CurssView_color, Color.RED);
        init();
    }
    public void init(){
        paint = new Paint();
        paint.setColor(color);
        list.add(64);
        list.add(32);
        list.add(41);
        list.add(53);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //两条直线
        canvas.drawLine(100,600,600,600,paint);
        canvas.drawLine(100,600,100,200,paint);
        int starX=0;
        int starY=600;
        int a=1000;

        //设置值
        for (int i=1;i<=11;i++){
            canvas.drawText(""+i,starX+100,620,paint);
            starX+=50;
        }
        for (int i=1;i<=7;i++){
            canvas.drawText(""+a,70,starY-60,paint);
            starX+=50;
            starY-=60;
            a+=1000;
        }

        //折线
        int X=100;
        int Y=600;
        for (int i=0;i<list.size();i++){
            canvas.drawLine(X,Y,X+50,600-list.get(i),paint);
            X+=50;
            Y=600-list.get(i);
        }

    }
}
