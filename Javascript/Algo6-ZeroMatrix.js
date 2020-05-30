//Problem Statement

/*

  Given a Matrix which contains only boolean values, if any cell has true, update all its row and column values with true.
  
  Example => 
  
  INPUT => 
  
[[true, false, false, false],
[false, false, false, false],
[false, false, true, false],
[false, true, false, false],
[false, false, false, false]]

  OUTPUT =>
  
[[true, true, true, false],
[true, true, true, false],
[true, true, true, true],
[true, true, true, true],
[true, true, true, false]]
*/

/*----------------------------------Approach 1---------------------------*/
//Using Two sets
function zeroMatrix(matrix) {

	let rows = new Set();
	let cols = new Set();
	
	for (let i = 0; i < matrix.length; i++) {
	
		for (let j = 0; j < matrix[i].length; j++) {
	
			if (matrix[i][j]) {
				
				rows.add(i);
				cols.add(j);
			}
		}
	}
	
	rows.forEach((i) => {
	
		for (let j = 0; j < matrix[i].length; j++) {
	
			matrix[i][j] = true;
		}
	});
	
	cols.forEach((j) => {
	
		for (let i = 0; i < matrix.length; i++) {
	
			matrix[i][j] = true;
		}
	});

	return matrix;
}

/*

Time Complexity - O(M*N)
Space Complexity - O(M+N)

*/

/*----------------------------------Approach 1---------------------------*/

/*----------------------------------Approach 2---------------------------*/
// Efficient Approach
function zeroMatrix(matrix) {

	let firstRow = false, firstCol = false;
	
	for (let i = 0; i < matrix.length; i++) {
	
		for (let j = 0; j < matrix[i].length; j++) {
	
			if (matrix[i][j]) {
				
				if (i == 0) firstRow = true;
				if (j == 0) firstCol = true;
				
				matrix[i][0] = true;
				matrix[0][j] = true;
			}
		}
	}
	
	for (let i = 1; i < matrix.length; i++) {
	
		for (let j = 1; j < matrix[i].length; j++) {
		
			if (matrix[i][0] || matrix[0][j]) {
				
				matrix[i][j] = true;
			}
		}	
	}
	
	if (firstRow) {
	
		for (let j = 0; j < matrix[0].length; j++) {
			
			matrix[0][j] = true;
		}
	}
	
	if (firstCol) {
	
		for (let i = 0; i < matrix.length; i++) {
			
			matrix[i][0] = true;
		}
	}

	return matrix;
}

/*

   Time Complexity - O(M * N)
   Space Complexity - O(1)
*/
/*----------------------------------Approach 2---------------------------*/
