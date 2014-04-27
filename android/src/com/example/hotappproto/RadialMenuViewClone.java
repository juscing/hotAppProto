package com.example.hotappproto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuRenderer;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuView;

public class RadialMenuViewClone extends RadialMenuView{
	
	float mWidth = -1;//center of screen, will change to touch location
	
	float mHeight = -1;
	
	float mThickness;
	
	float mRadius;
	
	private Paint imgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	private Bitmap icon1;
	
	public RadialMenuViewClone(Context context, RadialMenuRenderer renderer) {
		super(context, renderer);
		mRadius = renderer.getRadius();
		icon1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.lamp_icon);
		
	}
	
	public void setLoc(float x, float y) {
		if (x < mRadius + mThickness / 2)
			x = mRadius + mThickness / 2;
		if (y < mRadius + mThickness / 2)
			y = mRadius + mThickness / 2;

		if (y > this.getHeight() - (mRadius + mThickness / 2))
			y = this.getHeight() - (mRadius + mThickness / 2);
		if (x > this.getWidth() - (mRadius + mThickness / 2))
			x = this.getWidth() - (mRadius + mThickness / 2);

		mWidth = x;
		mHeight = y;
		super.setLoc(x, y);
	}
	
	@SuppressLint("DrawAllocation")
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		
		final RectF rect = new RectF();
		
		rect.set(mWidth - mRadius, mHeight - mRadius, mWidth + mRadius, mHeight + mRadius);
		canvas.drawBitmap(icon1, null, rect, null);
		//Drawable drawable = getResources().getDrawable(R.drawable.fireplace_icon);
	}
	
}
