package com.sk.Algorithm;

import java.util.Arrays;

public class BubbleSort {

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
		
		int index = -1;
		while(++index < arr.length) {
			System.out.print(" " + arr[index]);
			
		}

	}
}
