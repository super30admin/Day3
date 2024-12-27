// TC : O(log(mn))
// SC :  O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// We did not flatten the array instead we found the exact location by using /cols and % cols.

class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = (rows * cols) - 1 ;

        while(low <= high){
            int mid = low + (high - low)/2;
            int mid_row = mid/cols;
            int mid_col = mid%cols;
            if(target < matrix[mid_row][mid_col]){
                high = mid - 1;
            }
            else if(target > matrix[mid_row][mid_col]){
                low = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
