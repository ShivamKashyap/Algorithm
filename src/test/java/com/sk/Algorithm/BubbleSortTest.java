package com.sk.Algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

	@Test
	void testBubbleSort() {

		BubbleSort bSort = new BubbleSort();
		int arr[] = { 30, 10, 50, 20, 60, 40 };
		int result[] = { 10, 20, 30, 40, 50, 60 };
		bSort.bubbleSort(arr);
		assertArrayEquals(result, arr);
	}

}
