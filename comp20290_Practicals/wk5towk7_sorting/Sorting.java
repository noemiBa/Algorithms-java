package comp20290_Practicals.wk5towk7_sorting;
import java.util.Arrays;
import java.util.Random;


public class Sorting {
	public static final int CUTOFF = 10;
	
	public static void main(String[] args) {
		//Testing code
		int n = 10; 
//		int [] array = createRandomArray(n);
//		Stopwatch sw = new Stopwatch(); 
//		selectionSort(array);
//	    System.out.println("Selection sort for: " + n + " elements, took " + sw.elapsedTime());
//		printArray(array);
//		
//		int [] array3 = createRandomArray(n);
//		Stopwatch sw1 = new Stopwatch(); 
//		StalinSort(array3);
//		System.out.println("Stalin sort for: " + n + " elements, took " + sw1.elapsedTime());
//		printArray(array3);

//		int [] array2 = createRandomArray(n);
//		Stopwatch sw2 = new Stopwatch(); 
//		insertionSort(array2);
//		System.out.println("Insertion sort for: " + n + " elements, took " + sw2.elapsedTime());
//		printArray(array2);
//
//		int [] array4 = createRandomArray(n);
//		Stopwatch sw3 = new Stopwatch(); 
//		mergeSort(array4);
//		System.out.println("Merge sort for: " + n + " elements, took " + sw3.elapsedTime());
//		printArray(array4);
//		
//		int [] array5 = createRandomArray(n);
//		Stopwatch sw4 = new Stopwatch(); 
//		mergeSortEnhanced(array5);
//		System.out.println("Merge sort enhanced for: " + n + " elements, took " + sw4.elapsedTime());
//		printArray(array5);
		
		int [] array6 = createRandomArray(n);
		Stopwatch sw5 = new Stopwatch(); 
		quickSort(array6, 0, array6.length-1);
		System.out.println("Quick Sort for: " + n + " elements, took " + sw5.elapsedTime());
		printArray(array6);
		
		int [] array7 = createRandomArray(n);
		Stopwatch sw6 = new Stopwatch(); 
		quickSort(array7, 0, array6.length-1);
		System.out.println("Quick Sort Enhanced for: " + n + " elements, took " + sw6.elapsedTime());
		printArray(array7);

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

	/* Merge Sort is an efficient sorting algorithm which uses a divide and conquer sorting strategy. Merge sort splits the array in the middle, 
	 * recursively sorts each half and then merges the two sorted parts together. In this enhanced version, a cutoff for smaller sub-arrays has been added as well
	 * as testing whether the array is already in order.
	 * 
	 * @param array: the array to be sorted
	 * @return the sorted array.
	 */
	public static void mergeSortEnhanced(int [] array) {
		int length = array.length; 
		int midpoint = length/2;

		//base case
		if (length == 1) { return; }

		int [] left = new int [midpoint];
		int [] right = new int [length-midpoint];

		if (left.length <= CUTOFF || right.length <= CUTOFF) { //enhancement
			insertionSort(left);
			insertionSort(right);
		}
		else if (array[midpoint] <= array[midpoint+1]){} //just skip to the merge part
		else {
			//copy the first half of the array into the left sub-array
			for (int i = 0; i < midpoint; i++) {
				left[i] = array[i];
			}

			//copy the second half of the array into the left sub-array
			for (int i = 0; i < right.length; i++) {
				right[i] = array[midpoint+i];
			}

			//create left and right sub-arrays
			mergeSort(left);
			mergeSort(right);
		}

		merge(left, right, array); 
	}
	
	/* Quick Sort is an efficient sorting algorithm which uses a divide and conquer sorting strategy. The input list is divided into two sub-lists by an element called pivot; one sub-list with elements less than the pivot and 
	 * another one with elements greater than the pivot. This process repeats for each sub-list. 
	 * 
	 * @param array: the array to be sorted
	 * @return the sorted array.
	 */
	public static void quickSort(int array[], int startIndex, int endIndex) {
	    //base case for the recursive function
		if (startIndex < endIndex) {
			//find the pivot using the partition method
	        int pivot = partition(array, startIndex, endIndex);
	        
	        //sort recursively to the left of the pivot
	        quickSort(array, startIndex, pivot-1);
	        //sort recursively to the right of the pivot
	        quickSort(array, pivot+1, endIndex);
	    }
	}
	
	/*Private helper method partition partions the array so that the elements smaller than the pivot are found to the left of the pivot,
	 * while the elements greater than the pivot will be found to the right of it.
	 */
	private static int partition(int array[], int startIndex, int endIndex) {
	    int pivot = array[endIndex]; //by convention the pivot is chosen as the last element of the array 
	    int i = (startIndex-1);

	    for (int j = startIndex; j < endIndex; j++) {
	        if (array[j] <= pivot) {
	            //increment the smallest index
	        	i++;
	            
	            //swap array[i] and array[j]
	            int swapTemp = array[i];
	            array[i] = array[j];
	            array[j] = swapTemp;
	        }
	    }

	    int swapTemp = array[i+1];
	    array[i+1] = array[endIndex];
	    array[endIndex] = swapTemp;

	    return i+1;
	}
	
	/* Quick Sort is an efficient sorting algorithm which uses a divide and conquer sorting strategy. The input list is divided into two sub-lists by an element called pivot; one sub-list with elements less than the pivot and 
	 * another one with elements greater than the pivot. This process repeats for each sub-list. In this enhanced version, a cutoff for smaller sub-arrays has been added as well
	 * as random shuffling of the array
	 * 
	 * @param array: the array to be sorted
	 * @return the sorted array.
	 */
	public static void quickSortEnhanced(int array[], int startIndex, int endIndex) {
		//check the length of the array. if it is less than the predefined cutoff, use insertion sort instead. 
		if (array.length < CUTOFF) { //enhancement
			insertionSort(array);
			return; 
		}
	    
		//random shuffling of the array ensure that worst case performance is unlikely
		KnuthShuffle.shuffle(array);
		
		//base case for the recursive function
		if (startIndex < endIndex) {
			//find the pivot using the partition method
	        int pivot = partitionEnhanced(array, startIndex, endIndex);
	        
	        //sort recursively to the left of the pivot
	        quickSortEnhanced(array, startIndex, pivot-1);
	        //sort recursively to the right of the pivot
	        quickSortEnhanced(array, pivot+1, endIndex);
	    }
	}

	/*Private helper method partition partions the array so that the elements smaller than the pivot are found to the left of the pivot,
	 * while the elements greater than the pivot will be found to the right of it. Choosing a pivot where the value is near the middle or exactly the middle will 
	 * allow the algorithm to perform better..
	 */
	private static int partitionEnhanced(int array[], int startIndex, int endIndex) {
		int median = medianOf3(array, startIndex, startIndex + (startIndex-endIndex), endIndex);
	    int pivot = median; 
	    int i = (startIndex-1);

	    for (int j = startIndex; j < endIndex; j++) {
	        if (array[j] <= pivot) {
	            //increment the smallest index
	        	i++;
	            
	            //swap array[i] and array[j]
	            int swapTemp = array[i];
	            array[i] = array[j];
	            array[j] = swapTemp;
	        }
	    }

	    int swapTemp = array[i+1];
	    array[i+1] = array[endIndex];
	    array[endIndex] = swapTemp;

	    return i+1;
	}

	
	/* Private function finds the median of 3 elements in an array. The first element will be returned only when the second element is bigger than the first, which is bigger than the last or
	 * the third element is bigger than the first which is bigger than the second.
	 * 
	 */
	private static int medianOf3(int[] array, int startIndex, int midIndex, int endIndex) {
		if ((array[midIndex] - array[startIndex]) * (array[endIndex] - array[startIndex]) < 0) {
			return array[startIndex];
		}
		else if ((array[startIndex] - array[midIndex]) * (array[endIndex] - array[midIndex]) < 0) {
			return array[midIndex]; 
		}
		else if ((array[startIndex] - array[endIndex]) * (array[midIndex] - array[endIndex]) < 0) {
			return array[endIndex]; 
		}
		return array[midIndex];
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
