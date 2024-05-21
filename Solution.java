// Time Complexity : O(log(m * n))
// Space Complexity : O(1) => Constant space compleexity as we are not utizlizing additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Miscalculated the value of high variable

//Used binary search and calculated index of row and column to find the middle element
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Base Case
        if (matrix.length == 0 || matrix == null)
            return false;

        int m = matrix.length; // No. of rows
        int n = matrix[0].length; //No. of columns
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; //This prevents Integer overflow
            int row = mid / n; //Calcultes the row for the mid element
            int column = mid % n; //Calcultes the column for the mid element (Used % operator to wrap in a range)

            if (matrix[row][column] == target)
                return true;
            else if (target > matrix[row][column])
                low = mid + 1;
            else
                high = mid - 1;

        }
        return false;
    }
}