package com.wintech.chitraguptapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.wintechs.chitraguptaapp.common.FragmentHelper;
import com.wintechs.chitraguptaapp.fragment.AboutUsFragment;
import com.wintechs.chitraguptaapp.fragment.SettingsFragment;

public class BaseActivity extends ApplicationLayer {
	
	// Within which the entire activity is enclosed
	protected DrawerLayout mDrawerLayout;

	// ListView represents Navigation Drawer
	protected ListView mDrawerList;

	// ActionBarDrawerToggle indicates the presence of Navigation Drawer in the
	// action bar
	private ActionBarDrawerToggle mDrawerToggle;

	private Toolbar toolbar;

	public void initDrawer() {
		
		// Set a Toolbar to replace the ActionBar.
		setToolbar();
		
		// Getting reference to the DrawerLayout
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// Setting DrawerToggle on DrawerLayout
		// toolbar.setNavigationIcon(R.drawable.ic_drawer);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
				R.string.drawer_open, R.string.drawer_close) {

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);

			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);

			}
		};
		

		mDrawerToggle
				.setToolbarNavigationClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View view) {
						mDrawerLayout.openDrawer(Gravity.LEFT);
					}
				});
		mDrawerToggle.setDrawerIndicatorEnabled(false); // disable
		// "hamburger to arrow"
		// drawable
		mDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	// Make sure this is the method with just `Bundle` as the signature
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	/** Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		switch (item.getItemId()) {
		case android.R.id.home:
			mDrawerLayout.openDrawer(GravityCompat.START);
			return true;
		case R.id.action_settings:
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, SettingsFragment.class.getName()));
			break;
		case R.id.action_about:
			FragmentHelper.replaceFragment(this, Fragment.instantiate(this, AboutUsFragment.class.getName()));
			break;
		case R.id.action_share:

			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	
	public Toolbar getToolbar(){
		return toolbar;
	}
	public void setToolbar(){
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}
	
}
