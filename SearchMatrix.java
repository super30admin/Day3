// Time Complexity : O(log m*n) where m is no of rows, and n is no of columns
// Space Complexity : no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
//treating matrix as a flattened single sorted array and perform binary search on it
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = 0;
        int high = rows * columns - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / columns;
            int column = mid % columns;
            if (matrix[row][column] == target) return true;
            else if (matrix[row][column] > target) {
                high = mid - 1;
            } else low = mid + 1;

        }
        return false;
    }
}
