package com.example.hotappproto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.*;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuRenderer;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuView;

public class KitchenRadialMenuViewClone extends RadialMenuView{

	float mWidth = -1;//center of screen, will change to touch location

	float mHeight = -1;

	float mThickness;

	float mRadius;

	private Paint imgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Bitmap lampIcon;
    private Bitmap toasterIcon;

	public KitchenRadialMenuViewClone(Context context, RadialMenuRenderer renderer) {
		super(context, renderer);
		mRadius = renderer.getRadius();
		lampIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.lamp_icon);
        toasterIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.toaster_icon);
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

        final RectF lampRect = new RectF();
        int shrinkage = 112;
        lampRect.set(mWidth - mRadius + shrinkage, mHeight - mRadius + shrinkage, mWidth + mRadius - shrinkage, mHeight + mRadius - shrinkage);
        final RectF toasterRect = new RectF(lampRect);

        lampRect.offset(0, -150);
        toasterRect.offset(0, 150);
		canvas.drawBitmap(lampIcon, null, lampRect, null);
        canvas.drawBitmap(toasterIcon, null, toasterRect, null);
	}
	
}
