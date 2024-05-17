/**
 * Approach: considering the 2d matrix as 1d matrix and performing the binary search
 *
 * Time Complexity: O(log mn)
 * Space Complexity: O(1)
 */

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {


        if(matrix == null || matrix.length == 0){
            return false;
        }


        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n-1;

        while(low<=high){

            int mid = low + (high-low)/2; // the mid index in a 1D matrix, formula used to prevent integer overflow

            //For obtaining the index of the element in th 2d matrix
            int row = mid/n;
            int col = mid%n;

            int midVal = matrix[row][col];

            if(midVal == target) {
                return true;
            }
            else if(midVal>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return false;

    }
}