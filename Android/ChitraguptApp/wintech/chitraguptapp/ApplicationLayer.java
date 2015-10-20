package com.wintech.chitraguptapp;

import com.wintechs.chitraguptaapp.utils.Constants;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.ActionBarActivity;

public class ApplicationLayer extends ActionBarActivity {
	
	private SharedPreferences prefs;
	
	public void setPref(String key, String values) {
		
	Editor edit = prefs.edit();
	edit.putString(key, values);
	edit.commit();
	
	}
	
	private void getSharedPref(){
		prefs = getSharedPreferences(Constants.USER_PREFS,
				Context.MODE_PRIVATE);
	}
}
