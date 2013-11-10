package com.example.kradar;

public class Hats 
{

	private boolean namer;
	private int damage;
	private String phone;
	private int distance;
	private String dual;
	private double lat;
	private double lon;
	private double [] dist;
	private boolean getPower;
	private int powerLevel = 0;
	
	public Hats()
	{	
		
		namer = false;
		damage = -1;
		dual = null;
		distance = -1;
		phone = null;
	}

	public synchronized boolean isNamer() {
		return namer;
	}

	public synchronized void setNamer(boolean namer) {
		this.namer = namer;
	}

	public synchronized int getDamage() {
		return damage;
	}

	public synchronized void setDamage(int damage) {
		this.damage = damage;
	}

	
	public synchronized int getDistance() {
		return distance;
	}

	public synchronized void setDistance(int distance) {
		this.distance = distance;
	}

	public synchronized String getDual() {
		return dual;
	}

	public synchronized void setDual(String dual) {
		this.dual = dual;
	}

	public synchronized double getLat() {
		return lat;
	}

	public synchronized void setLat(double lat) {
		this.lat = lat;
	}

	public synchronized double getLon() {
		return lon;
	}

	public synchronized void setLon(double lon) {
		this.lon = lon;
	}

	public synchronized double[] getDist() {
		return dist;
	}

	public synchronized void setDist(double[] dist) {
		this.dist = dist;
	}

	public synchronized String getPhone() {
		return phone;
	}
	public synchronized void setPhone(String phone){
		this.phone = phone;
	}
	public synchronized void getPower(){
		this.getPower = true;
	}
	public synchronized void noPower(){
		this.getPower = false;
	}
	public synchronized boolean wantPower(){
		return this.getPower;
	}
	public synchronized int powerLevel(){
		return this.powerLevel();
	}
	public synchronized void setPower(int p){
		this.powerLevel = p;
	}

}
