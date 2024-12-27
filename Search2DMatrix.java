class Solution {
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