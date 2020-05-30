//Problem Statement

/*

  Give a matrix with 0's and 1's , find the largest subsquare matrix size.
  
  INPUT =>
  
[[1, 1, 1, 1, 0],
[0, 1, 1, 0, 1],
[0, 0, 0, 1, 0],
[1, 1, 1, 1, 0],
[0, 1, 1, 1, 1],
[0, 1, 1, 1, 0]]
  
  OutPUT => 3
*/

// Using Dynamic Programming
function largestSubSquareMatrix(matrix) {

	let m = matrix.length, n = matrix[0].length;
	
	let dp = new Array(m+1).fill(new Array(n+1).fill(0));
	
	let largestMatrix = 0;
	for (let i = 1; i <= m; i++) {
	
		for (let j = 1; j <= n; j++) {
		
			if (matrix[i-1][j-1] == 0) {
				
				dp[i][j] = 0;
			} else {
			
				dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
				
				largestMatrix = Math.max(largestMatrix, dp[i][j]);
			}
		}
	}

	return largestMatrix;
}

/*

  Time Complexity - O(M*N)
  Space Complexity - O(M*N)
  
*/

//Dynamic Programming Approach 2

function largestSubSquareMatrix(matrix) {

	let m = matrix.length, n = matrix[0].length;
	
	let dp = new Array(n+1).fill(0);
	
	let largestMatrix = 0, prev = 0;
	for (let i = 0; i < m; i++) {
	
		for (let j = 1; j <= n; j++) {
		
			let temp = dp[j];
			if (matrix[i][j-1] == 0) {
				
				dp[j] = 0;
			} else {
			
				dp[j] = Math.min(dp[j-1], Math.min(dp[j], prev)) + 1;
				
				largestMatrix = Math.max(largestMatrix, dp[j]);
			}
			prev = dp[j];
		}
	}

	return largestMatrix;
}

/*

  Time Complexity - O(M*N)
  Space Complexity - O(N)
  
*/
