package com.example.kradar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends FragmentActivity 
implements
GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener,
LocationListener  
{

	final public static String PHONE_NUMBER = "com.example.kradar.PhoneNumber" ;
	static boolean first = false;
	
	LocationClient mLocationClient;
	
	boolean inProgress = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		SharedPreferences Phone1 = PreferenceManager.getDefaultSharedPreferences(this);
		Controller.setSharedPreferences(Phone1);
		
//		if (Phone1.getString(PHONE_NUMBER, "").equals("") && first == false)
//		{				
//			Intent intent = new Intent(MainActivity.this, New.class);
//			MainActivity.this.startActivity(intent);
//
//		}

		startService(new Intent(this, KradarLocService.class));

		//button creation and implementation
		Button b1 = (Button) findViewById(R.id.attack);
		Button b2 = (Button) findViewById(R.id.Friends);
		Button b3 = (Button) findViewById(R.id.add);
		b1.setOnClickListener(Click1());
		b2.setOnClickListener(Click2());
		b3.setOnClickListener(Click3());

		mLocationClient = new LocationClient(this, this, this);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	Location mLocation;
	Context here = this;

	public OnClickListener Click1()
	{
		
		OnClickListener click = new OnClickListener()
		{
			@Override
			public void onClick(View V)
			{
				if(servicesConnected()){
				mLocation = mLocationClient.getLastLocation();
				
		        Toast.makeText(here, mLocation.getLatitude() + "  " + mLocation.getLongitude(), Toast.LENGTH_SHORT).show();
		        
		        KradarLocService.fluffy.tophat.setLat(mLocation.getLatitude());
		        KradarLocService.fluffy.poke();
		        
		       	KradarLocService.fluffy.tophat.setLon(mLocation.getLongitude());
		        KradarLocService.fluffy.poke();
			}
			}

		};
		return click;
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

	public OnClickListener Click2()
	{
		OnClickListener click = new OnClickListener()
		{
			@Override
			public void onClick(View V)
			{
				Intent intent = new Intent(MainActivity.this, Login.class);
				MainActivity.this.startActivity(intent);
			}

		};
		return click;
	}

	public OnClickListener Click3()
	{
		OnClickListener click = new OnClickListener()
		{
			@Override
			public void onClick(View V)
			{
				Intent intent = new Intent(MainActivity.this, Throw.class);
				MainActivity.this.startActivity(intent);
			}			
		};

		return click;
	}


	@Override
	public void onLocationChanged(Location arg0) {
		String msg = "Updated Location: " +
                Double.toString(arg0.getLatitude()) + "," +
                Double.toString(arg0.getLongitude());
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        
        KradarLocService.fluffy.tophat.setLat(arg0.getLatitude());
        KradarLocService.fluffy.poke();
        
       	KradarLocService.fluffy.tophat.setLon(arg0.getLongitude());
        KradarLocService.fluffy.poke();
		
	}


	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
		inProgress = false;
	}


	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		mLocation = mLocationClient.getLastLocation();
	}


	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}
}
