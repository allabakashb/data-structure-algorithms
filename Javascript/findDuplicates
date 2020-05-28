function findDuplicates(array) {
	
	let set = new Set();
	
	for (let i = 0; i < array.length; i++) {
		
		let index = Math.abs(array[i]) - 1;
		
		if (array[index] < 0) {
		
			set.add(array[i]);
		} else {
		
			array[index] = -array[index];
		}
	}
	
	return set;
}

/*

Time Complexity - O(N)
Space Complexity - O(1)

*/
