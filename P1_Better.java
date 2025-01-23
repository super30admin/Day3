class Solution {

    private boolean binarySearch(int[] nums, int target) {
        int n = nums.length; 
        int lb = 0, ub = n - 1;     //lb = lower bound, ub = upper bound 

        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            else if (target > nums[mid]) {
                lb = mid + 1;
            }
            else {
                ub = mid - 1;
            }
        }
        return false;
    }
    
    
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat.length == 0 || mat[0].length == 0) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (mat[i][0] <= target && target <= mat[i][m - 1]) {       // checking if the first and last element of each row fit the criteria in order to perform binary search 
                return binarySearch(mat[i], target);
            }
        }
        return false; 
    }
}

// Time Complexity :    O(N + logM). Traversing N rows and performing binary search only once on one particular row. 
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    had to think hard about this solution because it is very close to the most optimal sol. 


/* 
Your code here along with comments explaining your approach in three sentences only-

Traversing rows and checking if the target fits the criteria in which it is greater than the first element and lesser than the last element of that particular row,
if yes then we go ahead and perform binary search on that row. 

*/ 
