// time complexity log(m * n) which is log m + log n
// space complexity

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        int n = matrix.length; //number of rows
        int m = matrix[0].length; // number of columns

        int low = 0;
        int high = n*m -1;
        while(low <=high){
            int mid = low + (high - low)/2;
            int r = mid / m;
            int c = mid % m;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target){
                
                low = mid + 1;
            }else{
                high = mid-1;
            }
        } 
        return false;
    }
}