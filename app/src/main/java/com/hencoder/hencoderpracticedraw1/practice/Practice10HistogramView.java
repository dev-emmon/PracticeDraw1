package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        Paint paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        canvas.drawLine(100, 30, 100, 500, paint1);
        canvas.drawLine(100, 500, 1000, 500, paint1);

        int start = 100;
        int xspace = 40;
        int width = 100;
        Paint paint2 = new Paint();
        paint2.setColor(Color.GREEN);
        canvas.drawRect(start + xspace, 400, start + xspace + width, 498, paint2);
        canvas.drawRect(start + xspace * 2 + width * 1, 450, start + (xspace + width) * 2, 498, paint2);
        canvas.drawRect(start + xspace * 3 + width * 2, 100, start + (xspace + width) * 3, 498, paint2);
        canvas.drawRect(start + xspace * 4 + width * 3, 200, start + (xspace + width) * 4, 498, paint2);
        canvas.drawRect(start + xspace * 5 + width * 4, 250, start + (xspace + width) * 5, 498, paint2);
        canvas.drawRect(start + xspace * 6 + width * 5, 150, start + (xspace + width) * 6, 498, paint2);

        Paint paint3 = new Paint();
        paint3.setTextSize(24);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setColor(Color.WHITE);
        canvas.drawText("Froyo", start + xspace + width / 2, 520, paint3);
        canvas.drawText("GB", start + xspace * 2 + width * 1 + width / 2, 520, paint3);
        canvas.drawText("ICS", start + xspace * 3 + width * 2 + width / 2, 520, paint3);
        canvas.drawText("JB", start + xspace * 4 + width * 3 + width / 2, 520, paint3);
        canvas.drawText("Kitkat", start + xspace * 5 + width * 4 + width / 2, 520, paint3);
        canvas.drawText("L", start + xspace * 6 + width * 5 + width / 2, 520, paint3);

    }
}
