package me.whiteship.interview._01_array_03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {
	
	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
        System.out.println(Arrays.toString(threeSum.solution(new int[]{2, 3, 4, 7, 9}, 7)));
	}

	private int[] solution(int[] numbers, int target) {
		Map<Integer, Integer> numberMap = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			numberMap.put(numbers[i], i);
		}
		
		for (int i = 0; i < numbers.length - 2; i++) {
			for (int j = i + 1; j < numbers.length - 1; j++) {
				int numberToFind = target - numbers[i] - numbers[j];
				if (numberMap.containsKey(numberToFind) && numberMap.get(numberToFind) != i && numberMap.get(numberToFind) != j) {
					return new int[] {i, j, numberMap.get(numberToFind)};
				}
			}
		}
		
		return null;
	}
	
	
}
