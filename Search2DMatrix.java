// Time Complexity :O(log(m*n)) m is the no of rows and n is the no of columns in the matrix
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int high = rows*columns-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int midRow = mid/columns;
            int midCol = mid%columns;
            if(matrix[midRow][midCol] == target) return true;
            if(target < matrix[midRow][midCol]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}