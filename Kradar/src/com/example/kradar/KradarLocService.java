package com.example.kradar;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class KradarLocService extends IntentService{
    public KradarLocService(String name) {
		super(name);
	}

	@Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent
        String dataString = workIntent.getDataString();

        // Do work here, based on the contents of dataString
        
    }
	// Puts the status into the Intent
	Intent localIntent =
            new Intent("Return Loc").putExtra("Location", "something");
    // Broadcasts the Intent to receivers in this app.
    boolean y=LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
}
