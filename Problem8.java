// Time Complexity : O(log(m * n)) where m is the number of rows and n is the number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Use binary search on the matrix treating it as a flattened 1D array.

class Problem8 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // If the matrix is null or empty, return false.
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Convert the 1D index to 2D indices
            int midValue = matrix[mid / n][mid % n];

            // If target is found, return true
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        // If the target is not found, return false
        return false;
    }
}
