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

public class Fluffles extends Activity {//Server/Client code

	public Hats tophat = new Hats();
	private boolean canSpeak = true;
	String toSpeak = null;
	boolean sayNum = false;
	boolean sayLat = false;
	boolean sayLong = false;
	boolean sayID = false;
	boolean saidThing = false;
	
	public class Messenger implements Runnable{

	@Override
	 public void run() {
        boolean connected;
        int port = 0;
        String serverIpAddress = null;
        boolean hasStuff = false;
        String dialogue = null;
        boolean waitForPower = false;
		try {
			InetAddress serverAddr = InetAddress.getByName(serverIpAddress);
            Log.d("ClientActivity", "C: Connecting...");
            Socket socket = new Socket(serverAddr, port);
            connected = true;
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                    .getOutputStream())), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (connected) {
            	wait(500);
            	try {
					dialogue = in.readLine();
				} catch (Exception e) {
					Log.e("ClientActivity", "S: Error", e);
				}
            	if (dialogue != null){
            		hasStuff = true;
            	}
            	else hasStuff = false;
                if (hasStuff) {
                	this.speakToggleOff();
					if(dialogue == "Send Stuff"){
						out.println(toSpeak);
						out.flush();
						saidThing = false;
						toSpeak = null;
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
							out.flush();
							saidThing = true;
						}
						else if(sayNum){
							out.println("Have num");
							out.flush();
							saidThing = true;
						}
						else if(sayLong){
							out.println("Have long");
							out.flush();
							saidThing = true;
						}
						else if(sayLat){
							out.println("Have lat");
							out.flush();
							saidThing = true;
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
	}
	}
}
