package com.general.dsandalgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DistinctIslands {

	class Cell {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
		int row;
		int col;
		public Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
		private DistinctIslands getEnclosingInstance() {
			return DistinctIslands.this;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		new DistinctIslands().solve(sc.nextInt(), sc.nextInt());
		sc.close();
	}
	
	public void solve(int m, int n) {
		
		int[][] input = generate(m, n);
		Set<List<Cell>> set = new HashSet<>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				List<Cell> cells = new ArrayList<>();
				dfs(input, i, j, i, j, cells);
				if (cells.size() > 0)
				set.add(cells);
			}
		}
		
		System.out.println("Distinct Islands => " + set.size());
	}

	private void dfs(int[][] input, int i, int j, int baseX, int baseY, List<Cell> cells) {
		
		if (i >= input.length || j >= input[0].length || i < 0 || j < 0 || input[i][j] <= 0) {
			return;
		}
		
		input[i][j] *= -1;
		
		cells.add(new Cell(i-baseX, j-baseY));
		dfs(input, i, j+1, baseX, baseY, cells);
		dfs(input, i, j-1, baseX, baseY, cells);
		dfs(input, i+1, j, baseX, baseY, cells);
		dfs(input, i-1, j, baseX, baseY, cells);
	}

	private int[][] generate(int m, int n) {
		int[][] input  = null; //new int[m][n];
		
		input = new int[][] {{0, 0, 1, 1, 1, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 1, 0},
				{0, 0, 1, 1, 1, 0, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 1, 1, 1, 0},
				{0, 0, 1, 1, 0, 0, 1, 0, 0},
				{0, 0, 1, 1, 0, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 1, 1, 1, 0},
				{0, 0, 1, 0, 0, 0, 0, 1, 0}};
				
				for (int i = 0; i < m; i++) {
					for (int j = 0;j < n; j++) {
						//input[i][j] = (int) (Math.random() * 2);
						System.out.print(input[i][j] + " ");
					}
					System.out.println("");
				}
				
		return input;
	}

}
