package me.whiteship.interview._01_array_04;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 4, 0, 3};
		sort(arr, arr.length);
		
		for (int i = arr.length - 1; i > 0; i--) {
			swapValue(arr, 0, i);
			
			sort(arr, i);
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int length) {
		for (int i = 1; i < length; i++) {
			int child = i;
			
			while (child > 0) {
				int parent = (child - 1) / 2;
				
				if (arr[child] > arr[parent]) {
					swapValue(arr, child, parent);
				}
				
				child = parent;
			}
		}
	}
	
	private static void swapValue(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	
}
