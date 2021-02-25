package me.whiteship.interview._03_stack_03;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        String postfix = infixToPostfix.convert("(1+2)*3");
        System.out.println(postfix.equals("12+3*"));
        System.out.println(infixToPostfix.convert("1+2*3").equals("123*+"));
    }

    private int precedence (char c) {
    	if (c == '+' || c == '/') {
    		return 1;
    	} else if (c == '*' || c == '/') {
    		return 2;
    	} else {
    		return 0;
    	}
    }
    
    /**
     * TODO 인픽스를 포스트픽스로 변환하기
     */
    private String convert(String infix) {
    	infix = infix.trim();
    	StringBuilder postfix = new StringBuilder();
    	Stack<Character> stack = new Stack<>();
    	
    	for (int i = 0; i < infix.length(); i++) {
    		char c = infix.charAt(i);
    		
    		if (Character.isDigit(c)) {
    			postfix.append(c);
    		} else if (c == '(') {
    			stack.push(c);
    		} else if (c == ')') {
    			while (!stack.isEmpty() && stack.peek() != '(') {
    				postfix.append(stack.pop());
    			}
    			stack.pop();
    		} else {
    			while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
    				postfix.append(stack.pop());
    			}
    			stack.push(c);
    		}
    	}
    	
    	while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
    	
    	return postfix.toString();
    }

}
