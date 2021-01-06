package com.java.practice.ds.impl;

public class WeightedQuickUnionWithPathCompression {

	private int[] ids;
	private int[] weights;
    private int groups;

	public WeightedQuickUnionWithPathCompression(int N) {

		ids = new int[N];
		weights = new int[N];

		for (int i = 0; i < N; i++) {

			ids[i] = i;
			weights[i] = 1;
		}
		
		groups = N;
	}

	public boolean connected(int i, int j) {

		return root(ids[i]) == root(ids[j]);
	}

	public void union(int i, int j) {

		int ri = root(ids[i]);
		int rj = root(ids[j]);
		
		if (weights[ri] > weights[rj]) {
			
			ids[rj] = ri;
			weights[rj] += weights[ri];			
		} else {
			
			ids[ri] = rj;
			weights[ri] += weights[rj];			
		}

		--groups;
	}

	public int find(int i) {

		return root(i);
	}

	private int root(int i) {

		while (i != ids[i]) {

			ids[i] = ids[ids[i]];
			i = ids[i];
		}

		return ids[i];
	}
	
	public int getGroups() {
		
		return groups;
	}

	public static void main(String[] args) {

		WeightedQuickUnionWithPathCompression qf = new WeightedQuickUnionWithPathCompression(8);

		qf.union(1, 2);
		qf.union(3, 4);
		
		System.out.println(qf.getGroups());
		qf.union(7, 0);
		
		System.out.println(qf.getGroups());

		qf.union(2, 7);
		
		System.out.println(qf.getGroups());

		qf.union(6, 5);
		
		System.out.println(qf.getGroups());

		qf.union(5, 1);
		System.out.println(qf.getGroups());

		qf.union(3, 7);
		
		System.out.println(qf.getGroups());


	}
}
