// Time Complexity : log m + log n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only


/*
I have applied binary search for columns first then when i found the column
i have applied binary search in the row thus time complexity is log m + log n
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int high = m;
        int row = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(matrix[mid][0] == target || matrix[mid][n] == target) return true;
            if(matrix[mid][0] > target) high = mid - 1;
            else if(matrix[mid][n] < target) low = mid + 1;
            else {
                row = mid;
                low = 0;
                high = n;
                break;
            }
        }
        while(low <= high){
             int mid2 = low + (high-low)/2;
             if(matrix[row][mid2] == target) return true;
             if(matrix[row][mid2]<= target) low = mid2 + 1;
             else high = mid2 - 1;
        }
        return false;
    }
}