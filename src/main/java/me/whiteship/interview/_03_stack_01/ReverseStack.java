package me.whiteship.interview._03_stack_01;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);

        System.out.println(numbers);
        ReverseStack reverseStack = new ReverseStack();
//        Stack<Integer> reversed = reverseStack.solution(numbers);
//        System.out.println(reversed);
        reverseStack.solution3(numbers);
        System.out.println(numbers);
    }

    private void solution3(Stack<Integer> stack) {
    	if (stack.isEmpty()) {
    		return;
    	}
    	
    	int temp = stack.pop();
    	solution3(stack);
    	insertAtBottom2(stack, temp);
	}

	private void insertAtBottom2(Stack<Integer> stack, int number) {
		if (stack.isEmpty()) {
			stack.push(number);
		} else {
			int temp = stack.pop();
			insertAtBottom2(stack, number);
			stack.push(temp);
		}
	}

	private void solution2(Stack<Integer> stack) {
    	if (stack.isEmpty()) {
    		return;
    	}
    	
    	int temp = stack.pop();
    	solution2(stack);
    	insertAtBottom(stack, temp);
	}
    
    private void insertAtBottom(Stack<Integer> stack, int number) {
    	if (stack.isEmpty()) {
    		stack.push(number);
    	} else {
    		int temp = stack.pop();
    		insertAtBottom(stack, number);
    		stack.push(temp);
    	}
    }


	// TODO 스택을 뒤집는 코드를 작성하라.
    private Stack<Integer> solution(Stack<Integer> stack) {
    	Stack<Integer> reverse = new Stack<>();
    	while (!stack.isEmpty()) {
    		reverse.push(stack.pop());
    	}
    	
    	return reverse;
    }

}
