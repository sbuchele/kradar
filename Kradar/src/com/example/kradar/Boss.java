package com.example.kradar;

import android.graphics.drawable.Drawable;

public class Boss {
	private int health;
	private int power;
	private String name;
	private double lat;
	private double lon;
	private Drawable image;
	//= getResources().getDrawable(R.drawable.icon);
	
	public int getHealth() {
		return health;
	}

	public int getPower() {
		return power;
	}

	public String getName() {
		return name;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public Drawable getImage() {
		return image;
	}

	public Boss(String name, double lat, double lon, int hp,int pow, Drawable d){
		this.name=name;
		this.lat=lat;
		this.lon=lon;
		health=hp;
		power=pow;
		image=d;
	}
	
	
	
}
