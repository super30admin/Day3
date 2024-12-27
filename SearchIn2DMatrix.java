/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: No
 */

class SeachIn2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int low = 0;
    int high = m * n - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int row = mid / n; // find row of mid based on given no. of rows and cols.
      int col = mid % n; // find col of mid based on given no. of rows and cols.
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }
}