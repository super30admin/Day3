// Time Complexity : O (log m + log n) = O ( log (mn) )
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
  Do a binary search first to find the row that the target might lie in
  If no row is found, return false
  Then do a binary search on the found row for the target.
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m - 1;
        int mid;
        int row = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if(matrix[mid][0] <= target && target <= matrix[mid][n - 1]) {
                row = mid;
                break;
            } else if(matrix[mid][0] > target) {
                high = mid - 1;
            } else if(matrix[mid][n - 1] < target) {
                low = mid + 1;
            }
        }
        if (row == -1) return false;
        low = 0;
        high = n - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
