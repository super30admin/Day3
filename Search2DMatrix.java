class Solution {
    // Time Complexity: O(log(m*n))
    // Space Complexity: O(1)
    // thought process: we take the x and y axis and convert it into a 1D array and then apply binary search on it
    // we get the row and column by using division and modulus respectively
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length ==0){
            return false;
        }
       int low = 0 ;
       int high = (matrix.length * matrix[0].length)-1;
       // m is not used
       
        int m = matrix.length;
        int n = matrix[0].length;
       while (low <= high) {
        int mid = low + (high - low) / 2;
        int row = mid /n;
        int col = mid %n;
        if (matrix[row][col] > target){
            high = mid -1;
        } else if (matrix[row][col] < target){
            low = mid +1;
        } else {
            return true;
        }
       }
       return false; 
    }
}