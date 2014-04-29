package com.example.hotappproto;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuHelperFunctions;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuItem;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuRenderer;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuView;

public class LivingRoomRadialMenuViewClone extends RadialMenuView{
	
	private ArrayList<RadialMenuItem> mRadialMenuContent = new ArrayList<RadialMenuItem>(0);
	
	float mWidth = -1;//center of screen, will change to touch location
	
	float mHeight = -1;
	
	float mThickness;
	
	float mRadius;
	
	float[] endTouch;
	
	private RadialMenuHelperFunctions mHelperFunctions;
	
	private Paint imgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	int selected = -1;

	int lastE = -1;//last event, used to prevent excessive redrawing
	
	boolean alt;
	
	
	private Paint mBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	private Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

	private Paint mSelectedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

	private Paint mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	
	public Context c;
	
    private Bitmap lampIcon;
    private Bitmap tvIcon;
    private Bitmap fireIcon;
	
	public LivingRoomRadialMenuViewClone(Context context, RadialMenuRenderer renderer) {
		super(context, renderer);
		c = context;
		mRadius = renderer.getRadius();
		lampIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.lamp_icon);
        tvIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.tv_icon);
        fireIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.fireplace_icon);
        mHelperFunctions = new RadialMenuHelperFunctions();
        mRadialMenuContent = renderer.getRadialMenuContent();
        alt = renderer.isAlt();
        
		
		mThickness = renderer.getMenuThickness();
		mRadius = renderer.getRadius();
		setVisibility(GONE);
		initSetPaint(renderer);
	}
	
	private void initSetPaint(RadialMenuRenderer renderer) {
		mBgPaint.setColor(renderer.getMenuBackgroundColor());
		mBgPaint.setStrokeWidth(renderer.getMenuThickness());
		mBgPaint.setStyle(Paint.Style.STROKE);

		mSelectedPaint.setColor(renderer.getMenuSelectedColor());
		mSelectedPaint.setStrokeWidth(renderer.getMenuThickness());
		mSelectedPaint.setStyle(Paint.Style.STROKE);

		mBorderPaint.setColor(renderer.getMenuBorderColor());
		mBorderPaint.setStrokeWidth(renderer.getMenuThickness());
		mBorderPaint.setStyle(Paint.Style.STROKE);

		mTextPaint.setColor(renderer.getMenuTextColor());
		mTextPaint.setTextSize((float) (renderer.getMenuThickness() / 2));
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
        final RectF tvRect = new RectF(lampRect);
        final RectF fireRect = new RectF(lampRect);

        lampRect.offset(0, -150);
        tvRect.offset(120, 95);
        fireRect.offset(-120, 95);
		canvas.drawBitmap(lampIcon, null, lampRect, null);
        canvas.drawBitmap(tvIcon, null, tvRect, null);
        canvas.drawBitmap(fireIcon, null, fireRect, null);
		//Drawable drawable = getResources().getDrawable(R.drawable.fireplace_icon);
	}
	
	@Override
	public boolean gestureHandler(MotionEvent event, boolean eat) {
		if (event.getAction() == MotionEvent.ACTION_UP) {
			endTouch = new float[] { event.getX(), event.getY() };
			if (mHelperFunctions.distance(mWidth, mHeight, endTouch[0], endTouch[1]) > mRadius - mThickness / 2) {
				start();
			}
		}
		return super.gestureHandler(event, eat);
	}
	
	
	public void start() {
		
	}
}
