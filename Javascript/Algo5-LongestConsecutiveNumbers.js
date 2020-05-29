
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
