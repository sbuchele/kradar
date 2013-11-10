package com.example.kradar;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;

public class KradarLocService extends IntentService{
    
	public final String LOCATION_INTENT="com.example.kradar.Return Loc";
	public final String LOCATION_EXTRA="com.example.kradar.location";
	private SharedPreferences prefs;
	
	public KradarLocService(String name) {
		super(name);
		Context ctx = getApplicationContext();
		prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
	}

	@Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent
        String dataString = workIntent.getDataString();
        

        // Do work here, based on the contents of dataString
        
        
    }
	
}
