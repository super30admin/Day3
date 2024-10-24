//74. Search in 2D sorted Matrix - https://leetcode.com/problems/search-a-2d-matrix/description/
//Time Complexity: log(m*n) ~ log(m) + log(n)
//Space Complexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        ////converting 2D to 1D
        int low = 0;
        int high = m*n-1;
        //do binary search
        while(low <= high){
            int mid = low + (high-low)/2;
            //finding the index of the mid
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}