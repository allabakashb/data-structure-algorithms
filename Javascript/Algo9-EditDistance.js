//Problem Statement
/*

Given two strings A & B, find the minimum operations to convert from A to B.

INPUT => A - "Saturday", B - "Sunday"
OUTPUT => 3

*/

function editDistance(str1, str2) {

	function minDistance(str1, str2, m, n) {
	
		if (m == 0) return n;
		
		if (n == 0) return m;
		
		if (str1.charAt(m-1) == str2.charAt(n-1))
		return minDistance(str1, str2, m-1, n-1);
		
		let min1 = minDistance(str1, str2, m, n-1); //insert
		let min2 = minDistance(str1, str2, m-1, n); //delete
		let min3 = minDistance(str1, str2, m-1, n-1); //update
		
		return 1 + Math.min(min1, Math.min(min2, min3));
	}
	
	return minDistance(str1, str2, str1.length, str2.length);
}

/*
 Time Complexity - O(3^m)
 Space Complexity - O(D) - depth of the recursion
*/


//Using Dynamic Programming
function editDistance(word1, word2) {
	
	let m = word1.length, n = word2.length;
	
	let dp = new Array(m+1);
    
    for (let i = 0; i <= m; i++) {
        
        dp[i] = new Array(n).fill(0);
        dp[i][0] = i;
    }
    
    for (let j = 0; j <= n; j++) {
        
        dp[0][j] = j;
    }
	
	for (let i = 1; i <= m; i++) {
	
		for (let j = 1; j <= n; j++) {
		
			if (word1.charAt(i-1) == word2.charAt(j-1)) {
				
				dp[i][j] = dp[i-1][j-1];
			} else {
				
				dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
			}
		}
	}
	
	return dp[m][n];
}

/*
 
 Time Complexity - O(M * N)
 Space Complexity - O(M * N)
 
*/
