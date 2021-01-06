package com.june2020.practice;

public class TreeAncestor {

	int[][] tree;
    int m;
    
    public TreeAncestor(int n, int[] parent) {
        
        m = (int)(Math.log(n)/Math.log(2))+1;
        tree = new int[n][m];
                
        for(int i = 1; i < n; i++) {
            
            tree[i][0] = parent[i];
        }
        
        for(int i = 1; i < n; i++) {
            
            for (int j = 1; j < m; j++) {
                
                tree[i][j] = tree[i][j-1] <= 0 ? -1 : tree[tree[i][j-1]][0];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
          
        return k <= m && node != 0 ? tree[node][k-1] : -1;
    }
    
	public static void main(String[] args) {
		
		TreeAncestor ta = new TreeAncestor(10, new int[] {-1,0,0,1,2,0,1,3,6,1 });
		System.out.println(ta.getKthAncestor(7, 3));
	}

}
