package comp20290_Practicals.wk8_stringsearching;
import java.util.Random;


/*Java program for implementation of KMP pattern searching algorithm. The brute force algorithm doesn't 
	  * KMP improves upon this by taking advantage of prior knowledge about the text being searched.
	  */
	class KMPsearch { 
	   
		public static int KMPSearch(String txt, String pat) { 
	        int patternLength = pat.length(); 
	        int textLength = txt.length(); 
	        int j = 0; //create an index for the pattern     
	        int i = 0; //create an index for the string
	  
	        // Preprocess the pattern (calculate lps[] array) 
	        int [] lps =  computeLPSArray(pat); 
	  
	        while (i < textLength) {
	        	if (pat.charAt(j) == pat.charAt(i)) {
	        		if (j == patternLength-1) {
	        			return i-patternLength+1; //match, return the index where the pattern can be found
	        		}
	        		i++;
	        		j++; 
	        	}
	        	//mismatch after j matches
	        	else if (j> 0) {
	        		j = lps[j-1]; //number of leaps we are able to do
	        	}
	        	else {
	        		i++; 
	        	}
	        }
	        return -1; //no match
	    } 
	  
		public static int[] computeLPSArray(String pat)  { 
	    	 int patternLength = pat.length(); 
	         // create lps[] that will hold the longest prefix suffix values for pattern 
	    	 int lps[] = new int[patternLength]; 
	    	 lps[0] = 0; 
	    	 int j = 0; 
	    	 int i = 1;
	    	 
	    	 while (i< patternLength) {
	    		 if (pat.charAt(i) == pat.charAt(j)) {
	    			 lps[i] = j+1; 
	    			 i++;
	    			 j++;
	    		 }
	    		 else if (j>0) {
	    			 j = lps[j-1]; 
	    		 }
	    		 else {
	    			 lps[i] = 0; 
	    			 i++; 
	    		 }
	    	 }
	    	 return lps;  
	    } 
	  
	    // Driver program to test above function 
		 public static void main(String[] args) { 
		    	String ascii = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		         
		        String txt = generateRandomString(100000000, ascii); 
			    String pat = "ABABCABAHDEHDHREB";  
			    Stopwatch sw = new Stopwatch();
		        System.out.println(KMPSearch(txt, pat)); 
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