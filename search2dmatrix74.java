// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Binary search over rows to establish range and then binary search over columns to find target.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) return false;

        int rl = 0;
        int rh = matrix.length-1;
        int rmid = 0;
        while(rl <= rh){
            rmid = rl + (rh-rl)/2;

            if(matrix[rmid][0] <= target && matrix[rmid][matrix[0].length-1] >= target){
                break;
            }

            if(target > matrix[rmid][matrix[0].length-1]){
                rl = rmid+1;
            }
            else{
                rh = rmid-1;
            }
        }

        int l = 0;
        int h = matrix[0].length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(matrix[rmid][mid] == target) return true;

            if(matrix[rmid][mid]<target){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return false;

    }
}