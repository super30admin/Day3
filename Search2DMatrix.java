
// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : To find the rowIndex and colIndex.

//The logic here is to visualize the 2d matrix into 1d matrix.
// values to learn that row = mid / col; and col = mid % col;
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //base case
        if(matrix == null || matrix.length == 0){
            return false;
        }
        //m = length of rows , n = length of columns
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n-1;

        while(low <= high){
            int mid = low + (high-low)/2; //why this? because we want to prevent integer overloading.

            int rowIndex = mid / n;
            int colIndex = mid % n;

            if(matrix[rowIndex][colIndex] == target){
                return true;
            }
            else if(matrix[rowIndex][colIndex] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}