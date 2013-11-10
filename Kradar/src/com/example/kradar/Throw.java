package com.example.kradar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Throw extends FragmentActivity {
	
	private String phoneNum;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
				KradarLocService.fluffy.tophat.setPhone(phoneNum);
				KradarLocService.fluffy.poke();
				Intent intent = new Intent(Throw.this, MainActivity.class);
				Throw.this.startActivity(intent);
			}

		};
		return click;
	}

}
