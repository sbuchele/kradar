package com.example.kradar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;

public class Throw extends FragmentActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adder);
		EditText entry=(EditText) findViewById(R.id.phone_number);
		String phoneNum=entry.getText().toString();
		
	}	 
}
