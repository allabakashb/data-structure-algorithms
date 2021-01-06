package com.leetcode.practice;

import java.util.Stack;

public class Problem85 {

	public static void main(String[] args) {
		
		char[][] array = {
		  {'1','0','1','0','0'},
		  {'1','0','1','1','1'},
		  {'1','1','1','1','1'},
		  {'1','0','0','1','0'}
		};

		System.out.println(Problem85.getMaxArea(new int[]{1, 0, 2, 1, 1}, 5));
		System.out.println(Problem85.getHistogramMaxArea(new int[]{1, 0, 2, 1, 1}));
	}

	public static int maximalRectangle(char[][] matrix) {

		int maxArea = 0;

		if (matrix.length == 0 || matrix[0].length == 0)
			return maxArea;

		int m = matrix.length;
		int n = matrix[0].length;

		int[] result = new int[n];

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (matrix[i][j] == '0') {

					result[j] = 0;
				} else {

					result[j] += Character.getNumericValue(matrix[i][j]);
				}
			}

			//maxArea = Math.max(maxArea, getHistogramMaxArea(result));
		}

		return maxArea;
	}

	private static int getHistogramMaxArea(int[] array) {

		Stack<Integer> st = new Stack<>();

		int maxArea = 0;
		for (int i = 0; i < array.length;) {

			if (!st.isEmpty() && array[st.peek()] > array[i]) {

				maxArea = Math.max(getArea(st, array[st.pop()], i), maxArea);
			} else {

				st.push(i++);
			}
		}

		while (!st.isEmpty()) {

			maxArea = Math.max(getArea(st, array[st.pop()], array.length), maxArea);
		}

		return maxArea;
	}

	private static int getArea(Stack<Integer> st, int top, int i) {

		int area = 0;

		if (st.isEmpty()) {

			area = top * i;
		} else {

			area = top * (i - st.peek() - 1);
		}

		return area;
	}
	
	static int getMaxArea(int hist[], int n)  
    { 
        // Create an empty stack. The stack holds indexes of hist[] array 
        // The bars stored in stack are always in increasing order of their 
        // heights. 
        Stack<Integer> s = new Stack<>(); 
          
        int max_area = 0; // Initialize max area 
        int tp;  // To store top of stack 
        int area_with_top; // To store area with top bar as the smallest bar 
       
        // Run through all bars of given histogram 
        int i = 0; 
        while (i < n) 
        { 
            // If this bar is higher than the bar on top stack, push it to stack 
            if (s.empty() || hist[s.peek()] <= hist[i]) 
                s.push(i++); 
       
            // If this bar is lower than top of stack, then calculate area of rectangle  
            // with stack top as the smallest (or minimum height) bar. 'i' is  
            // 'right index' for the top and element before top in stack is 'left index' 
            else
            { 
                tp = s.peek();  // store the top index 
                s.pop();  // pop the top 
       
                // Calculate the area with hist[tp] stack as smallest bar 
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
                // update max area, if needed 
                if (max_area < area_with_top) 
                    max_area = area_with_top; 
            } 
        } 
       
        // Now pop the remaining bars from stack and calculate area with every 
        // popped bar as the smallest bar 
        while (s.empty() == false) 
        { 
            tp = s.peek(); 
            s.pop(); 
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
            if (max_area < area_with_top) 
                max_area = area_with_top; 
        } 
       
        return max_area; 
  
    }

}
