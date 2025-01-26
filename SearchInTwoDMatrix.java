// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * We use Binary Search in between 0 to m*n -1. Suppose this matrix is flattened then mid is matrix[mid/col][mid%col].
 * If we have total m*n elements and n columns then row= m*n/n. THis logic is used to find row in matrix from mid.
 *
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int left=0;
        int right=row*col-1;
        while(left<right){
            int mid=left+(right-left)/2;
            int r=mid/col;
            int c=mid%col;
            if(matrix[r][c]==target){
                return true;
            }else if(target<matrix[r][c]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        if(matrix[left/col][left%col]==target){
            return true;
        }
        return false;
    }
}