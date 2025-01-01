// Time Complexity: O(m log n), where m is the number of rows and n is the size of the column
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only

/**
 * Approach: 
 * In this problem, I have traversed through each row and and applied Binary search to find the target
 * We are doing an optimization where if the element is between the low and high of a row, then only we do binary search
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Traverse through each row in the matrix
        for (int i = 0; i < matrix.length; i++) {
            // Get the first and last element of the current row
            int low = matrix[i][0];    
            int high = matrix[i][matrix[i].length - 1];

            // Check if the target could be within the range of the row's first and last elements
            if (target >= low && target <= high) {   

                // Apply binary search within the current row
                int left = 0;
                int right = matrix[i].length - 1;

                // Binary search to find the target
                while (left <= right) {

                    // Calculate the middle index
                    int mid = left + (right - left) / 2;

                    // Check if the middle element is the target
                    if (matrix[i][mid] == target) {
                        return true;  // Return true if target is found
                    } else if (matrix[i][mid] < target) {
                        left = mid + 1;  
                    } else {
                        right = mid - 1;  
                    }

                }
            }

        }
        // Return false if the target is not found in any row
        return false;
    }
}
