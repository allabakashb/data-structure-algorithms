function medianOfTwoSortedArrays(x, y) {
	
	let m = x.length, n = y.length;
	let start = 0, end = m;
	
	if (m == 0) {
	
		return getAvg(y);
	} else if (n == 0) {
	
		return getAvg(x);
	}
	
	while (start <= end) {
		
		let px = Math.floor((start + end) / 2);
		let py = Math.floor((m+n+1)/2) - px;
		
		let maxLeftx = px > 0 ? x[px-1] : -Infinity;
		let minRightx = px < m ? x[px] : Infinity;
		let maxLefty = py > 0 ? y[py-1] : -Infinity;
		let minRighty = py < n ? y[py] : Infinity;
		
		if (maxLeftx <= minRighty && maxLefty <= minRightx) {
		
			let m1 = Math.max(maxLeftx, maxLefty);
			
			if ((m+n) % 2 == 0) {
			
				let m2 = Math.min(minRightx, minRighty);
				
				return ((m1 + m2)) / 2;
			} else {
			
				return m1;
			}
		} else if (maxLeftx > minRighty) {
		
			end = px - 1;
		} else {
		
			start = px + 1;
		}
	}
	
	function getAvg(arr) {
	
		if (arr.length == 0) return -1;
				
		let mid = Math.floor(arr.length/2);
					
		if (arr.length % 2 == 0) {
		
			return (arr[mid-1] + arr[mid]) / 2;
		} else {
		
			return arr[mid];
		}
	}
	
	return -1;
}

/*

Time Complexity - O(logN)
Space Complexity - O(1)
*/
