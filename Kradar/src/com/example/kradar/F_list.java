package com.example.kradar;

import java.util.ArrayList;
import java.util.Scanner;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class F_list extends ListActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		
		final ListView listView = (ListView) findViewById(R.id.friendList);
		String magicList=Controller.pref.getString(Controller.FRIEND_NO, "");
		Scanner read=new Scanner(magicList);
		final ArrayList<String> list = new ArrayList<String>();
		
		while(read.hasNext()){
			list.add(read.next());
		}
	    read.close();
	    
	    String[] values = new String[list.size()];
	    for (int i=0; i < list.size(); i++) {
	      values[i]=list.get(i);
	    }
	    
	    final ArrayAdapter adapter = new ArrayAdapter(this,
	            android.R.layout.simple_list_item_1, list);
	        listView.setAdapter(adapter);
		
		
	  /* listView.setOnClickListener(new OnItemClickListener() {
	   @Override
    	  public void onItemClick(AdapterView<?> parent, View view,
    	    int position, long id) {
    	    	switch(position){
    	    	
    	    	}
    	  }
	   	});/*/
		
	
	}
}
