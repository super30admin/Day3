/*
 * Approach : finding 2d array elements using binary search algo
 * Time complexity: O(log mn)
 * Space complexity: O(1)
 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1 ; //max length for the index array
        int mid = (low + (high - low))/2;

        while(low <= high) {
            mid = low + (high - low)/2; // high-low to avoid integer overload in java
            int row = mid/n;
            int col = mid%n;
            if (target == matrix[row][col]) {
                return true;
            } else if(target > matrix[row][col]) {
                low = mid + 1; //moving right
            } else {
                high = mid -1; // moving left
            }
        }
        return false;
    }
}