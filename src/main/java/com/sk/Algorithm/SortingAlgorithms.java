package com.sk.Algorithm;

import java.util.Arrays;

/**
 * 
 * @author Shivam Kashyap
 * 
 *
 */
public class SortingAlgorithms {
	private int[] bucketInsertTracker = null;
	int[][] buckets = null;
	int[] sortedArray = null;

	/**
	 * Bubble Sort moves highest value to the end of array in each iteration by
	 * comparing adjacent values.
	 * 
	 * @param arr >> unsorted input array of integers
	 */
	public void bubbleSort(int[] arr) {
		for (int index = arr.length; index > 0; index--) {
			for (int predecessor = 0, successor = 1; successor < index; predecessor++, successor++) {
				if (arr[predecessor] > arr[successor]) {
					int tmp = arr[successor];
					arr[successor] = arr[predecessor];
					arr[predecessor] = tmp;
				}
			}
		}
	}

	/**
	 * Selection sort In each iteration moves least/highest in first unsorted
	 * position in same array by comparing 1st unsorted array postion to each of
	 * array item until lowest is found and replaced.
	 * 
	 * @param arr >> unsorted input array of integers
	 */
	public void selectionSort(int[] arr) {
		for (int startIndex = 0; startIndex < arr.length - 1; startIndex++) {
			for (int nextIndex = startIndex + 1; nextIndex < arr.length; nextIndex++) {
				if (arr[startIndex] > arr[nextIndex]) {
					int tmp = arr[startIndex];
					arr[startIndex] = arr[nextIndex];
					arr[nextIndex] = tmp;
				}
			}
		}
	}

	/**
	 * insertion sort loops through the array and picks first number which is
	 * smaller than the previous number once we find a number in array which is
	 * smaller than previous we start another loop from than number until we find
	 * the place for that number by swap adjacent numbers until find the perfect
	 * location Perfect location means a[i-1] <= a[i] <= a[i+1]
	 * 
	 * @param arr >> unsorted input array of integers
	 */
	public void insertionSort(int[] arr) {
		for (int index = 0; index < arr.length - 1; index++) {
			int next = index + 1;
			while (next > 0 && arr[next] < arr[next - 1]) {

				int temp = arr[next - 1];
				arr[next - 1] = arr[next];
				arr[next] = temp;
				next--;

			}
		}
	}

	/**
	 * 
	 * @param arr >> unsorted input array of integers
	 */
	public void bucketSort(int[] arr) {
		sortedArray = new int[arr.length];

		int numberOfBuckets = (int) Math.sqrt(arr.length) + 1;
		// there can be chance that much of data goes into single bucket, so we would
		// take bucket of size arr.length-1
		buckets = new int[numberOfBuckets][arr.length];
		initBucketArray(buckets);
		bucketInsertTracker = new int[numberOfBuckets];
		int maxValue = Integer.MIN_VALUE;
		for (int value : arr) {
			if (value > maxValue) {
				maxValue = value;
			}
		}
		for (int i = 0; i < arr.length; i++) {

			int appropriateBucket = (int) Math.ceil((arr[i] * (numberOfBuckets - 1)) / maxValue);
			insertIntoBucket(appropriateBucket, arr[i]);
		}

		int sortedArrayIndex = 0;
		// sort each bucket and append
		for (int i = 0; i < buckets.length; i++) {
			int[] tmpArray = buckets[i];
			insertionSort(tmpArray);
			int index = 0;
			while (index < tmpArray.length) {
				int tmpVal = tmpArray[index];
				if (tmpVal != -2147483648) {
					sortedArray[sortedArrayIndex] = tmpVal;
					sortedArrayIndex++;
				}
				index++;

			}

		}

		arr = sortedArray;
		printArray(arr);

	}

	private void initBucketArray(int[][] buckets2) {

		for (int i = 0; i < buckets2.length; i++) {
			for (int j = 0; j < buckets2[i].length; j++) {
				buckets2[i][j] = Integer.MIN_VALUE;

			}

		}
	}

	private void insertIntoBucket(int appropriateBucket, int value) {

		int trackerValue = bucketInsertTracker[appropriateBucket];
		buckets[appropriateBucket][trackerValue] = value;
		bucketInsertTracker[appropriateBucket] = trackerValue + 1;
	}

	/**
	 * prints the array on console dev method to test our code
	 * 
	 * @param arr
	 */
	void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(" " + i);
		}
	}

	/**
	 * 
	 * @param arr
	 */
	void mergeSort(int[] arr) {
		int lengthOfArr = arr.length;
		if (lengthOfArr < 2) {
			return;
		}
		int mid = lengthOfArr / 2;
		// create and populate left array
		int[] leftArr = new int[mid];
		for (int i = 0; i < mid; i++) {
			leftArr[i] = arr[i];
		}
		// create and populate right array
		int[] rightArr = new int[lengthOfArr - mid];
		for (int i = mid; i < lengthOfArr; i++) {
			rightArr[i - mid] = arr[i];
		}
		mergeSort(leftArr);
		mergeSort(rightArr);
		merge(leftArr,rightArr,arr);

	}
	
	/**
	 * 
	 * @param leftArr
	 * @param rightArr
	 * @param arr
	 */
	void merge(int[] leftArr,int[] rightArr,int[] arr) {
		
		int lenLeft = leftArr.length;
		int lenRight = rightArr.length;
		
		int i=0, j = 0,k = 0;
		
		while(i < lenLeft && j < lenRight) {
			
			if(leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			}else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while(i< lenLeft) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while(j < lenRight) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
		
	}

}
























