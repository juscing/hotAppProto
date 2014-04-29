package com.example.hotappproto;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuItem;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuRenderer;
import com.touchmenotapps.widget.radialmenu.menu.v2.RadialMenuRenderer.OnRadailMenuClick;

public class MainActivity extends Activity {

    PlaceholderFragment placeholderFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ImageView backgroundView = (ImageView) findViewById(R.id.backgroundView);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            backgroundView.setBackgroundResource(R.drawable.floor_plan);
        } else {
            backgroundView.setBackgroundResource(R.drawable.home_screen);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            placeholderFragment = new PlaceholderFragment();
            transaction.add(R.id.container, placeholderFragment);
            transaction.commit();
        }

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
    public void onSaveInstanceState(Bundle state)
    {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.remove(placeholderFragment);
            ft.commit();
        }
        super.onSaveInstanceState(state);
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

        private ArrayList<RadialMenuItem> livingRoomItems;
        private ArrayList<RadialMenuItem> kitchenItems;

        RadialMenuRenderer livingRoomRenderer;
        RadialMenuRenderer kitchenRenderer;
		RadialMenuItem lightsMenuItem;
		RadialMenuItem tvMenuItem;
        RadialMenuItem fireplaceMenuItem;
        RadialMenuItem toasterMenuItem;
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

            FrameLayout livingRoomView = (FrameLayout) rootView.findViewById(R.id.livingRoomFrame);
            FrameLayout kitchenView = (FrameLayout) rootView.findViewById(R.id.kitchenFrame);

            livingRoomRenderer = new RadialMenuRendererClone(this.getActivity(), livingRoomView, true, 100, 150, "livingRoom");
            kitchenRenderer = new RadialMenuRendererClone(this.getActivity(), kitchenView, true, 100, 150, "kitchen");
            livingRoomRenderer.setMenuBackgroundColor(0xcc000000);
            livingRoomRenderer.setMenuSelectedColor(0xdd0069C4);
            kitchenRenderer.setMenuBackgroundColor(0xcc000000);
            kitchenRenderer.setMenuSelectedColor(0xdd0069C4);
		    lightsMenuItem = new RadialMenuItem("Lights", "");
			tvMenuItem = new RadialMenuItem("TV", "");
			fireplaceMenuItem = new RadialMenuItem("Fire", "");
            toasterMenuItem = new RadialMenuItem("Toaster", "");


            livingRoomItems = new ArrayList<RadialMenuItem>();
            kitchenItems = new ArrayList<RadialMenuItem>();
			
			lightsMenuItem.setOnRadialMenuClickListener(new OnRadailMenuClick() {
                @Override
                public void onRadailMenuClickedListener(String id) {
                    //Can edit based on preference. Also can add animations here.
                    Toast.makeText(getActivity(), "Lights ON", Toast.LENGTH_SHORT).show();
                }
            });
			
			tvMenuItem.setOnRadialMenuClickListener(new OnRadailMenuClick() {
                @Override
                public void onRadailMenuClickedListener(String id) {
                    //Can edit based on preference. Also can add animations here.
                    Toast.makeText(getActivity(), "TV ON", Toast.LENGTH_SHORT).show();
                }
            });

            fireplaceMenuItem.setOnRadialMenuClickListener(new OnRadailMenuClick() {
                @Override
                public void onRadailMenuClickedListener(String id) {
                    //Can edit based on preference. Also can add animations here.
                    Toast.makeText(getActivity(), "Fireplace ON", Toast.LENGTH_SHORT).show();
                }
            });

            toasterMenuItem.setOnRadialMenuClickListener(new OnRadailMenuClick() {
                @Override
                public void onRadailMenuClickedListener(String id) {
                    //Can edit based on preference. Also can add animations here.
                    Toast.makeText(getActivity(), "Toasting your bread!", Toast.LENGTH_SHORT).show();
                }
            });
			
			
			
			
			livingRoomItems.add(lightsMenuItem);
            livingRoomItems.add(tvMenuItem);
            livingRoomItems.add(fireplaceMenuItem);
            kitchenItems.add(lightsMenuItem);
            kitchenItems.add(toasterMenuItem);
            livingRoomRenderer.setRadialMenuContent(livingRoomItems);
            kitchenRenderer.setRadialMenuContent(kitchenItems);

            livingRoomView.addView(livingRoomRenderer.renderView());
            kitchenView.addView(kitchenRenderer.renderView());
			
			return rootView;
		}
		
	}

}
