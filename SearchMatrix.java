// Time Complexity : O(log mn) where m is the number of rows and n is the number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// 1. I have used binary search to find the target element in the matrix. I have considered the matrix as a single array and found the mid element.
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            int row = mid/n;
            int col = mid%n;

            if(matrix[row][col] == target){
                return true;
            }else if(target > matrix[row][col]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}
