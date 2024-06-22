/*
    Time Complexity: 0(log(rows*columns))
    Space Complexity: 0(1)
    Approach: Convert 2D Matrix into 1D array and perform binary search
    Find the mid, get the row index & column index and perform binary search accordingly
*/
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        boolean flag = false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = rows*columns-1;
        int mid = 0;

        while (low <= high){
            mid = (high-low)/2 + low;

            // get index r and c of the matrix
            int r = mid/columns;
            int c = mid%columns;

            int midNumber = matrix[r][c];

            if (midNumber == target){
                flag = true;
                break;
            }
            else if (midNumber < target) {
                // target on rhs
                low = mid+1;
            }
            else {
                // target on lhs
                high = mid - 1;
            }
        }
        // end of while loop
        return flag;

    }
}