package com.example.kradar;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public class KradarLocService extends Service implements 
GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener,
	LocationListener{
    
	public final static String LOCATION_INTENT="com.example.kradar.Return Loc";
	public final static String LOCATION_EXTRA="com.example.kradar.location";
	public final static String POWER="com.example.kradar.powerlevel";
	private SharedPreferences prefs;
    private LocationClient mLocationClient;
    private LocationRequest mLocationRequest;
    // Flag that indicates if a request is underway.
    private boolean mInProgress;
    private Boolean servicesAvailable = false;
	
	public KradarLocService() {
		super();
		
	}
	
	public static Fluffles fluffy;
	static Thread fluffyThread;
	
	
    @Override
	public void onCreate() {
        super.onCreate();
        
        Toast.makeText(this, "created1", Toast.LENGTH_SHORT).show();
 
        mInProgress = false;
        // Create the LocationRequest object
        mLocationRequest = LocationRequest.create();
        // Use moderately high accuracy
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        // Set the update interval to 5 min
        mLocationRequest.setInterval(1000*60*5);
        // Set the fastest update interval to 2.5 min
        mLocationRequest.setFastestInterval(1000*30*5);
        
        servicesAvailable = servicesConnected();
        
        fluffy = new Fluffles();
        //Put the phone's ID in fluffy's hat
        Fluffles.tophat.setPhone("3");
        fluffyThread = new Thread(fluffy);
        fluffyThread.start();
        
        
        /*
         * Create a new location client, using the enclosing class to
         * handle callbacks.
         */
        mLocationClient = new LocationClient(this, this, this);
        
        Context ctx = getApplicationContext();
		prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
		
		//Grab Phone Number send to Serv.
		//to do
		
		
		Toast.makeText(this, "created", Toast.LENGTH_SHORT).show();
    }
	
    private boolean servicesConnected() {
    	
        // Check that Google Play services is available
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        
        // If Google Play services is available
        if (ConnectionResult.SUCCESS == resultCode) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int onStartCommand (Intent intent, int flags, int startId)
    {
        super.onStartCommand(intent, flags, startId);
        
        if(!servicesAvailable || mLocationClient.isConnected() || mInProgress)
        	return START_STICKY;
        
        if(mLocationClient == null) 
            mLocationClient = new LocationClient(this, this, this);
        if(!mLocationClient.isConnected() || !mLocationClient.isConnecting() && !mInProgress)
        {
        	mInProgress = true;
        	mLocationClient.connect();
        }
        
        return START_STICKY;
    }
	
	public class LocalBinder extends Binder {
    	public KradarLocService getServerInstance() {
    		return KradarLocService.this;
    	}
    }
	
	@Override
	public IBinder onBind(Intent intent) {
		return new LocalBinder();
	}

	@Override
	public void onLocationChanged(Location arg0) {
		 // Report to the UI that the location was updated
        String msg = "Updated Location: " +
                Double.toString(arg0.getLatitude()) + "," +
                Double.toString(arg0.getLongitude());
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        
        Fluffles.tophat.setLat(arg0.getLatitude());
        Fluffles.tophat.setLon(arg0.getLongitude());
        fluffy.poke();
        
        int power=prefs.getInt(POWER, 0);
        prefs.edit().putInt(POWER, power);///TODO get power information
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		mInProgress = false;
	}

	@Override
	public void onConnected(Bundle arg0) {
		 // Request location updates using static settings
        mLocationClient.requestLocationUpdates(mLocationRequest, this);
	}

	@Override
	public void onDisconnected() {
		// Turn off the request flag
        mInProgress = false;
        // Destroy the current location client
        mLocationClient = null;
	}
	
    @Override
    public void onDestroy(){
        // Turn off the request flag
        mInProgress = false;
        if(servicesAvailable && mLocationClient != null) {
	        mLocationClient.removeLocationUpdates(this);
	        // Destroy the current location client
	        mLocationClient = null;
        }
        super.onDestroy();  
    }

	
	
	
}
