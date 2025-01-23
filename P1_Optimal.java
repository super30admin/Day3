class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int lb = 0, ub = n * m - 1;     

        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;

            int row = mid / m;
            int col = mid % m;

            if (mat[row][col] == target) {
                return true;
            }
            else if (mat[row][col] < target) {
                lb = mid + 1;
            }
            else {
                ub = mid - 1;
            }
        }
        return false;
    }
}

// Time Complexity :    O(log(n*m))
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
/* 

Any problem you faced while coding this : I knew firsthand how to apply binary search on this problem but could not figure out a way to calculate the coordinates for mid.
Still unable to fully understand why we do mid/m and mid % m.

*/
/* 
Your code here along with comments explaining your approach in three sentences only - 

We will try to imagine the 2D array as a 1D array and apply Binary search to it.

*/