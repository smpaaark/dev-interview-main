package me.whiteship.interview._01_array_04;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 4, 0, 3};
		System.out.println(Arrays.toString(sort(arr)));
	}

	private static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swapValue(arr, i, j);
				}
			}
		}
		
		return arr;
	}

	private static void swapValue(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}