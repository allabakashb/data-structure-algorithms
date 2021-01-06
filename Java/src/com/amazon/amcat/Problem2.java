package com.amazon.amcat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int r =  sc.nextInt();
		int c =  sc.nextInt();
		
		List<List<Integer>> grid = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < r; i++) {
			
			List<Integer> li = new ArrayList<Integer>();
			for (int j = 0; j < c; j++) {
				
				li.add(sc.nextInt());
			}
			
			grid.add(li);
		}
	
		
		System.out.println(new Problem2().minimumDays(r, c, grid));
	}

	int minimumDays(int rows, int columns, List<List<Integer>> grid)
    {
        
		int days = 0;
		
		boolean[] visitedRows = new boolean[rows];
		boolean done = false;
		
		while (!done) {
			
			boolean[][] visited = new boolean[rows][columns];
			int count = 1;
			for (int i = 0; i < rows; i++) {
				
				List<Integer> rowCells = grid.get(i);
				
				if (visitedRows[i]) {
					count++;
					continue;
				}
				
				boolean added = false;
				for (int j = 0; j < columns; j++) {
					
					int col = rowCells.get(j);
					
					if (col == 1 && !visited[i][j]) {
						
						//right
						if (j < (columns-1) && !visited[i][j+1]) {
							
							if (rowCells.get(j+1) == 0) {
								
								rowCells.set(j+1, 1);
								visited[i][j+1] = true;
								added = true;
							}
						}
						
						//bottom
						if ( i < rows-1 && !visited[i+1][j]) {
							
							List<Integer> rowB = grid.get(i+1);
							if (rowB.get(j) == 0) {
								
								rowB.set(j, 1);
								visited[i+1][j] = true;
								added = true;
							}
						}
						
						//left
						if ( j > 0 && !visited[i][j-1]) {
							
							List<Integer> rowl = grid.get(i);
							if (rowl.get(j-1) == 0) {
								
								rowl.set(j-1, 1);
								visited[i][j-1] = true;
								added = true;
							}
						}
						
						//top
						if ( i > 0 && !visited[i-1][j]) {
							
							List<Integer> rowT = grid.get(i-1);
							if (rowT.get(j) == 0) {
								
								rowT.set(j, 1);
								visited[i-1][j] = true;
								added = true;
							}
						}
					}
				}
				
				if (!added) {
					
					visitedRows[i] = true;
				}
			}
			
			if (count == rows) {
				break;
			} else {
				days++;
			}
		}
		
		return days;
    }
}
