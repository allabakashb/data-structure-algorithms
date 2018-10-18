package com.ds;

public class MainBasic {

	public static void main(String[] args) {
/*		QuickFind qub = new QuickFind(10);
*/		QuickUnion qub = new QuickUnion(10);
		qub.union(4, 3);
		qub.union(3, 8);
		qub.union(6, 5);
		qub.union(9, 4);
		qub.union(2, 1);
		System.out.println(qub.isConnected(8, 9));
		System.out.println(qub.isConnected(5, 0));
		qub.union(5, 0);
		qub.union(7, 2);
		qub.union(6, 1);
	}

}
