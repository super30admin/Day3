// Overall Time Complexity : O log(m*n) . The m is the number of rows and n is the number of columns.
// Overall Space Complexity : O(1) . The space complexity of storing the values in variables like row, col uses constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The matrix problem below approach of converting two dimensional array into one dimaensional array. 
// run the binary search algorithm on the 1 dimensional array to find the target element.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row  = matrix.length;
        int col  = matrix[0].length;

        if(row == 0) {
            return false;
        }

        int low = 0;
        int high = row * col -1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            int middle_ele = matrix[mid/col][mid%col];

            if(middle_ele == target){
                return true;
            }
            else if(middle_ele>target){
                 high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}