// Time complexity: O(log(m*n))
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int low = 0;
        int high = (rows * cols) - 1;
        
        while(low <= high){
            int mid = (low + high)/2;
            int midRow = mid / cols;
            int midCol = mid % cols;
            
            if( matrix[midRow][midCol] == target){
                return true;
            } else if(matrix[midRow][midCol] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
