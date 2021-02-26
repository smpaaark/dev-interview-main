package me.whiteship.interview._03_stack_04;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        System.out.println(Arrays.toString(nge.solution2(new int[]{1, 1, 2, 3})));
        System.out.println(Arrays.toString(nge.solution2(new int[]{10, 4, 2, 30})));
        System.out.println(Arrays.toString(nge.solution2(new int[]{82, 7, 15})));
    }

    private int[] solution2(int[] numbers) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[numbers.length];
		stack.push(numbers.length - 1);
		result[numbers.length - 1] = -1;
		
		for (int i = numbers.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && numbers[stack.peek()] <= numbers[i]) {
				stack.pop();
			}
			
			result[i] = stack.isEmpty() ? -1 : numbers[stack.peek()];
			stack.push(i);
		}
		
		return result;
	}

	/**
     * TODO 주어진 배열의 오른쪽에 처음으로 등장하는 현재 숫자보다 큰 수를 담고 있는 배열을 만드는 코드를 작성하라.
     *  예) [1, 1, 2, 3]   =>   [2, 2, 3, -1]
     *  예) [10, 4, 2, 30]   =>  [30, 30, 30, -1]
     *  예) [82, 7, 15]   =>  [-1, 15, -1]
     * @param numbers
     * @return
     */
    private int[] solution(int[] numbers) {
    	Stack<Integer> stack = new Stack<>();
    	int[] result = new int[numbers.length];
    	for (int i = numbers.length - 1; i >= 0; i--) {
    		stack.push(numbers[i]);
    	}
    	
    	for (int i = 0; i < numbers.length; i++) {
    		int temp = 0;;
    		while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
    			temp = stack.pop();
    		}
    		
    		result[i] = !stack.isEmpty() ? stack.peek() : -1; 
    		if (stack.isEmpty()) {
    			stack.push(temp);
    		}
    	}
    	
        return result;
    }
}
