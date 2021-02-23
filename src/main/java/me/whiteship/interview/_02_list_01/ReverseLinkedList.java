package me.whiteship.interview._02_list_01;

public class ReverseLinkedList {
	
	private LinkedNode head;
	private LinkedNode tail;
	
	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));

        list.print();
        System.out.println();
        list.solution();
	}

	private void solution() {
		reversePrint(this.head);
	}

	private void reversePrint(LinkedNode node) {
		if (node == null) {
			return;
		}
		
		reversePrint(node.next);
		System.out.print(node.number + " ");
	}

	private void print() {
		LinkedNode node = this.head;
		while (node != null) {
			System.out.print(node.number + " ");
			node = node.next;
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
