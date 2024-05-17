// Time Complexity : O(log(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
// Find appropriate row and colum for given index of element.
// perform binary search by getting element matrix[row][column]
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix ==null){
            return false;
        }
        int m = matrix.length; // rows
        int n = matrix[0].length; //columns
        int low = 0;
        int high = m*n -1;

        while(low <= high){
            int mid = low + high /2;
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target){
                return true;
            }
            else if (target > matrix[row][col]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
}