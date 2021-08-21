// Time Complexity : o(log(mn))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix==null || matrix.length==0)return false;
        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid= low + (high-low)/2;
            int r = mid/n;
            int c = mid %n;
            if(matrix[r][c]==target)return true;
            else if(matrix[r][c]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}