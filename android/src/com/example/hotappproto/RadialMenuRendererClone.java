package com.example.hotappproto;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuRenderer;

public class RadialMenuRendererClone extends RadialMenuRenderer {
	
	private View mParentView;
	
	public RadialMenuRendererClone(View parentView, boolean alt, float mThick,
			float mRadius) {
		super(parentView, alt, mThick, mRadius);
		this.mParentView = parentView;
	}
	
	
	@Override
	public View renderView() {
		final RadialMenuViewClone menu = new RadialMenuViewClone(mParentView.getContext(), this);
		mParentView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return menu.gestureHandler(event, true);
			}
		});
		return menu;
	}
}
