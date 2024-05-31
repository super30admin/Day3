class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }

        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of cols
        int low = 0; // low index
        int high = m * n - 1; // high index, row * col - 1

        while(low <= high){
            int middle = low + (high - low) / 2;
            int row = middle / n; // division sign to get row
            int col = middle % n; // modulus to get col 
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                low = middle + 1;
            }
            else{
                high = middle - 1;
            }
        }
        return false;
    }
}