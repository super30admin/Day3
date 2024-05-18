//Time Complexity : O(logm*n)
//Space Complexity :  O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
//In this code, we try to flatten the 2D array into a 1D array and reference the row of the 2D matrix as
// integer / n and to find the column, we use the integer % n . Apply binary search on this. 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target){
                return true;
            }
            if(target > matrix[row][col]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
}