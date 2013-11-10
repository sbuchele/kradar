package com.example.kradar;

public class Hats 
{
	boolean namer;
	int damage;
	String name;
	int distance;
	String phone;
	
	public Hats()
	{	
		namer = false;
		damage = -1;
		name = "-1";
		distance = -1;
		phone = "-1";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
