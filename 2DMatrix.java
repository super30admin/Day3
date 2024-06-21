// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only:
//Consider the 2D matrix as a single array and did binary search on it.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows * cols, mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (matrix[mid / cols][mid % cols] < target)
                l = mid + 1;
            else if (matrix[mid / cols][mid % cols] > target)
                r = mid;
            else
                return true;
        }
        return false;
    }
}