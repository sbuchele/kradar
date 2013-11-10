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
					if(dialogue == "Send Contacts"){
						//Initiate contact transmission procedure
					}
					if(dialogue == "Next Contact"){
						//Send next contact
					}
					if(dialogue == "Sending Power"){
						waitForPower = true;
						out.println("Ready"); 
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

	}
}
