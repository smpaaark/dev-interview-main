package me.whiteship.interview._04_queue_02;

import java.util.HashMap;

public class LRUCache {

    private int cacheSize;
    
    private HashMap<Integer, Node> map;
    
    private Node head;
    private Node tail;
    
    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
    }

    /**
     * TODO 문제. LRU 캐시를 구현하라
     *  최대 n개 만큼의 가장 최근에 접근한 데이터를 캐싱하는 LRU (least recently used) 캐시를 구현하라.
     *  입력값 number는 1부터 100까지의 숫자가 랜덤하게 입력된다. 그 중에 최대 n (1보다 크고 9보다 작은)개 만큼의 데이터만 캐시할 수 있다. n개를 넘는 새로운 값이 들어오면 그 중에서 가장 오래전에 접근한 데이터를 삭제하고 number를 캐시에 추가한다.
     *  다음 오퍼레이션을 구현하라.
     *  query(int number): number에 해당하는 입력값을 캐시에 추가한다.
     *  print() 현재 캐시하고 있는 데이터를 출력한다.
     * @param number
     */
//    private void query(int number) {
//    	if (!cache.contains(number)) {
//    		if (cache.size() == this.cacheSize) {
//    			cache.removeLast();
//    		}
//    		
//    		cache.addFirst(number);
//    	} else {
//    		cache.remove(number);
//    		cache.addFirst(number);
//    	}
//    }
    
    private void query(int number) {
    	if (map.containsKey(number)) {
    		Node node = map.get(number);
    		remove(node);
    		addToHead(node);
    	} else {
    		Node nodeToAdd = new Node();
    		nodeToAdd.value = number;
    		if (map.size() == this.cacheSize) {
    			map.remove(tail.value);
    			remove(tail);
    		}
    		
    		addToHead(nodeToAdd);
    		map.put(number, nodeToAdd);
    	}
    }

//    private void print() {
//    	System.out.println(cache);
//    }
    
    private void addToHead(Node node) {
		node.next = this.head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		
		head = node;
		
		if (tail == null) {
			tail = head;
		}
	}

	private void remove(Node node) {
    	if (node.prev != null) {
    		node.prev.next = node.next;
    	} else {
    		this.head = node.next;
    	}
    	
    	if (node.next != null) {
    		node.next.prev = node.prev;
    	} else {
    		this.tail = node.prev;
    	}
	}

	private void print() {
    	Node currentNode = head;
    	while (currentNode != null) {
    		System.out.println(currentNode.value);
    		currentNode = currentNode.next;
    	}
    }
    
    private class Node<E> {
    	E value;
    	Node<E> next;
    	Node<E> prev;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.query(1);
        lruCache.query(2);
        lruCache.query(3);
        lruCache.query(1);
        lruCache.query(4);
        lruCache.query(5);
        lruCache.query(2);
        lruCache.query(2);
        lruCache.query(1);
        lruCache.print();
    }

	private void query2(int number) {
		if (map.containsKey(number)) {
    		Node node = map.get(number);
    		remove(node);
    		addToHead(node);
    	} else {
    		Node nodeToAdd = new Node();
    		nodeToAdd.value = number;
    		if (map.size() == this.cacheSize) {
    			map.remove(tail.value);
    			remove(tail);
    		}
    		
    		addToHead(nodeToAdd);
    		map.put(number, nodeToAdd);
    	}
	}
}
