package com.leetcode.practice;

public class MinHeap {
	
	int[] heap;
	int size;
	int capacity;
	
	public MinHeap() {
		capacity = 10;
		heap = new int[capacity];
	}
	
	private void ensureCapacity() {
		
		int newCapacity = 0;
		
		if (size == capacity) {
			
			newCapacity = capacity * 2;
		} else if (size == (capacity/ 2)) {
			
			newCapacity =  capacity / 4;
			
			newCapacity = newCapacity < 10 ? 10 : newCapacity;
		}
		
		if (newCapacity > 0) {
			
			int[] newHeap = new int[newCapacity];
			
			capacity = newCapacity;
			for (int i = 0; i < size; i++) {
				
				newHeap[i] = heap[i];
			}
			
			heap = newHeap;
		}
	}
	
	private void heapify() {
		
	}
	
	private int parent(int index) {
		
		if (index >= size) throw new IllegalStateException();
		
		return heap[getParentIndex(index)];
	}
	
	private int getParentIndex(int index) {
		
		return (index-1)/2;
	}
	
	private int leftIndex(int index) {
		
		return (2 * index ) +  1;
	}
	
	private int rightIndex(int index) {
		
		return (2 * index ) +  2;
	}

	public void insert(int element) {
		
		ensureCapacity();
		heap[++size] = element;
	
		int current = size;
		
		while (heap[current] < parent(current)) {
			swap(current, getParentIndex(current));
			current = getParentIndex(current);
		}
	}
	
	public int peak() {
		
		if (size == 0) throw new IllegalStateException();
		
		return heap[0];
	}
	
	public int remove() {
		
		if (size == 0) throw new IllegalStateException();
		
		int item = heap[0];
		
		heap[0] = heap[size--];
		ensureCapacity();
		
		heapify();
				
		return item;
	}
	
	private void swap(int index1, int index2) {
		
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
}
