/*
TC - O(log(m*n)) - m and n represents rows and columns of the matrix
SC - O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int rows = matrix.length;
        int totalElements = (rows * cols) - 1;
        int low = 0;
        int high = totalElements;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int midValue = matrix[mid/cols][mid%cols];
            if(midValue == target) {
                return true;
            }
            if(midValue < target) {
                low = mid + 1;
            }
            else {
                high = mid -1;
            }
        }
        return false;

    }
}