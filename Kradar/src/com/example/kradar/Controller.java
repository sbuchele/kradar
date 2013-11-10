package com.example.kradar;

/**
 * Main program flow logic
 */
public class Controller {
	
	/*public static String serviceDataToString(int person, int distance, int time){
		

	}/*/
	
	
	
	public static String toBase32(int num10){
		String res10="";
		int temp=num10;
		for(int x=0;x<=(Math.log(num10)/Math.log(32));x++)
		{
			switch(temp%32)
			{
				case 0:res10="0"+res10; break;
				case 1:res10="1"+res10; break;
				case 2:res10="2"+res10; break;
				case 3:res10="3"+res10; break;
				case 4:res10="4"+res10; break;
				case 5:res10="5"+res10; break;
				case 6:res10="6"+res10; break;
				case 7:res10="7"+res10; break;
				case 8:res10="8"+res10; break;
				case 9:res10="9"+res10; break;
				case 10:res10="A"+res10; break;
				case 11:res10="B"+res10; break;
				case 12:res10="C"+res10; break;
				case 13:res10="D"+res10; break;
				case 14:res10="E"+res10; break;
				case 15:res10="F"+res10; break;
				case 16:res10="G"+res10; break;
				case 17:res10="H"+res10; break;
				case 18:res10="I"+res10; break;
				case 19:res10="J"+res10; break;
				case 20:res10="K"+res10; break;
				case 21:res10="L"+res10; break;
				case 22:res10="M"+res10; break;
				case 23:res10="N"+res10; break;
				case 24:res10="O"+res10; break;
				case 25:res10="P"+res10; break;
				case 26:res10="Q"+res10; break;
				case 27:res10="R"+res10; break;
				case 28:res10="S"+res10; break;
				case 29:res10="T"+res10; break;
				case 30:res10="U"+res10; break;
				case 31:res10="V"+res10; break;
				case 32:res10="W"+res10; break;
				
			}
			temp-=temp%32;
			temp/=32;
		}
		return res10;
	}
	
	public static int fromBase32(String num){
		int result=0;
		for(int x=0; x<num.length(); x++)
		{
			switch(num.charAt(x))
			{
				case'1':result+=1*Math.pow(10,(num.length()-x-1)) ;break;
				case'2':result+=2*Math.pow(10,(num.length()-x-1)) ;break;
				case'3':result+=3*Math.pow(10,(num.length()-x-1)) ;break;
				case'4':result+=4*Math.pow(10,(num.length()-x-1)) ;break;
				case'5':result+=5*Math.pow(10,(num.length()-x-1)) ;break;
				case'6':result+=6*Math.pow(10,(num.length()-x-1)) ;break;
				case'7':result+=7*Math.pow(10,(num.length()-x-1)) ;break;
				case'8':result+=8*Math.pow(10,(num.length()-x-1)) ;break;
				case'9':result+=9*Math.pow(10,(num.length()-x-1)) ;break;
				case'A':result+=10*Math.pow(10,(num.length()-x-1)) ;break;
				case'B':result+=11*Math.pow(10,(num.length()-x-1)) ;break;
				case'C':result+=12*Math.pow(10,(num.length()-x-1)) ;break;
				case'D':result+=13*Math.pow(10,(num.length()-x-1)) ;break;
				case'E':result+=14*Math.pow(10,(num.length()-x-1)) ;break;
				case'F':result+=15*Math.pow(10,(num.length()-x-1)) ;break;
				case'G':result+=16*Math.pow(10,(num.length()-x-1)) ;break;
				case'H':result+=17*Math.pow(10,(num.length()-x-1)) ;break;
				case'I':result+=18*Math.pow(10,(num.length()-x-1)) ;break;
				case'J':result+=19*Math.pow(10,(num.length()-x-1)) ;break;
				case'K':result+=20*Math.pow(10,(num.length()-x-1)) ;break;
				case'L':result+=21*Math.pow(10,(num.length()-x-1)) ;break;
				case'M':result+=22*Math.pow(10,(num.length()-x-1)) ;break;
				case'N':result+=23*Math.pow(10,(num.length()-x-1)) ;break;
				case'O':result+=24*Math.pow(10,(num.length()-x-1)) ;break;
				case'P':result+=25*Math.pow(10,(num.length()-x-1)) ;break;
				case'Q':result+=26*Math.pow(10,(num.length()-x-1)) ;break;
				case'R':result+=27*Math.pow(10,(num.length()-x-1)) ;break;
				case'S':result+=28*Math.pow(10,(num.length()-x-1)) ;break;
				case'T':result+=29*Math.pow(10,(num.length()-x-1)) ;break;
				case'U':result+=30*Math.pow(10,(num.length()-x-1)) ;break;
				case'V':result+=31*Math.pow(10,(num.length()-x-1)) ;break;
				case'W':result+=32*Math.pow(10,(num.length()-x-1)) ;break;
			}
		}
		return result;
		
	}
	
	
}