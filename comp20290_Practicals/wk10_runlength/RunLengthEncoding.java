package comp20290_Practicals.wk10_runlength;
import java.util.Scanner; 

public class RunLengthEncoding {
	
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string");
		String string = scan.next(); 
		String compressed = compress(string);
		System.out.println("The compressed string is: " + compressed);
	}
	
	public static String compress(String string) {
        String compressedString = "";
        int count = 1;

        for (int i = 0; i<string.length(); i++) {
            char currentChar = string.charAt(i);
           
            if (i+1 >= string.length()){
            	compressedString = compressedString + currentChar + count;
                break;
            }

            char followingChar = string.charAt(i+1);

            if (currentChar != ' ') { //do not count the spaces
                if (currentChar == followingChar) {
                    count++;
                }
                else {
                    compressedString = compressedString + currentChar + count;
                    System.out.println(compressedString);
                    count = 1;
                }
            }
        }
        return compressedString;
    }
}
