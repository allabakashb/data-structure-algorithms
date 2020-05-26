```javascript

function getMaxValue(w, v, maxWeight) {

	let dp = [];
	
	for (let i = 0; i <= w.length; i++) {
		
		dp[i] = [];
		for (let j = 0; j <= maxWeight; j++) {
		
			dp[i][j] = 0;
		}
	}
	
	for (let i = 1; i <= w.length; i++) {
		
		for (let j = 1; j <= maxWeight; j++) {
		
			if (w[i-1] <= j) {
			
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]] + v[i-1]);
			} else {
			
				dp[i][j] = dp[i-1][j];
			}
		}
	}
	
	print(dp, w, v, maxWeight);
	
	return dp[w.length][maxWeight];
}

function print(dp, w, v, maxWeight) {

	let i = dp.length-1, j = maxWeight;
	
	let result = '';
	while (i > 0 && j > 0) {

		if (dp[i][j] == dp[i][j-1]) {
				
			--j;
		} else if (dp[i][j] == dp[i-1][j]) {

			--i;
		} else {
		
			result += w[i-1]+'('+ v[i-1] + ') ';
			j = maxWeight - w[i-1];
			--i;
		}
	}

	console.log(result);
}

```
