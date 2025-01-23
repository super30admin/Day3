// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only  

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length, C = matrix[0].length;

        // flattened range if the 2D matrix were converted to a 1D array
        int l = 0, r = R*C-1;

        while(l <= r){
            int mid = (l+r)/2;

            //convert the 1D index to 2D coordinates
            int val_at_mid = matrix[mid/C][mid%C];

            if(val_at_mid == target){
                return true;
            }

            else if(val_at_mid > target){
                r = mid - 1;
            }

            else{
                l = mid + 1;
            }

        }
        return false;
    }
}