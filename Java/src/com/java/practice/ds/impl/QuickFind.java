package com.java.practice.ds.impl;

public class QuickFind {
	
	private int[] ids;
	
	public QuickFind(int N) {
		
		ids = new int[N];
		
		for (int i = 0; i < N; i++) {
			
			ids[i] = i;
		}
	}
	
	public boolean connected(int i, int j) {
		
		return ids[i] == ids[j];
	}
	
	public void union(int i, int j) {
		
		int idI = ids[i];
		int idJ = ids[j];
		
		for (int k = 0; k < ids.length; k++) {
			
			if (ids[k] == idJ) {
				
				ids[k] = idI;
			}
		}
	}
	
	public int find(int i) {

		return ids[i];
	}

	public static void main(String[] args) {
		
		QuickFind qf = new QuickFind(10);
		
		qf.union(1, 2);
		qf.union(3, 4);

		System.out.println(qf.connected(1, 2));
		System.out.println(qf.connected(1, 3));
		System.out.println(qf.connected(4, 2));

		System.out.println(qf.find(1));
		System.out.println(qf.find(2));
		System.out.println(qf.find(3));
		System.out.println(qf.find(4));
		
		qf.union(7, 8);
		qf.union(2, 8);
		qf.union(6, 5);
		qf.union(5, 1);
		qf.union(3, 7);

		System.out.println(qf.connected(1, 2));
		System.out.println(qf.connected(1, 3));
		System.out.println(qf.connected(4, 2));

		System.out.println(qf.find(1));
		System.out.println(qf.find(2));
		System.out.println(qf.find(3));
		System.out.println(qf.find(4));
		System.out.println(qf.find(7));
		System.out.println(qf.find(8));
		System.out.println(qf.find(9));
		System.out.println(qf.find(6));
	}
}
