package com.src;

import android.content.Context;

// New added
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;

// Brinda test comment
import android.view.View;

//Brinda comment added

public class DrawView extends View {
	
	Paint paint = new Paint();
	int prevXID;
	int prevYID;
	Point point = new Point();

	public DrawView(Context context, AttributeSet attrs) {

		super(context, attrs);

		setFocusable(true);
		setFocusableInTouchMode(true);

		paint.setStrokeWidth(5);
		paint.setColor(Color.RED);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStyle(Paint.Style.STROKE);

		this.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				v.setOnTouchListener(this);			
				point.x = event.getX();
				point.y = event.getY();
				
				invalidate();
				return true;
			}
		});
		requestFocus();
	}

	@Override
	public void onDraw(Canvas canvas) {
		//for (Point point : points) {
			canvas.drawLine(20, 20, point.x, point.y, paint);			
		//}
	}

	public void setPoints(Float xP, Float yP) {
		Point point = new Point();
		point.x = xP;
		point.y = yP;
		
		postInvalidate();
	}
}

class Point {
	float x, y;

	@Override
	public String toString() {
		return x + ", " + y;
	}
}