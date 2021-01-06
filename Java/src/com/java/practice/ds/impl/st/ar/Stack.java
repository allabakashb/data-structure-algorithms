package com.java.practice.ds.impl.st.ar;

public class Stack<Item> {
	
	Item[] data;
	int len = 0;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		
		data = (Item[])new Object[1];
	}
	
	public boolean isEmpty() {
		
		return len == 0;
	}
	
	public Item pop() {
		
		Item item = data[--len];
		
		data[len] = null;
		if (len > 0 && len == data.length/4) {
			
			resizeArray(data.length/2);
		}
		
		return item;
	}
	
	public void push(Item item) {
		
		if (len == data.length) {
			
			resizeArray(data.length * 2);
		}
		
		data[len++] = item;
	}

	@SuppressWarnings("unchecked")
	private void resizeArray(int length) {
		
		Item[] newData = (Item[])new Object[length];
		
		for (int i = 0; i < len; i++) {
			
			newData[i] = data[i];
		}
		
		data = newData;
	}
}
