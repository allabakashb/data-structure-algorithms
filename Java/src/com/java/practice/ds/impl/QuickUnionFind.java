package com.java.practice.ds.impl;

public class QuickUnionFind {

	private int[] ids;

	public QuickUnionFind(int N) {

		ids = new int[N];

		for (int i = 0; i < N; i++) {

			ids[i] = i;
		}
	}

	public boolean connected(int i, int j) {

		return root(i) == root(j);
	}

	public void union(int i, int j) {

		int ri = root(ids[i]);
		int rj = root(ids[j]);

		ids[rj] = ri;
	}

	public int find(int i) {

		return root(i);
	}

	private int root(int i) {

		while (i != ids[i]) {

			i = ids[i];
		}

		return ids[i];
	}

	public static void main(String[] args) {

		QuickUnionFind qf = new QuickUnionFind(10);

		qf.union(1, 2);
		qf.union(3, 4);

		System.out.println(qf.connected(1, 2));
		System.out.println(qf.connected(1, 3));
		System.out.println(qf.connected(4, 2));

		qf.union(7, 8);
		qf.union(2, 8);
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
