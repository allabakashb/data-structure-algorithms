//Problem Statement

/*

Given two sorted arrays, where first array has enough space for merging second array, so merge the second array in place.

INPUT => 

A = [2, 3, 5, 0, 0, 0] , B = [1, 4, 6]

OUTPUT =>

A = [1, 2, 3, 4, 5, 6]
*/

function mergeArrays(arr1, arr2) {

	let i = arr1.length - 1;
	let j = arr2.length - 1;
	let k = i - j - 1;
	
	while (j >= 0 && k >= 0) {
		
		if (arr1[k] > arr2[j]) {
			
			arr1[i--] = arr1[k--];
		} else {
			
			arr1[i--] = arr2[j--];
		}
	}
	
	while (j >= 0) {
	
		arr1[i--] = arr2[j--];
	}
	
	console.log(arr1);
}

/*

  Time Complexity - O(M+N)
  Space Complexity - O(1)
*/


//Brute Force

function mergeArrays(arr1, arr2) {

	for (let i = 0; i < arr2.length; i++) {
	
		for (let j = 0; j < arr1.length; j++) {
		
			if (arr2[i] < arr1[j] || arr1[j] == 0) {
				
				let k = j + 1, prev = arr1[j];
				while (k < arr1.length) {
				
					let temp = arr1[k];
					arr1[k++] = prev;
					prev = temp;
					
					if (prev == 0) break;
				}
				
				arr1[j] = arr2[i];
				break;
			}
		}
	}
	
	console.log(arr1);
}

/*

 Time Complexity - O(M * N)
 Space Complexity - O(1)

*/
