package com.example.kradar;

import java.util.ArrayList;
import java.util.Scanner;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

public class F_list extends FragmentActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		
		final ListView listview = (ListView) findViewById(R.id.friendList);
		String magicList=null;//TODO
		Scanner read=new Scanner(magicList);
		final ArrayList<String> list = new ArrayList<String>();
		
		while(read.hasNext()){
			list.add(read.next());
		}
	    
	    String[] values = new String[list.size()];
	    for (int i=0; i < list.size(); i++) {
	      values[i]=list.get(i);
	    }
		
		
		
		
	
	}
}
