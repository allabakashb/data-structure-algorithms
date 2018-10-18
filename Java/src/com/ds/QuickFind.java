package com.ds;

public class QuickFind {
	private int[] ids ;
	
	public QuickFind(int size) {
		ids = new int[size];
		for (int i = 0; i < size; i++) {
			ids[i] = i;
		}
	}
	
	public boolean isConnected(int src, int dest) {
		return ids[src] == ids[dest];
	}
	
	public void union(int src, int dest) {
		int srcId = ids[src];
		int destId = ids[dest];
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] == srcId) {
				ids[i] = destId;
			}
		}
	}
}
