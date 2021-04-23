package com.sk.Algorithm;

import java.util.Arrays;

/**
 * 
 * @author Shivam Kashyap
 * 
 *
 */
public class SortingAlgorithms {

	/**
	 * Bubble Sort moves highest value to the end of array in each iteration by
	 * comparing adjacent values.
	 * 
	 * @param arr
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
	 * @param arr
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
}
