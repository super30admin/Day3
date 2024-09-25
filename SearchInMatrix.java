// We will be solving the problem by considering the whole 2D matrix into a single array where each index in the 1D array can be correlated to the index in matrix using / and % operators.
// After this since we are having a strictly ascending numbers in the matrix, it wuld be very efficient to use binary search to search the element in the matrix.
// Time complexity would be log(k) where k = m*n where m is number of rows and n is number of columns.
// No extra matrices or arrays are used. hence the space complexity would be O(1).

// The solution is successfully submitted in leetcode.

class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length;
        int l=0, h = (rows* columns)-1;
        int m;
        while(l<=h){
            m = l + (h-l)/2;
            int value = matrix[m/columns][m%columns];
            if( value == target){
                return true;
            }
            else if(value < target){
                l=m+1;
            }
            else{
                h = m-1;
            }
        }
        return false;
        
    }
}