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
  
[[true, false, false, false],
[false, false, false, false],
[false, false, true, false],
[false, true, false, false],
[false, false, false, false]]
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

/*----------------------------------Approach 1---------------------------*/
