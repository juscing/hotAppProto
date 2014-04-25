package com.example.hotappproto;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuItem;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuRenderer;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuRenderer.OnRadailMenuClick;

public class MainActivity extends Activity {

	private static final int[] ITEM_DRAWABLES = { R.drawable.ic_launcher, R.drawable.ic_launcher,
		R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher };
	
	private ArrayList<RadialMenuItem> items;
	
	private RadialMenuRenderer mRenderer;
	RadialMenuItem menuItem;
	RadialMenuItem menuItem2;
	RadialMenuItem menuItem3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		FrameLayout v = (FrameLayout) findViewById(R.id.container);
		
		items = new ArrayList<RadialMenuItem>();
		
		mRenderer = new RadialMenuRenderer(v, true, 60, 120);
		menuItem = new RadialMenuItem("Test","Test");
		menuItem2 = new RadialMenuItem("Test","Test");
		menuItem3 = new RadialMenuItem("Test","Test");
		
		
		
		menuItem.setOnRadialMenuClickListener(new OnRadailMenuClick() {
			@Override
			public void onRadailMenuClickedListener(String id) {
				//Can edit based on preference. Also can add animations here.
				Toast.makeText(MainActivity.this, "One", Toast.LENGTH_SHORT).show();
			}
		});
		
		menuItem2.setOnRadialMenuClickListener(new OnRadailMenuClick() {
			@Override
			public void onRadailMenuClickedListener(String id) {
				//Can edit based on preference. Also can add animations here.
				Toast.makeText(MainActivity.this, "Two", Toast.LENGTH_SHORT).show();
			}
		});
		
		menuItem3.setOnRadialMenuClickListener(new OnRadailMenuClick() {
			@Override
			public void onRadailMenuClickedListener(String id) {
				//Can edit based on preference. Also can add animations here.
				Toast.makeText(MainActivity.this, "Three", Toast.LENGTH_SHORT).show();
			}
		});
		
		
		
		
		items.add(menuItem);
		items.add(menuItem2);
		items.add(menuItem3);
		mRenderer.setRadialMenuContent(items);
	    
	    v.addView(mRenderer.renderView());
	    /*
	    v.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				pieMenu.setSourceLocation((int) event.getX(), (int) event.getY());
				pieMenu.show(v);
				
				return false;
			}
	    	
	    });
	    */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			
		    
			return rootView;
		}
		
	}

}
