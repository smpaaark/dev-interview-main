package me.whiteship.interview._02_list_01;

public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));

        list.print();
        list.reverse3();

        list.print();
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

    /**
     * TODO 단일 연결 리스트를 뒤집는 함수를 구현하라.
     *  예) 1 -> 2 -> 3   =>   3 -> 2 -> 1
     * @return
     */
    private void reverse1() {
    	LinkedNode current = this.head;
    	LinkedNode prev = null;
    	LinkedNode next = null;
    	
    	while (current != null) {
    		next = current.next;
    		current.next = prev;
    		prev = current;
    		current = next;
    	}
    	
    	this.tail = this.head;
    	this.head = prev;
    }
    
    private void reverse2() {
    	LinkedNode head = this.head;
    	this.head = reverseRecursive(head);
    	this.tail = head;
    }

	private LinkedNode reverseRecursive(LinkedNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		
		LinkedNode newHead = reverseRecursive(node.next);
		node.next.next = node;
		node.next = null;
		
		return newHead;
	}
	
	private void reverse3() {
		this.tail = this.head;
		solution(this.head);
	}

	private void solution(LinkedNode node) {
		if (node.next == null) {
			this.head = node;
			return;
		}
		
		solution(node.next);
		node.next.next = node;
		node.next = null;
	}

}
