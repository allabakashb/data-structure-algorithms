function PriorityQueue(comparator) {
	
	let array = [];
	let size = 0;
	
	if (comparator == null || comparator == undefined || comparator instanceof Function == false) {
	
		comparator = function(num1, num2) {
			
			return num1 - num2;
		};
	}
	
	function hasLeftChild(index) {
	
		return leftChild(index) < size;
	}
	
	function hasRightChild(index) {
	
		return rightChild(index) < size;
	}
	
	function hasParent(index) {
	
		return parent(index) >= 0;
	}
	
	function leftChild(index) {
		
		return 2 * index + 1;
	}
	
	function rightChild(index) {
		
		return 2 * index + 2;
	}
	
	function parent(index) {
		
		return Math.floor(index - 1 / 2);
	}
	
	function swap(index1, index2) {
		let temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	function peek() {
	
		if (size == 0) throw new Error("PriorityQueue is Empty..");
		
		return array[0];
	}
	
	function add(num) {
	
		array[size++] = num;
		
		heapifyUp(size-1);
	}
	
	function poll() {
		
		if (size == 0) throw new Error("PriorityQueue is Empty..");
	
		let item = array[0];
		
		array[0] = array[size-1];
		
		heapifyDown(0);
		
		--size;
		
		return item;
	}
	
	function heapifyUp(index) {
	
		while (hasParent(index)) {
		
			let parentIndex = parent(index);
			
			if (comparator(array[parentIndex], array[index]) > 0) {
			
				swap(parentIndex, index);
			} else {
			
				break;
			}
			
			index = parentIndex;
		}
	}
	
	function heapifyDown(index) {
	
		while (hasLeftChild(index)) {
		
			let smallestIndex = leftChild(index);
			
			if (hasRightChild(index) && comparator(array[rightChild(index)], array[smallestIndex]) < 0) {
			
				smallestIndex = rightChild(index);
			}
			
			if (comparator(array[smallestIndex], array[index]) < 0) {
			
				swap(smallestIndex, index);
			} else {
				
				break;
			}
			
			index = smallestIndex;
		}
	}
	
	this.peek = peek;
	this.add = add;
	this.poll = poll;	
}

function test() {
	
	let pq = new PriorityQueue((n1, n2) => { return n2 - n1 }); //MAX HEAP
	
	for (let i = 0; i < 15; i++) {
		
		if (i > 0)
		console.log('current peak ' + pq.peek());
		let gen = Math.floor(Math.random() * 10);
		pq.add(gen);
		console.log('After Adding ' + gen + ' peak again -> ' + pq.peek());
	}
	
	let str = '';
	
	for (let i = 0; i < 15; i++) {
	
		str += pq.poll() + ' ';
	}
	
	console.log(str);
}
