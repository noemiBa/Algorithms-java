package comp20290_Practicals.wk8_stringsearching;
import java.util.Random;

import Stopwatch;

//Java program for Naive Pattern Searching 

public class BruteForceSearch {
	  	
	    /* The brute force algorithm works by starting at the beginning of the string and compares each character of the pattern 
	     * against the subsequent characters in the string. 
	     * 
	     * @input: String txt, the given string to be searched. String pattern, the pattern to be found.
	     * @return: the index where the first character of the pattern can be found, or -1 if no match was found.
	     */
	    public static int search(String txt, String pat)  { 
	       int textLength = txt.length(); 
	       int patternLength = pat.length(); 
	       int i, j;  
	       
	       for (i  = 0; i < (textLength - patternLength); i++) {
	    	   //check and compare each character, one by one.
	    	   for (j = 0; j < patternLength; j++) {
	    		   if (txt.charAt(i+j) != pat.charAt(j)) {
	    			   break; //if any one character does not match the pattern, move on to the next index.
	    		   }
	    		   
	    	   }
	    	 //if the entire pattern was matched, return the index.
    		   if (j == patternLength) {
    			   return i; 
    		   }
	       }
	       
	       return -1; //no match was found. 
	    } 
	  
	    public static void main(String[] args) { 
	    	String ascii = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	         
	        String txt = generateRandomString(100000000, ascii); 
		    String pat = "ABABCABAHDEHDHREB";  
		    Stopwatch sw = new Stopwatch();
	        System.out.println(search(txt, pat)); 
	        System.out.println(sw.elapsedTime());
	    } 
	    
	    private static String generateRandomString(long length, String seedChars) {
	        StringBuilder sb = new StringBuilder();
	        int i = 0;
	        Random rand = new Random();
	        while (i < length) {
	            sb.append(seedChars.charAt(rand.nextInt(seedChars.length())));
	            i++;
	        }
	        return sb.toString();
	    }
	} 
