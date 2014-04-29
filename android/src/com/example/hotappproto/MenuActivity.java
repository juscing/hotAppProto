package com.example.hotappproto;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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
		View rootview;
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_menu, container,
					false);
			
			FrameLayout f = (FrameLayout) rootView.findViewById(R.id.tv);
			
			f.setOnClickListener(new OnClickListener(){
			ImageView iv;
				@Override
				public void onClick(View v) {
					/*
					iv = new ImageView(getActivity());
					
					iv.setImageResource(R.drawable.sub_menu_2);
					
					iv.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					iv.setScaleX((float) 1.2);
					iv.setScaleY((float) 1.2); */
					//FrameLayout f = (FrameLayout) v.findViewById(R.id.tv);
					addImage(iv);
				}
				
			});
			this.rootview = rootView;
			return rootView;
		}
		public void addImage(View v ) {
			RelativeLayout r = (RelativeLayout) rootview.findViewById(R.id.rellay);
			r.removeAllViews();
			r.setBackgroundResource(R.drawable.sub_menu_2);
			//r.addView(v);
		}
	}

}
