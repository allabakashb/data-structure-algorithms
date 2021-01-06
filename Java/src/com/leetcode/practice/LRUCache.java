package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class Node {

		int key;
		int val;
		Node prev;
		Node next;

		Node(int val, int key) {
			this.val = val;
			this.key = key;
		}
	}

	Node first = null;
	Node last = null;

	Map<Integer, Node> map;
	int maxSize = 0;

	public LRUCache(int capacity) {

		map = new HashMap<>();
		this.maxSize = capacity;
	}

	public int get(int key) {

		Node node = map.get(key);

		if (node != null) {

			remove(node);
			addAtFront(node);

			return node.val;
		}
		return -1;
	}

	private void addAtFront(Node node) {

		node.next = first;

		node.prev = null;

		if (first != null)
			first.prev = node;

		first = node;

		if (last == null) {

			last = first;
		}
	}

	private void remove(Node node) {

		if (node.prev != null) {

			node.prev.next = node.next;

		} else {

			first = node.next;
		}

		if (node.next != null) {

			node.next.prev = node.prev;
		} else {

			last = node.prev;
		}
	}

	public void put(int key, int value) {

		Node newNode = map.get(key);
		
		boolean existing = true;
		if (newNode == null) {
			
			newNode = new Node(key, value);
			existing = false;
		}

		if (!existing && map.size() == maxSize) {
			int lastKey = last.key;
			remove(last);
			map.remove(lastKey);
		} else if (existing) {
			
			newNode.val = value;
			remove(newNode);
		}

		addAtFront(newNode);
		map.put(key, newNode);
	}

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(1);

		cache.put(2, 1);
		//cache.put(2, 2);

		System.out.println("2 -> " + cache.get(2) + " -> 1");

		/*
		 * cache.put(3, 3);
		 * 
		 * System.out.println("2 -> " + cache.get(2) + " -> -1");
		 * 
		 * cache.put(4, 4);
		 * 
		 * System.out.println("1 -> " + cache.get(1) + " -> -1");
		 * 
		 * System.out.println("3 -> " + cache.get(3) + " ->  3");
		 * 
		 * System.out.println("4 -> " + cache.get(4) + " ->  4");
		 */
	}

}
