package com.example.projecthomemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class TimerView extends View {
    private Paint timerPaint = new Paint ();
    private Paint timerLinePaint = new Paint();


    public TimerView(Context context) {
        super(context);
        init(null,0);
    }

    public TimerView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0);
    }

    public TimerView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }


    private void init (AttributeSet attrs, int defStyle){
        timerPaint.setColor(Color.CYAN);
        timerPaint.setAntiAlias(true);
        timerLinePaint.setColor(Color.BLACK);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/4,timerPaint);
        canvas.drawLine(getWidth()/2,getHeight()/2,getWidth()/2,getHeight()/2,timerLinePaint);
    }
}
