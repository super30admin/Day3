// Time Complexity: O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
package Interview;

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
	            {1, 2, 3},
	            {4, 5, 6},
	            {7, 8, 9}
	    };
		
		System.out.println(searchTarget(matrix,10));
		                                   

	}
	public static boolean searchTarget(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int low = 0;
		int high = m*n-1; // last index of the matrix
		while(low<=high) {
			int mid = low + (high-low)/2;
      //important formula
			int row= mid/n; // to calculate the row index.                         
			int col = mid%n; // to calculate the col index.
			if(matrix[row][col] == target) {
				return true;
			}else if(matrix[row][col] > target) {
				high = mid -1;
			}else {
				low = mid+1;
			}
		}		
		return false;
	}

}
