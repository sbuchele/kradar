package com.example.kradar;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends FragmentActivity 
//implements
//GooglePlayServicesClient.ConnectionCallbacks,
//GooglePlayServicesClient.OnConnectionFailedListener,
//LocationListener  
{

	final public static String PHONE_NUMBER = "com.example.kradar.PhoneNumber" ;
	static boolean first = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		SharedPreferences Phone1 = PreferenceManager.getDefaultSharedPreferences(this);
		Controller.setSharedPreferences(Phone1);
		
		if (Phone1.getString(PHONE_NUMBER, "").equals("") && first == false)
		{				
			Intent intent = new Intent(MainActivity.this, New.class);
			MainActivity.this.startActivity(intent);

		}

		startService(new Intent(this, KradarLocService.class));

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
		KradarLocService.fluffy.tophat.setPhone(Controller.pref.getString(PHONE_NUMBER, ""));
		KradarLocService.fluffy.poke();

	}
	public OnClickListener Click1()
	{
		SharedPreferences Power= Controller.pref;
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
}
