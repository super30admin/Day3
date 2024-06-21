// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
         int start =0;
         int cols = matrix[0].length;
         int rows = matrix.length;
         int end = cols*rows - 1;
        while(start <= end){
            int mid = (start + end)/2;
            int r = mid/cols;
            int c = mid % cols;
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] > target){
                end = mid-1;
            }else if(matrix[r][c] < target){
                start = mid +1;
            }
        }

        return false;
    }
}
