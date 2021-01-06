import java.util.Comparator;

public class KnapSack {

	public static void main(String[] args) {

		int val[] = random(10000);
        int wt[] = random(1000);
        
        System.out.println(solve(val, wt, 20000));
	}
	
	public static int[] random(int startCount) {
		
		int[] array = new int[20000];
		
		for (int i = 0; i < 20000; i++) {
			
			array[i] = (int) (Math.random() * startCount + startCount);
		}
	
		return array;
	}

	public static int solve(int[] values, int[] weights, int maxWeight) {

		int[][] valueMatrix = new int[values.length + 1][maxWeight + 1];

		for (int v = 1; v <= values.length; v++) {

			for (int w = 1; w <= maxWeight; w++) {

				if (weights[v - 1] > w) {
					valueMatrix[v][w] = valueMatrix[v - 1][w];
				} else {

					valueMatrix[v][w] = Math.max(valueMatrix[v - 1][w],
							values[v - 1] + valueMatrix[v - 1][w - weights[v - 1]]);
				}
			}
		}
		
		/*
		 * for (int v = 0; v <= values.length; v++) {
		 * 
		 * for (int w = 0; w <= maxWeight; w++) {
		 * 
		 * System.out.print(valueMatrix[v][w] + " "); }
		 * 
		 * System.out.println(""); }
		 */
		
		int i = values.length, j = maxWeight;
		
		int sum = 0, valSum = 0;
		while (i >= 0) {
			
			if (valueMatrix[i][j] == valueMatrix[i][j-1]) {
				
				--j;
			} else if (valueMatrix[i][j] == valueMatrix[i-1][j]) {
				
				--i;
			} else {
				
				System.out.println(weights[i-1] + "(" + values[i-1] + ")");
				
				if (sum+weights[i-1] > maxWeight) {
					
					break;
				}
				sum += weights[i-1];
				valSum += values[i-1];
				j = j - weights[i-1];
				--i;
			}
			
			if (j <= 0) {
				
				--i;
				j = maxWeight;
			}
		}
		
		System.out.println("actual :: " + sum + "(" + valSum + ")");

		return valueMatrix[values.length][maxWeight];
	}

}
