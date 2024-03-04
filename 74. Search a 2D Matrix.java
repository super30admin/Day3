// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/search-a-2d-matrix/
// Any problem you faced while coding this : No


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c]==target){
                return true;
            }else if(matrix[r][c]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}
