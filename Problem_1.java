// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Used binary search on virtual representation of flattened array of 2D matrix

class Solution2Dmatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            int row = mid / n;
            int col = mid % n;
            if(target == matrix[row][col]) {
                return true;
            } else if(target > matrix[row][col]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
