package com.leetcode.practice;

public class Problem839 {

	private int[] ids;
	private int[] weights;
    private int groups;

    class QUF {
        
        QUF(int N) {

		    ids = new int[N];
		    weights = new int[N];

            for (int i = 0; i < N; i++) {

                ids[i] = i;
                weights[i] = 1;
            }
            
            groups = N;
	    }

        public void union(int i, int j) {

            int ri = root(i);
            int rj = root(j);
            
            if (ri == rj) return;

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
    }
    
    public int numSimilarGroups(String[] A) {
    
        QUF quf = new QUF(A.length);
        
        for (int i = 0; i < A.length; i++) {
            
            int len1 = A[i].length(); 

            for (int j = i + 1; j < A.length; j++) {
                
                int len2 = A[j].length();
                
                if (len1 != len2) continue;
                
                int count = 0;
                
                for (int k = 0; k < len1; k++) {
                    
                    if (count > 2) {
                        break;
                    }
                    if (A[i].charAt(k) != A[j].charAt(k)) {
                        
                        ++count;
                    }
                }
        
                if (count <= 2) {
                    
                	quf.union(i, j);
                }
            }
        }
        
        return quf.getGroups();
    }
	
	public static void main(String[] args) {
		
		String[] a = { "abc", "cba", "acb", "bca", "bac", "cab" }; //{ "qihcochwmglyiggvsqqfgjjxu","gcgqxiysqfqugmjgwclhjhovi","gjhoggxvcqlcsyifmqgqujwhi","wqoijxciuqlyghcvjhgsqfmgg","qshcoghwmglygqgviiqfjcjxu","jgcxqfqhuyimjglgihvcqsgow","qshcoghwmggylqgviiqfjcjxu","wcoijxqiuqlyghcvjhgsqgmgf","qshcoghwmglyiqgvigqfjcjxu","qgsjggjuiyihlqcxfovchqmwg","wcoijxjiuqlyghcvqhgsqgmgf","sijgumvhqwqioclcggxgyhfjq","lhogcgfqqihjuqsyicxgwmvgj","ijhoggxvcqlcsygfmqgqujwhi","qshcojhwmglyiqgvigqfgcjxu","wcoijxqiuqlyghcvjhgsqfmgg","qshcojhwmglyiggviqqfgcjxu","lhogcgqqfihjuqsyicxgwmvgj","xscjjyfiuglqigmgqwqghcvho","lhggcgfqqihjuqsyicxgwmvoj","lhgocgfqqihjuqsyicxgwmvgj","qihcojhwmglyiggvsqqfgcjxu","ojjycmqshgglwicfqguxvihgq","sijvumghqwqioclcggxgyhfjq","gglhhifwvqgqcoyumcgjjisqx" };
		System.out.println(new Problem839().numSimilarGroups(a));
	}
}
