package open.eg.worknote.util;

import java.util.Random;

public class hexrandom { 
	public static void main(String[] args) { 
		hexrandom hex = new hexrandom(); 
		System.out.println("random_hex : "+ hex.getRandomHexString(3));
		System.out.println("random_int : " + hex.getRandomString(10));
	} 
	
	public static String getRandomHexString(int numchars){
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		while(sb.length() < numchars){ 
			sb.append(Integer.toHexString(r.nextInt()));
		} 
		
		return sb.toString().substring(0, numchars);
	} 
	public static String getRandomString(int numchars){ 
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		while(sb.length() < numchars){
			sb.append(Integer.toUnsignedString(r.nextInt()));
		} 
		return sb.toString().substring(0, numchars); 
	} 
}

