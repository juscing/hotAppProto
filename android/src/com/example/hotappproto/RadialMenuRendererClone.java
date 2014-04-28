package com.example.hotappproto;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuRenderer;

public class RadialMenuRendererClone extends RadialMenuRenderer {
	
	private View mParentView;
    private String room;
	
	public RadialMenuRendererClone(View parentView, boolean alt, float mThick,
			float mRadius, String room) {
		super(parentView, alt, mThick, mRadius);
		this.mParentView = parentView;
        this.room = room;
	}
	
	
	@Override
	public View renderView() {
        final LivingRoomRadialMenuViewClone livingRoommenu = new LivingRoomRadialMenuViewClone(mParentView.getContext(), this);
        final KitchenRadialMenuViewClone kitchenMenu = new KitchenRadialMenuViewClone(mParentView.getContext(), this);

        if (room.equals("kitchen")) {
            mParentView.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return kitchenMenu.gestureHandler(event, true);
                }
            });
            return kitchenMenu;
        } else {
            mParentView.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return livingRoommenu.gestureHandler(event, true);
                }
            });
            return livingRoommenu;
        }
    }
}
