// Time Complexity : O(log(m*n)) - performing binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Calculate the no of rows and columns of given matrix
        int m = matrix.length;
        int n = matrix[0].length;
        // Set the low and high value to start binary search
        int low = 0;
        int high = m * n - 1;
        // When low is less than or equal to high, come out of the loop
        while (low <= high) {
            // Calculate the mid in below way to avoid integer overflow exception
            int mid = low + (high - low) / 2;
            // For mid position of 2D matrix, calculate row and column position
            /*
             * Since while creating we divide the integers in n columns,
             * therefore while calcuting row of 2d matrix we will multiply by n
             */
            int row = mid / n;
            /*
             * Since there is range 0 to n-1 for each row, we will perform mod
             * for calculating column
             */
            int col = mid % n;
            // If the mid element if equal to target, return true
            if (matrix[row][col] == target) {
                return true;
            }
            // Else check if target is smaller than mid, perform binary search in left part
            if (target < matrix[row][col]) {
                high = mid - 1;
            } else {
                // Else check if target is greater than mid, perform binary search in right part
                low = mid + 1;
            }
        }
        // If not found, return false
        return false;
    }
}