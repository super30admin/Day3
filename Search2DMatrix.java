// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    // Converting the 2D Matrix to a 1D array to obtain the required Time Complexity.
    int left = 0;
    int right = m*n - 1;
    while(left<=right) {
      // Using this formula instead of (left+right)/2 to avoid overflow.
      int mid = left + (right-left)/2;
      if(matrix[mid/n][mid%n] == target) return true;
      else if(matrix[mid/n][mid%n] < target) left = mid + 1;
      else right = mid - 1;
    }
    return false;
  }
}