package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        Path path = new Path();
        path.addCircle(200, 200, 50, Path.Direction.CW);
        path.addCircle(300, 200, 50, Path.Direction.CW);
        canvas.drawPath(path, paint);

        Path path1 = new Path();
        path1.arcTo(new RectF(400, 100, 500, 200), -200, 200);
        path1.arcTo(new RectF(500, 100, 600, 200), -200, 200);
        path1.lineTo(500, 275);
        canvas.drawPath(path1, paint);

    }
}
