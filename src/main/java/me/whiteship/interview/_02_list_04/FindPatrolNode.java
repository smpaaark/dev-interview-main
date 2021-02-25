package me.whiteship.interview._02_list_04;

import java.util.HashSet;
import java.util.Set;

public class FindPatrolNode {
		
	private LinkedNode head;
	private LinkedNode tail;
	
	public static void main(String[] args) {
		FindPatrolNode list = new FindPatrolNode();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        LinkedNode node3 = new LinkedNode(3);
        list.add(node3);
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));
        list.add(node3);

//	        list.print();
        System.out.println(list.solution());
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

	private int solution() {
		Set<LinkedNode> nodeSet = new HashSet<>();
        LinkedNode current = this.head;
        while (current != null) {
        	if (nodeSet.contains(current)) {
        		return current.number;
        	} else {
        		nodeSet.add(current);
        	}
        	
        	current = current.next;
        }
        
        return -1;
	}
	
}
