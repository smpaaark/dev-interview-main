package me.whiteship.interview._02_list_02;

import java.util.HashMap;
import java.util.Map;

public class MiddleNode {
	
	private LinkedNode head;
	private LinkedNode tail;
	
	public static void main(String[] args) {
		MiddleNode list = new MiddleNode();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));

        list.print();
        
        System.out.println();
        System.out.println(list.solution());
	}

	private int solution() {
		Map<Integer, LinkedNode> map = new HashMap<>();
		int index = 0;
		
		LinkedNode currentNode = this.head;
		while (currentNode != null) {
			map.put(index++, currentNode);
			currentNode = currentNode.next;
		}
		
		return map.get((index - 1) / 2).number;
	}

	private void print() {
		LinkedNode currentNode = this.head;
		while (currentNode != null) {
			System.out.print(currentNode.number + " ");
			currentNode = currentNode.next;
		}
	}

	private void add(LinkedNode node) {
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
	}
	
}
