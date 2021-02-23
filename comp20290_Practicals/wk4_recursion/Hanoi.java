package comp20290_Practicals.wk4_recursion;

/* This class recursively prints out the steps required to solve the tower of Hanoi
 * for a given n number of disks.
 */
public class Hanoi {

	public static void main(String[] args) {
		int n = 23; 
		Stopwatch sw = new Stopwatch();
		towersOfHanoi(n, "A", "C", "B");
		System.out.println("The time elapsed using " + n + " disks is: " + sw.elapsedTime());
	}
	
	public static void towersOfHanoi(int disk, String source, String dest, String auxiliary) {
		
		if (disk == 1) {
			System.out.println("Move disk 1 from " + source + " to " + dest);
		}
		else {
			towersOfHanoi(disk-1, source, auxiliary, dest);
			System.out.println("Move disk " + disk + " from " +  source + " to " + dest);
			towersOfHanoi(disk-1, auxiliary, dest, source);
		}
	}	
}
