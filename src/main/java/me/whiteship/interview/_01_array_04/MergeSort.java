package me.whiteship.interview._01_array_04;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {2, 1, 4, 0, 3};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merge(arr, start, end);
		}
	}

	private static void merge(int[] arr, int start, int end) {
		int[] temp = new int[end - start + 1];
		
		int mid = (start + end) / 2;
		int s = start;
		int e = mid + 1;
		int tIndex = 0;
		
		while (s <= mid && e <= end) {
			if (arr[e] < arr[s]) {
				temp[tIndex++] = arr[e++];
			} else {
				temp[tIndex++] = arr[s++];
			}
		}
		
		while (s <= mid) {
			temp[tIndex++] = arr[s++];
		}
		
		while (e <= end) {
			temp[tIndex++] = arr[e++];
		}

		System.arraycopy(temp, 0, arr, start, temp.length);
	}
	
}
