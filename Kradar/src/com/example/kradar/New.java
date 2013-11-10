package com.example.kradar;

import space.magiccounterpro.SetLifeDialog.NoticeDialogListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
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
		Phone = Controller.pref;
		setContentView(R.layout.adder);
		
		
		
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
				EditText entry=(EditText) findViewById(R.id.new_info);
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
	/*
	public interface NoticeDialogListener {
        public void onSetLifePositiveClick(DialogFragment dialog, int newlife);
        public void onSetLifeNegativeClick(DialogFragment dialog);
    }
    
    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;
*/
}
