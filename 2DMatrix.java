// Time Complexity : O(log m * n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length; //Calculates the length of matrix which is the value of row
        int col = matrix[0].length; //Calculates the length of matrix column 1 which is the value of column

        int low = 0;
        int high = row * col - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int midRow = mid / col; //Calculates the row coordinate of the middle element
            int midCol = mid % col; //Calculates the col coordinate of the middle element

            if (matrix[midRow][midCol] == target){ //If the element at mid is equal to target
                return true;
            }
            if (target < matrix[midRow][midCol]){
                high = mid - 1; //Moves left
            } else {
                low = mid + 1; //Moves right
            }
        }
        return false;
    }
}