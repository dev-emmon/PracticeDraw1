package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        int radius = 240;
        drawCake(canvas, 500 - 20, 300 - 20, radius, 180, 300, "Lollipop", Color.GRAY, Color.RED);
        drawCake(canvas, 500, 300, radius, 305, 360, "M", Color.GRAY, Color.YELLOW);
        drawCake(canvas, 500, 300, radius, 2, 10, "F", Color.GRAY, Color.LTGRAY);
        drawCake(canvas, 500, 300, radius, 12, 20, "I", Color.GRAY, Color.GREEN);
        drawCake(canvas, 500, 300, radius, 22, 70, "J", Color.GRAY, Color.BLUE);
        drawCake(canvas, 500, 300, radius, 73, 180, "K", Color.GRAY, Color.CYAN);
    }

    private void drawCake(Canvas canvas, int x, int y, int radius, int startDegree, int endDegree, String text, int lineColor, int sakeColor) {
        int l = 20;
        Paint paintLine = new Paint();
        paintLine.setColor(lineColor);
        paintLine.setStrokeWidth(3);
        if (startDegree < 0) {
            startDegree = 360 + startDegree;
        }
        if (endDegree < 0) {
            endDegree = 360 + endDegree;
        }
        int midD = (startDegree + endDegree) / 2;
        Paint paintText = new Paint();
        paintText.setColor(Color.WHITE);
        paintText.setTextSize(24);
        if (0 <= midD && midD < 90) {
            double radians = Math.toRadians(midD % 90);
            float endx = (float) (x + Math.cos(radians) * (radius + l));
            float endy = (float) (y + Math.sin(radians) * (radius + l));
            canvas.drawLine(x, y, endx, endy, paintLine);
            canvas.drawLine(endx, endy, endx + l * 3, endy, paintLine);
            paintText.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(text, endx + (l * 3 + 20), endy, paintText);
        } else if (90 <= midD && midD < 180) {
            double radians = Math.toRadians(midD % 90);
            float endx = (float) (x - Math.sin(radians) * (radius + l));
            float endy = (float) (y + Math.cos(radians) * (radius + l));
            canvas.drawLine(x, y, endx, endy, paintLine);
            canvas.drawLine(endx, endy, endx - l * 3, endy, paintLine);
            paintText.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(text, endx - (l * 3 + 20), endy, paintText);
        } else if (180 <= midD && midD < 270) {
            double radians = Math.toRadians(midD % 90);
            float endx = (float) (x - Math.cos(radians) * (radius + l));
            float endy = (float) (y - Math.sin(radians) * (radius + l));
            canvas.drawLine(x, y, endx, endy, paintLine);
            canvas.drawLine(endx, endy, endx - l * 3, endy, paintLine);
            paintText.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(text, endx - (l * 3 + 20), endy, paintText);
        } else if (270 <= midD && midD < 360) {
            double radians = Math.toRadians(midD % 90);
            float endx = (float) (x + Math.sin(radians) * (radius + l));
            float endy = (float) (y - Math.cos(radians) * (radius + l));
            canvas.drawLine(x, y, endx, endy, paintLine);
            canvas.drawLine(endx, endy, endx + l * 3, endy, paintLine);
            paintText.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(text, (endx + l * 3 + 20), endy, paintText);
        }

        Paint paint2 = new Paint();
        paint2.setColor(sakeColor);
        RectF rectF = new RectF(x - radius, y - radius, x + radius, y + radius);
        canvas.drawArc(rectF, startDegree, endDegree - startDegree, true, paint2);
    }
}
