//Search in 2D matrix
//TC:- log(m)*log (n)
//SC: o(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;

        while(low<=high) {
            int mid = low +(high - low)/2;
            int rowIdx = mid/n;
            int colIdx = mid%n;
            if(target == matrix[rowIdx][colIdx]) {
                return true;
            }
            else if(target < matrix[rowIdx][colIdx]) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return false;

    }
}
