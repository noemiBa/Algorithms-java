import java.math.BigInteger;

/* A class implementing the Russian Peasant algorithm for multiplication
 * 
 * @Author: NoemiBa 
 */
public class RussianPeasant {

	private BigInteger number1; 
	private BigInteger number2; 

	public RussianPeasant(BigInteger number1, BigInteger number2) {
		this.number1 = number1; 
		this.number2 = number2; 
	}

	public static void main(String[] args) {
		RussianPeasant rp = new RussianPeasant(new BigInteger("1"), new BigInteger("10"));
		Stopwatch sw = new Stopwatch(); 
		BigInteger result = rp.multiply(); 
		System.out.println(sw.elapsedTime());
		System.out.println(result);

	}

	/* This method multiplies two integers using the Russian Peasant algorithm
	 * 
	 * @Return the result of the multiplication.
	 */
	public BigInteger multiply() {
		BigInteger result = BigInteger.ZERO; 

		while (number2.signum() == 1) { //while the second integer is still returns a positive sign...
			
			if (isOdd(number2)) { //if said integer is odd...
				result = result.add(number1); //add integer1 to the result
			}
			number2 = number2.divide(BigInteger.TWO); 
			number1 = number1.multiply(BigInteger.TWO); 
		}

		return result; 
	}
	
	public boolean isOdd(BigInteger number) {
	    if(!number.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
	        return true;
	    }
	    return false;
	}
}

