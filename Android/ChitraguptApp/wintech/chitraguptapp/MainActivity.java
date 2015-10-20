package com.wintech.chitraguptapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.wintechs.chitraguptaapp.adapter.NavAdapter;
import com.wintechs.chitraguptaapp.common.FragmentHelper;
import com.wintechs.chitraguptaapp.fragment.AartiFragment;
import com.wintechs.chitraguptaapp.fragment.AboutUsFragment;
import com.wintechs.chitraguptaapp.fragment.GalleryFragment;
import com.wintechs.chitraguptaapp.fragment.HistoryFragment;
import com.wintechs.chitraguptaapp.fragment.PujaFragment1;
import com.wintechs.chitraguptaapp.fragment.PujaVidhiFragment;
import com.wintechs.chitraguptaapp.fragment.SettingsFragment;
import com.wintechs.chitraguptaapp.fragment.chalisa.ChalisaMainFragment;
import com.wintechs.chitraguptaapp.navdata.NavMenuList;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initDrawer();
		setUpDrawer();

	}

	private void setUpDrawer() {
		// toolbar.setDisplayHomeAsUpEnabled(true);
		// getSupportActionBar().setHomeButtonEnabled(true);

		NavAdapter adapter = new NavAdapter(this, new NavMenuList().getNavigationMenuList());
		// Setting the adapter on mDrawerList
		mDrawerList.setAdapter(adapter);

		FragmentHelper.replaceFragment(this, Fragment.instantiate(this, PujaFragment1.class.getName()));
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				changeFragment(position);
				// Closing the drawer
				mDrawerLayout.closeDrawer(mDrawerList);

			}

		});

	}

	// Modify main fragment layout as per user selection
	private void changeFragment(int position) {
		switch (position) {
		case 1:
			// .setTitle("History");
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, HistoryFragment.class.getName()));
			break;
		case 2:
			// getActionBar().setTitle("Wansh");
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, AboutUsFragment.class.getName()));
			break;
		case 3:
			// getActionBar().setTitle("Puja Vidhi");
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, PujaFragment1.class.getName()), 2);
			break;
		case 4:
			// getActionBar().setTitle("Aarti");
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, AartiFragment.class.getName()));
			break;
		case 5:
			// getActionBar().setTitle("Chalisa");
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, ChalisaMainFragment.class.getName()), 4);
			break;
		case 6:
			// getActionBar().setTitle("Gallery");
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, GalleryFragment.class.getName()));
			break;
		case 7:
			// getActionBar().setTitle("Settings");
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, SettingsFragment.class.getName()));
			break;
		case 8:
			// getActionBar().setTitle("About us");
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, AboutUsFragment.class.getName()));
			break;
		default:
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, HistoryFragment.class.getName()));
			break;

		}
	}

	

}
