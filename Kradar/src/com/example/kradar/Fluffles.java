package com.example.kradar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

public class Fluffles implements Runnable {//Server/Client code

	public static Hats tophat = new Hats();
	private boolean canSpeak = true;
	String toSpeak = null;
	boolean sayNum = false;
	boolean sayLat = false;
	boolean sayLong = false;
	boolean sayID = false;
	boolean saidThing = false;
	boolean pokeDone = true;
	
	//public class Messenger implements Runnable{

	@Override
	 public void run() {
        boolean connected;
        int port = 8888;
        String serverIpAddress = "TUMC.dyndns-free.com";
        boolean hasStuff = false;
        String dialogue = null;
        boolean waitForPower = false;
		try {
			InetAddress serverAddr = InetAddress.getByName(serverIpAddress);
			System.out.println("DOING STUFF");
            Log.d("ClientActivity", "C: Connecting...");
            Socket socket = new Socket(serverAddr, port);
            connected = true;
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                    .getOutputStream())), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Entering Fluffles Loop");
            //out.println("testestestest");
            while (connected) {
            	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                        .getOutputStream())), true);
            	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            	try {
            		dialogue = null;
					if (saidThing) {
						dialogue = in.readLine();
						System.out.println(dialogue);
						//System.out.println("Had dialouge!");
					}
				} catch (Exception e) {
					Log.e("ClientActivity", "S: Error", e);
				}
            	if (dialogue != null){
            		hasStuff = true;
            	}
            	else hasStuff = false;
                if (hasStuff) {
                	//System.out.println("Fluffles had stuff");
                	this.speakToggleOff();
					if(dialogue.equals("Send Stuff")){
						out.println(toSpeak);
						out.flush();
						saidThing = false;
						toSpeak = null;
						pokeDone = true;
						//Initiate contact transmission procedure
					}
					else if(dialogue == "Next Contact"){
						//Send next contact
					}
					else if(dialogue == "Sending Power"){
						waitForPower = true;
						out.println("Ready"); 
						out.flush();
					}
					/*else if(dialogue == "Need long"){
						//Location Sending Procedure
					}
					else if(dialogue == "Need lat"){
						//Latitude sending procedure
					}
					else if(dialogue == "Bye bye"){
						connected = false;
					}
					else if(waitForPower){
						//set power value
					}
					else if(dialogue == "Who you?"){
						//ID procedure
					}*/
				}
                else if(!hasStuff){
                	if (!saidThing) {
						if (sayID) {
							out.println("Have ID");
							System.out.println("Error: " + out.checkError());
							out.flush();
							System.out.println("I TRIED TO SAY MAH ID!");
							saidThing = true;
							tophat.setPhone(null);
						}
						else if(sayNum){
							out.println("Have num");
							out.flush();
							saidThing = true;
							tophat.setDual(null);
						}
						else if(sayLong){
							out.println("Have long");
							out.flush();
							saidThing = true;
							tophat.setLon(-1);
						}
						else if(sayLat){
							out.println("Have lat");
							out.flush();
							saidThing = true;
							tophat.setLat(-1);
						}
					}
                }
            }
            socket.close();
            Log.d("ClientActivity", "C: Closed.");
        } catch (Exception e) {
            Log.e("ClientActivity", "C: Error", e);
            connected = false;
        }
    }
	private synchronized void speakToggleOff(){
		canSpeak = false;
	}
	public synchronized void poke(){
		System.out.println("Fluffles was poked");
		while(toSpeak != null){
			try {
				this.wait(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(tophat.getPhone() != null){
			toSpeak = tophat.getPhone();
			sayID = true;
			System.out.println("I wanna tell the server my ID");
		}
		else if(tophat.getDual() != null){
			toSpeak = tophat.getDual();
			sayNum = true;
		}
		else if(tophat.getLat() != -1){
			toSpeak = String.valueOf(tophat.getLat());
			sayLat = true;
		}
		else if(tophat.getLon() != -1){
			toSpeak = String.valueOf(tophat.getLon());
			sayLong = true;
		}
		pokeDone = false;
		while(!pokeDone){
			
		}
	}
	//}

}
