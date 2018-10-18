package com.ds;

public class QuickUnion {
	private int[] ids ;
	
	public QuickUnion(int size) {
		ids = new int[size];
		for (int i = 0; i < size; i++) {
			ids[i] = i;
		}
	}
	
	public boolean isConnected(int src, int dest) {
		return root(src) == root(dest);
	}
	
	private int root(int i) {
		while(i != ids[i]) {
			i = ids[i];
		}
		return i;
	}
	
	public void union(int src, int dest) {
		int srcId = root(src);
		int destId = root(dest);
		ids[srcId] = destId;
	}
}

/*

	root(i) = ids[ ids [ .. ids[i] ] ] 

*/