import java.util.Random;
/* A basic class that implements some basic sorting algorithms i.e. selection Sort and insertion Sort. 
 * In addition to that, a joke sorting algorithm, the Stalin Sort, was also implemented. 
 * Methods to create a random array and to print an array are also present. 
 * 
 * @Author: NoemiBa
 */
public class ElementarySorting {
	
	public static void main(String[] args) {
		//Testing code
		int n = 100000; 
		int [] array = createRandomArray(n);
		Stopwatch s1 = new Stopwatch(); 
		selectionSort(array);
		System.out.println("Selection sort for " + n + " items, time elapsed: " + s1.elapsedTime());
		printArray(array);
		
		int [] array2 = createRandomArray(n);
		Stopwatch s2 = new Stopwatch(); 
		insertionSort(array2);
		System.out.println("Insertion sort for " + n + " items, time elapsed: " + s2.elapsedTime());
		printArray(array2);
		
		int [] array3 = createRandomArray(n);
		Stopwatch s3 = new Stopwatch(); 
		insertionSort(array3);
		System.out.println("Stalin sort for " + n + " items, time elapsed: " + s3.elapsedTime());
		printArray(array3);
	}
	
	/* The function uses the selection sort algorithm in order to sort a given array. Selection sort loops over indices in the array; 
	 * for each index, selection sort calls indexOfMinimum and swap. It is an in place, comparison sorting algorithm.
	 * 
	 * @param array: the integer array to be sorted 
	 */
	public static void selectionSort(int [] array) {
		int temp; 
		int min_index; 
		
		for (int i=0; i<array.length-1; i++) {
			min_index = i; 
			
			for (int j = i+1; j<array.length;j++) {
				if (array[min_index] > array[j]) {
					min_index = j;
				}
			}
			
			//Swap the found minimum element with the first element 
			temp = array[i]; 
			array[i] = array[min_index];
			array[min_index] = temp; 
		}
	
	}
	
	/* The function uses the insertion sort algorithm in order to sort a given array. Insertion sort is a sorting mechanism where the 
	 * sorted array is built having one item at a time. The array elements are compared with each other sequentially and swapped if necessary.
	 * 
	 * @param array: the integer array to be sorted 
	 */
	public static void insertionSort(int [] array) {
		int n = array.length;
		
		for (int i=0; i<n; i++) {
			for (int j=i; j>0; j--) {
				if (array[j] < array[j-1]) {
					swap(array, array[j], array[j-1]);
				}
				else {
					break;
				}
			}
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = j;
		j = i;
		i = temp; 	
	}
	
	/*The Stalin Sort is a joke sort in which elements that are out of order get removed from a list.
	 * 
	 * @param array: the array to be sorted
	 */
	public static void StalinSort(int [] array) {
	     int bigger = 0; 
	     int j = 0; 
	     int [] arraySorted = new int [array.length];
	     
		 for (int i = 0; i<array.length; i++) {
			 if (array[i] > 0) {
				 bigger = array[i]; 
				 arraySorted[j] = array[i];
				 j++; 
			 }
		 }
		array = arraySorted;  
	}
	
	/* Private function that takes a specified size and returns a randomly filled array of integers that size.
	 * 
	 * @param size: the size of the array
	 * @return the randomly filled integer array
	 */
	private static int [] createRandomArray(int size) {
		Random rand = new Random(); 
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
	         array[i] = rand.nextInt(); 
	    }
		return array; 
	}
	
	/* Private function to print an array. 
	 * 
	 */
	private static void printArray(int [] array) {
		String output = "["; 
		for (int element : array) {
			output += element + ", ";
		}
		output = output.substring(0, output.length()-2) + "]";
		System.out.println(output);
	}
}
