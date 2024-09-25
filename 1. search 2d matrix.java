// Time Complexity : O(log(mn))
// Space Complexity : O(1), constant space is used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m*n) - 1;

        while (low <= high){
            int mid = low + (high-low)/2;
            // visualize for the matrix to be of length m*n and index = m*n-1
            // doing index/n should give us the row number (r)
            // doing index%n should give us the column number (c)
            int r = mid/n;
            int c = mid%n;

            int num = matrix[r][c];

            if(num == target){ //base case
                return true;
            }

            else if (num < target){ //go right
                low = mid + 1;
            }
            else{ //go left
                high = mid - 1;
            }

        }
        return false;
    }
}
