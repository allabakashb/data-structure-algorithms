function heapsort(array, asc) {
	
	let size = array.length;
	
	function hasLeftChild(index) {
	
		return leftChild(index) < size;
	}
	
	function hasRightChild(index) {
	
		return rightChild(index) < size;
	}
	
	function leftChild(index) {
		
		return 2 * index + 1;
	}
	
	function rightChild(index) {
		
		return 2 * index + 2;
	}
	
	function swap(index1, index2) {
		let temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	function heapifyDown(index) {
	
		while (hasLeftChild(index)) {
		
			let sortingIndex = leftChild(index);
			
			if (hasRightChild(index)) {
							
				if ((asc && array[rightChild(index)] > array[sortingIndex]) || 
				(!asc && array[rightChild(index)] < array[sortingIndex])) {
				
					sortingIndex = rightChild(index);
				}
			}
						
			if ((asc && array[sortingIndex] > array[index]) || (!asc && array[sortingIndex] < array[index])) {
			
				swap(sortingIndex, index);
			} else {
			
				break;
			}
			
			index = sortingIndex;
		}
	}
	
	function convertToHeap() {
		
		let mid = Math.floor(size / 2);
		
		while (mid >= 0) {
		
			heapifyDown(mid);
			--mid;
		}
	}
	
	function extractItems() {
		
		while (size-- > 0) {
		
			let temp = array[size];
			array[size] = array[0];
			array[0] = temp;
			
			heapifyDown(0);
		}
	}
	
	convertToHeap();
	extractItems();
}

function test(len, asc) {
	
	let array = [];
	
	let input = '';
	for (let i = 0; i < len; i++) {
		
		array[i] = Math.floor(Math.random() * (len-1));
		input += array[i] + ' ';
	}
	
	console.log('INPUT => ' + input);
	
	heapsort(array, asc);

	let output = '';
	for (let i = 0; i < len; i++) {
		
		output += array[i] + ' ';
	}
	
	console.log('OUTPUT => ' + output);
}

/*

Time Complexity - O(N*logN)
Space Complexity - O(1)

*/
