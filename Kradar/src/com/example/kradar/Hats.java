package com.example.kradar;

public class Hats 
{

	boolean namer;
	int damage;
	final String phone;
	int distance;
	String dual;
	double lat;
	double lon;
	double [] dist;
	
	public Hats()
	{	
		
		namer = false;
		damage = -1;
		dual = null;
		distance = -1;
		phone = null;
	}

	public boolean isNamer() {
		return namer;
	}

	public void setNamer(boolean namer) {
		this.namer = namer;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getDual() {
		return dual;
	}

	public void setDual(String dual) {
		this.dual = dual;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double[] getDist() {
		return dist;
	}

	public void setDist(double[] dist) {
		this.dist = dist;
	}

	public String getPhone() {
		return phone;
	}



}
