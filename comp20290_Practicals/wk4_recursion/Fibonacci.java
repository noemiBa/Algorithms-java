/* The Fibonacci sequence is a a sequence of integers in which the first two elements are 0 and 1, 
 * and each following element is the sum of the two preceding numbers. 
 * This class implements both a recursive solution and an iterative solution
 * to return the number found in the fibonacci sequence at position n.
 */
public class Fibonacci {
	
	/* This method finds the Fibonacci number at position n iteratively.
	 * 
	 * @param: n - the position of the element
	 * @return the fibonacci number
	 */
	static int fibonacciIterative(int n){
		if (n<=1)
			return 1 ;

		int fib = 1;
		int prevFib =  1;

		for (int i = 2; i < n; i++) {
			int temp = fib;
			fib = fib + prevFib;
			prevFib = temp;
		}
		return fib;
	}
	
	/* This method finds the Fibonacci number at position n recursively.
	 * 
	 * @param: n - the position of the element
	 * @return the Fibonacci number
	 */
	static int fibonacciRecursive(int n) {
		if (n == 0) {
			return 0; 
		}
		if (n == 1) {
			return 1; 
		}
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
	}


	public static void main (String args[])  { 
		int n = 9; 
		System.out.println(fibonacciIterative(n)); 
		System.out.println(fibonacciRecursive(n));
	} 

}
