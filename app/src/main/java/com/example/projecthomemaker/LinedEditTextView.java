package com.example.projecthomemaker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

public class LinedEditTextView extends android.support.v7.widget.AppCompatEditText {
    Rect rect;
    Paint paint;

    int offset;
    int previousColor;

    public LinedEditTextView(Context context) {
        super(context);
        init(null);
    }

    public LinedEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public LinedEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        rect = new Rect();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(
                    attrs,
                    R.styleable.LinedEditTextView);

            offset = typedArray.getInt(
                    R.styleable.LinedEditTextView_line_offset,
                    10);

            paint.setStrokeWidth(
                    typedArray.getFloat(
                            R.styleable.LinedEditTextView_line_thickness,
                            2));

            paint.setColor(
                    typedArray.getColor(
                            R.styleable.LinedEditTextView_line_color,
                            getResources().getColor(R.color.colorPrimaryDark)));
        } else {
            paint.setStrokeWidth(5);
            paint.setColor(Color.GREEN);
            offset = 10;
        }
    }
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if(focused) {
            previousColor = getColor();
            setColor(Color.GREEN);
        } else {
            setColor(previousColor);
        }
    }
    public void setColor(int Color) {
        paint.setColor(Color);
    }

    public int getColor() {
        return paint.getColor();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        int count = getLineCount();
        for (int i = 0; i < count; ++i) {
            int baseLine = getLineBounds(i, rect);
            // this will draw a line below each line of text
            canvas.drawLine(rect.left, baseLine + offset, rect.right, baseLine + offset, paint);
        }
        super.onDraw(canvas);
    }
}