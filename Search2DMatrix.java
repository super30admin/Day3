// Time Complexity : O(log(m*n)) as binary search is performed along rows and columns of 2D matrix.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        int m = matrix.length; // number of rows
        int n = matrix[0].length ; // number of columns

        // Assuming 2D Matrix as 1D Array and considering the low as 1st position in array and
        // high as last position in array.

        int low = 0, high = m * n -1 ;

        while(low <= high){
            int mid = low + (high - low)/2 ; // to avoid ArrayIndexOutofBound exception.
            // to find the mid position of elements in the 2D matrix
            int row = mid / n;
            int col = mid % n;

            // if target if found at mid return true. If target is higher that mid then change low to mid+1 position.
            // If target is lower then change high to mid-1 position.

            if(target == matrix[row][col]){
                return true;
            }
            else if(target < matrix[row][col]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}
