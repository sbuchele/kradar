package com.example.kradar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class New extends FragmentActivity {
private String phoneNum;
SharedPreferences Phone;
EditText entry;

protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Phone = Controller.pref;
		setContentView(R.layout.new_);
		entry=(EditText) findViewById(R.id.newInfo);
		
		
		Button b = (Button) findViewById(R.id.enter);
		b.setOnClickListener(Clicky());
	}	 

	public OnClickListener Clicky()
	{
		OnClickListener click = new OnClickListener()
		{
			@Override
			public void onClick(View V)
			{	
				entry=(EditText) findViewById(R.id.newInfo);
				Log.e("Kradar","entry==null"+(entry==null));
				Log.e("Kradar","entry.getText==null"+(entry.getText()==null));
				Log.e("Kradar",entry.getText().toString());
				phoneNum=entry.getText().toString();
				Phone.edit().putString(MainActivity.PHONE_NUMBER, phoneNum);
				Phone.edit().commit();
				KradarLocService.canGetLoc = true;
				MainActivity.first = true;
				//Intent intent = new Intent(New.this, MainActivity.class);
				//New.this.startActivity(intent);
				finish();
			
			}

		};
		return click;
	}
	
}
