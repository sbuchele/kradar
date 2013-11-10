package com.example.kradar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class New extends FragmentActivity {
private String phoneNum;
SharedPreferences Phone;	

protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Phone = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		setContentView(R.layout.adder);
		EditText entry=(EditText) findViewById(R.id.phone_number);
		phoneNum=entry.getText().toString();
		
		Button b1 = (Button) findViewById(R.id.entor);
		b1.setOnClickListener(Click1());
	}	 

	public OnClickListener Click1()
	{
		OnClickListener click = new OnClickListener()
		{
			@Override
			public void onClick(View V)
			{
				Phone.edit().putString(MainActivity.PHONE_NUMBER, phoneNum);
				KradarLocService.canGetLoc = true;
				MainActivity.first = true;
				Intent intent = new Intent(New.this, MainActivity.class);
				New.this.startActivity(intent);
			
			
			}

		};
		return click;
	}

}
