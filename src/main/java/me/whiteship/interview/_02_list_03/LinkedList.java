package me.whiteship.interview._02_list_03;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(4));

        list.print();
        list.removeDuplicates5();
        list.print();
    }

    private void removeDuplicates5() {
		Set<Integer> numberSet = new HashSet<>();
		
		LinkedNode current = this.head;
		LinkedNode prev = null;
		
		while (current != null) {
			int currentNumber = current.number;
			if (numberSet.contains(currentNumber)) {
				prev.next = current.next;
			} else {
				numberSet.add(currentNumber);
				prev = current;
			}
			
			current = current.next;
		}
	}

	private void removeDuplicates4() {
		removeDuplicatesRecursive(this.head);
	}

    private LinkedNode removeDuplicatesRecursive(LinkedNode node) {
		if (node == null) {
			return null;
		}
		
		if (node.next != null) {
			if (node.number == node.next.number) {
				node.next = node.next.next;
				removeDuplicatesRecursive(node);
			} else {
				removeDuplicatesRecursive(node.next);
			}
		}
		
		return node;
	}

	// 내가 구현한 재귀
	private void removeDuplicates3() {
		recursiveSolution(this.head);
	}

	private void recursiveSolution(LinkedNode node) {
		if (node.next == null) {
			return;
		}
		
		recursiveSolution(node.next);
		if (node.number == node.next.number) {
			node.next = node.next.next;
		}
	}

	private void removeDuplicates2() {
		LinkedNode current = this.head;
		LinkedNode prev = this.head;
		
		while (current != null) {
			if (current.number != prev.number) {
				prev.next = current;
				prev = current;
			}
			
			current = current.next;
		}
		
		if (prev != current) {
			prev.next = null;
		}
	}

	/**
     * TODO 정렬된 연결 리스트에서 중복가 노드를 제거하는 함수를 구현하라.
     *  예) 1 -> 1 -> 1 -> 2 -> 3 -> 3   =>   1 -> 2 -> 3
     * @return
     */
    private void removeDuplicates() {
    	LinkedNode current = this.head;
    	while (current != null) {
    		LinkedNode next= current;
    		while (next != null && next.number == current.number) {
    			next = next.next;
    		}
    		
    		current.next = next;
    		current = current.next;
    	}
    }

    private void print() {
        LinkedNode nodeToPrint = this.head;
        while(nodeToPrint != null) {
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    private void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

}
