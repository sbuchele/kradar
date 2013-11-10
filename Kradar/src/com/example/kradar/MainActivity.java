package com.example.kradar;

import java.util.ArrayList;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.location.Location;

import android.location.LocationListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity 
//implements
//GooglePlayServicesClient.ConnectionCallbacks,
//GooglePlayServicesClient.OnConnectionFailedListener,
//LocationListener  
{

	Controller c;

//	// Global constants
//	/*
//	 * Define a request code to send to Google Play services
//	 * This code is returned in Activity.onActivityResult
//	 */
//	private final static int
//	CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
//
//	// Define a DialogFragment that displays the error dialog
//	public static class ErrorDialogFragment extends DialogFragment {
//		// Global field to contain the error dialog
//		private Dialog mDialog;
//		// Default constructor. Sets the dialog field to null
//		public ErrorDialogFragment() {
//			super();
//			mDialog = null;
//		}
//		// Set the dialog to display
//		public void setDialog(Dialog dialog) {
//			mDialog = dialog;
//		}
//		// Return a Dialog to the DialogFragment.
//		@Override
//		public Dialog onCreateDialog(Bundle savedInstanceState) {
//			return mDialog;
//		}
//	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		c=new Controller();
			 
		//if(Fluffles.Messenger. == false)
		//{
			
		//}
		
		//button creation and implementation
		Button b1 = (Button) findViewById(R.id.attack);
		Button b2 = (Button) findViewById(R.id.Friends);
		Button b3 = (Button) findViewById(R.id.add);
		b1.setOnClickListener(Click1());
		b2.setOnClickListener(Click2());
		b3.setOnClickListener(Click3());
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onStart()
	{
		super.onStart();
		startService(new Intent(this, KradarLocService.class));
	}


//	/*
//	 * Handle results returned to the FragmentActivity
//	 * by Google Play services
//	 */
//	@Override
//	protected void onActivityResult(
//			int requestCode, int resultCode, Intent data) {
//		// Decide what to do based on the original request code
//		switch (requestCode) {
//		case CONNECTION_FAILURE_RESOLUTION_REQUEST :
//			/*
//			 * If the result code is Activity.RESULT_OK, try
//			 * to connect again
//			 */
//			switch (resultCode) {
//			case Activity.RESULT_OK :
//				/*
//				 * Try the request again
//				 */
//
//				break;
//			}
//
//		}
//	}

//	private boolean servicesConnected() {
//		// Check that Google Play services is available
//		int resultCode =
//				GooglePlayServicesUtil.
//				isGooglePlayServicesAvailable(this);
//		// If Google Play services is available
//		if (ConnectionResult.SUCCESS == resultCode) {
//			// In debug mode, log the status
//			Log.d("Location Updates",
//					"Google Play services is available.");
//			// Continue
//			return true;
//			// Google Play services was not available for some reason
//		} else {
//			// Get the error code
//			int errorCode = connectionResult.getErrorCode();
//			// Get the error dialog from Google Play services
//			Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(
//					errorCode,
//					this,
//					CONNECTION_FAILURE_RESOLUTION_REQUEST);
//
//			// If Google Play services can provide an error dialog
//			if (errorDialog != null) {
//				// Create a new DialogFragment for the error dialog
//				ErrorDialogFragment errorFragment =
//						new ErrorDialogFragment();
//				// Set the dialog in the DialogFragment
//				errorFragment.setDialog(errorDialog);
//				// Show the error dialog in the DialogFragment
//				errorFragment.show(getSupportFragmentManager(),
//						"Location Updates");
//			}
//		}
//	}
//
//	/*
//	 * Called by Location Services when the request to connect the
//	 * client finishes successfully. At this point, you can
//	 * request the current location or start periodic updates
//	 */
//	@Override
//	public void onConnected(Bundle dataBundle) {
//		// Display the connection status
//		Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
//
//	}
//
//	/*
//	 * Called by Location Services if the connection to the
//	 * location client drops because of an error.
//	 */
//	@Override
//	public void onDisconnected() {
//		// Display the connection status
//		Toast.makeText(this, "Disconnected. Please re-connect.",
//				Toast.LENGTH_SHORT).show();
//	}
//
//	@Override
//	public void onLocationChanged(Location location) {
//		// Report to the UI that the location was updated
//        String msg = "Updated Location: " +
//                Double.toString(location.getLatitude()) + "," +
//                Double.toString(location.getLongitude());
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//
//
//	}
//
//
//	@Override
//	public void onProviderDisabled(String provider) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	@Override
//	public void onProviderEnabled(String provider) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	@Override
//	public void onStatusChanged(String provider, int status, Bundle extras) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	@Override
//	public void onConnectionFailed(ConnectionResult arg0) {
//		// TODO Auto-generated method stub
//
//	}
	
	public OnClickListener Click1()
	{
		OnClickListener click = new OnClickListener()
		{
			@Override
			public void onClick(View V)
			{
				
			}
			
		};
		return click;
	}
		
	public OnClickListener Click2()
	{
		OnClickListener click = new OnClickListener()
		{
			@Override
			public void onClick(View V)
			{
				Intent intent = new Intent(MainActivity.this, F_list.class);
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

	public String getMyPhoneNumber()
	{
	    return ((TelephonyManager) getSystemService(TELEPHONY_SERVICE))
	            .getLine1Number();
	}
	
}
