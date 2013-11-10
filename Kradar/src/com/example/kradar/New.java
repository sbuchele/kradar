package com.example.kradar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
<<<<<<< HEAD

=======
	
>>>>>>> 359cfa0e4950ca9dcdde118b4426ab5d4a9e8aaf
private String phoneNum;
SharedPreferences Phone;
EditText entry;

protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Phone = Controller.pref;
		setContentView(R.layout.new_);
		entry=(EditText) findViewById(R.id.newInfo);
		
		
<<<<<<< HEAD
		Button b1 = (Button) findViewById(R.id.Enter);
		b1.setOnClickListener(Click1());
=======
		Button b = (Button) findViewById(R.id.enter);
		b.setOnClickListener(Clicky());
>>>>>>> 359cfa0e4950ca9dcdde118b4426ab5d4a9e8aaf
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
				Editor edit=Controller.pref.edit();
				edit.putString(MainActivity.PHONE_NUMBER, phoneNum);
				edit.commit();
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
