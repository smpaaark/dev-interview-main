package me.whiteship.interview._01_array_04;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 4, 0, 3};
		System.out.println(Arrays.toString(sort(arr)));
	}

	private static int[] sort(int[] arr) {
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			for (j = i - 1; j >= 0; j--) {
				if (temp >= arr[j]) {
					break;
				}
				
				arr[j + 1] = arr[j];
			}
			
			arr[j + 1] = temp;
		}
		
		return arr;
	}
	
}
