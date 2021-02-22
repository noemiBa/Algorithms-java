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
		int n = 30; 
		int [] array = createRandomArray(n);
		
		selectionSort(array);
		
		printArray(array);
		
		int [] array2 = createRandomArray(n);
		
		insertionSort(array2);
		
		printArray(array2);
		
		int [] array3 = createRandomArray(n);
		
		StalinSort(array3);
	
		printArray(array3);
		
		int [] array4 = createRandomArray(n);
		mergeSort(array4);
		printArray(array4);
		
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
			int temp  = array[i];
			int j = i-1; 
			while (j >= 0 && array[j] > temp) {
				array[j+1] = array[j];
				j--; 
			}
			array[j+1]= temp; 
		}
	}
	
	/*The Stalin Sort is a joke sort in which elements that are out of order get removed from a list.
	 * 
	 * @param array: the array to be sorted
	 */
	public static void StalinSort(int [] array) {
		int i = 0; 
		
		for (int j = 1; j <array.length; j++) {
			if (array[i] > array[j]) {
				array[i] = 0; 
			}
			
			i++; 
		}
		
		/*
		 * int bigger = 0; int j = 0; int [] arraySorted = new int [array.length];
		 * 
		 * for (int i = 0; i<array.length; i++) { if (array[i] > 0) { bigger = array[i];
		 * arraySorted[j] = array[i]; j++; } } array = arraySorted;
		 */
	}
	
	/* Merge Sort is an efficient sorting algorithm which uses a divide and conquer sorting strategy. Merge sort splits the array in the middle, 
	 * recursively sorts each half and then merges the two sorted parts together. 
	 * 
	 * @param array: the array to be sorted
	 * @return the sorted array.
	 */
	public static void mergeSort(int [] array) {
	     int length = array.length; 
	     int midpoint = length/2;
	     
	     //base case
	     if (length == 1) { return; }
	     
	     int [] left = new int [midpoint];
	     
	     //copy the first half of the array into the left sub-array
	     for (int i = 0; i < midpoint; i++) {
	    	 left[i] = array[i];
	     }
	     
	     int [] right = new int [length-midpoint];
	     
	     //copy the second half of the array into the left sub-array
	     for (int i = 0; i < right.length; i++) {
	    	 right[i] = array[midpoint+i];
	     }
	     
	     //create left and right sub-arrays
	     mergeSort(left);
	     mergeSort(right);
	     
	     merge(left, right, array); 
	}
	
	/* Private helper method. Merges two sorted arrays and returns a single array. 
	 * 
	 * @param left, the first sorted array.
	 * @param right, the second sorted array.
	 * @param array, the initial array.
	 */
	private static void merge(int[] left, int[] right, int[] array) {
		int indexLeft = 0; //next element in the left sub-array
		int indexRight = 0; //next element in the right sub=array
		int j = 0;  //next open position in the array
		
		while (indexLeft < left.length && indexRight < right.length) {
			if (left[indexLeft] < right[indexRight]) {
				array[j] = left[indexLeft]; 
				indexLeft++;
			}
			else {
				array[j] = right[indexRight];
				indexRight++; 
			}
			j++; 
		}
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
	         array[i] = rand.nextInt(100); 
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
