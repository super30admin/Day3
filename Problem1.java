// Time Complexity : O(logn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

// 1. The code uses binary search to find a target value in a 2D matrix by treating the matrix as a single sorted array.
// 2. Calculated the row and column of the middle element from the index of the middle value.
// 3. By comparing the target value with the middle element and adjusting the search range, the method efficiently narrows down the search until it finds the target or determines that the target is not present.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; int n = matrix[0].length;
        int low = 0; int high = m*n -1;

        while(low <=high){
            int mid = low + (high -low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
      return false;
    }
}