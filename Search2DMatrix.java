// Time Complexity : O(log mn)
// Space Complexity :
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this :


// since the elements in the 2D matrix are in non decreasing order, this can be considered as an array of sorted items in ascending order. 
// Hence Binary search can be performed considering low and high elements
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n -1;
        while (low <= high) {
            int mid = low + (high - low)/ 2; // To avoid Integer Overflow
            int row = mid /n ;
            int col = mid % n;
            if(matrix[row][col] == target) {
                return true;
            }
            else if(matrix[row][col] > target) {
                high = mid -1;
            }
            else {
                low = mid +1;
            }
        }
        return false;
    }
}