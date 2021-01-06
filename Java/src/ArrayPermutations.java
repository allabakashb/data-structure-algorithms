import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayPermutations {

	public static void main(String[] args) {
		
		ArrayPermutations perm = new ArrayPermutations();
		
		perm.permute(new int[] {1, 2, 3});
		perm.heapPermutation(new int[] {1, 2, 3}, 3, 3);
	}

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> permutations = new LinkedList<>();

		permute(nums, nums.length - 1, permutations);

		return permutations;
	}

	private void permute(int[] nums, int size, List<List<Integer>> permutations) {

		if (size == 1) {

			List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
			permutations.add(list);
		}

		for (int i = 0; i < size; i++) {

			permute(nums, size - 1, permutations);

			if (i % 2 == 1) {

				swap(nums, 0, size - 1);
			} else {

				swap(nums, size - 1, i);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	//Prints the array 
    void printArr(int a[], int n) 
    { 
        for (int i=0; i<n; i++) 
            System.out.print(a[i] + " "); 
        System.out.println(); 
    } 
  
    //Generating permutation using Heap Algorithm 
    void heapPermutation(int a[], int size, int n) 
    { 
        // if size becomes 1 then prints the obtained 
        // permutation 
        if (size == 1) 
            printArr(a,n); 
  
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(a, size-1, n); 
  
            // if size is odd, swap first and last 
            // element 
            if (size % 2 == 1) 
            { 
                int temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            } 
  
            // If size is even, swap ith and last 
            // element 
            else
            { 
                int temp = a[i]; 
                a[i] = a[size-1]; 
                a[size-1] = temp; 
            } 
        } 
    } 

}
