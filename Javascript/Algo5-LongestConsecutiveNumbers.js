
//Brute Force
function getConsecutiveNumbers(array) {

	let result = [];
	
	for (let i = 0; i < array.length; i++) {
	
		let prev = array[i];
		let temp = [ prev ];
		
		let j = 0;
		
		while (j < array.length) {
		
			if (array[j] == prev + 1) {
				
				j = 0;
				++prev;
				
				temp.push(prev);
			} else {
				++j;
			}
		}
		
		if (temp.length > result.length) {
			
			result = temp;
		}
	}
	
	return result;
}

/*
   Time Complexity - O(N^2);
   Space Complexity - O(N);
*/


// Sorting
function getConsecutiveNumbers(array) {

	let result = []; 
	
	array.sort((n1, n2) => n1 - n2);
	
	let start = 0, end = 0, tempS = 0, tempE = 0, prev = array[0];
	for (let i = 1; i < array.length; i++) {
	
		if (prev == array[i] || array[i] - prev == 1) {
		
			tempE++;
		} else {
		
			if (tempE-tempS > end-start) {
				
				start = tempS;
				end = tempE;
			}
			
			++tempE;
			tempS = tempE;
		}
		
		if (tempE-tempS > end-start) {
				
			start = tempS;
			end = tempE;
		}
			
		prev = array[i];
	}
	
	let set = new Set();
	
	for (let i = start; i <= end; i++) {
		
		set.add(array[i]);
	}
	
	return set;
}

/*

Time Complexity - O(NlogN)
Space Complexity - O(N)

*/
