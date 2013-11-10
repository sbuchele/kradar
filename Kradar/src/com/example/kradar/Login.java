package com.example.kradar;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends FragmentActivity {
	private String phoneNum;
	EditText entry;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adder);
		entry=(EditText) findViewById(R.id.phone_number);
		
		
		
		
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
				phoneNum=entry.getText().toString();
				String prev=Controller.pref.getString(Controller.FRIEND_NO, "3");
				prev+=" "+phoneNum;
				Editor edit=Controller.pref.edit();
				edit.putString(Controller.FRIEND_NO, prev);
				edit.commit();
				KradarLocService.fluffy.tophat.setDual(phoneNum);
				KradarLocService.fluffy.poke();
				//Intent intent = new Intent(Throw.this, MainActivity.class);
				//Throw.this.startActivity(intent);
				finish();
			}

		};
		return click;
	}

}


