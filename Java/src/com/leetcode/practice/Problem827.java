package com.leetcode.practice;

public class Problem827 {

    int maxArea = 0;

    public int largestIsland(int[][] grid) {
               
        int m = grid.length;
        int n = grid[0].length;
                
        for (int i = 0; i < m; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 0) {
                    
                    grid[i][j] = 1;
                    getArea(grid, 0, 0, new boolean[m][n]);
                    grid[i][j] = 0;
                }
            }
        }
        
        return maxArea == 0 ? m * n : maxArea;
    }
    
    private int getArea(int[][] grid, int i, int j, boolean[][] visited) {
        
        if (i >= grid.length || j >= grid[0].length 
            || i < 0 || j < 0 || visited[i][j]) return 0;
        
        visited[i][j] = true;
        
        int down = getArea(grid, i+1, j, visited);
        int right = getArea(grid, i, j+1, visited);
        int left = getArea(grid, i, j-1, visited);
        int up = getArea(grid, i-1, j, visited);
               
        int area = 0;
        if (grid[i][j] == 0) {
            
            int max1 = Math.max(down, right);
            int max2 = Math.max(left, up);
            
            maxArea = Math.max(maxArea, Math.max(max1, max2));
        } else {
            
            area = 1 + down + right + left + up;
            
            maxArea = Math.max(maxArea, area);
        }
        
        return area;
    }
   
    public static void main(String[] args) {
		
    	int[][] grid = {{1,0,1},{0,0,0},{0,1,1}};
		System.out.println(new Problem827().largestIsland(grid));
	}
}
