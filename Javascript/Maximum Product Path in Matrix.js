function getGreatestProductPath(matrix) {
	
	if (matrix.length == 0 || matrix[0].length == 0) return -1;
	let m = matrix.length, n = matrix[0].length;
	
	let min = new Array(m).fill(new Array(n).fill(0));
	let max = new Array(m).fill(new Array(n).fill(0));	
	
	for (let i = 0; i < m; i++) {
	
		for (let j = 0; j < n; j++) {
		
			let minVal = Infinity, maxVal = -Infinity;
			
			if (i == 0 && j == 0) {
				
				maxVal = matrix[i][j];
				minVal = matrix[i][j];
			}
			
			if (j > 0) {
			
				let tempMin = Math.min(matrix[i][j] * min[i][j-1], matrix[i][j] * max[i][j-1]);
				minVal = Math.min(minVal, tempMin);
				
				let tempMax = Math.max(matrix[i][j] * min[i][j-1], matrix[i][j] * max[i][j-1]);
				maxVal = Math.max(maxVal, tempMax);
			}

			if (i > 0) {
			
				let tempMin = Math.min(matrix[i][j] * min[i-1][j], matrix[i][j] * max[i-1][j]);
				minVal = Math.min(minVal, tempMin);
				
				let tempMax = Math.max(matrix[i][j] * min[i-1][j], matrix[i][j] * max[i-1][j]);
				maxVal = Math.max(maxVal, tempMax);
			}
						
			min[i][j] = minVal;
			max[i][j] = maxVal;
		}	
	}
	
	return max[m-1][n-1];
}

/*

Time Compleixty - O(M*N)
Space Complexity - O(M*N)

*/
