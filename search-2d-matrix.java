// Time Complexity : O(Log(MxN)) Where M is number of rows and N is number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was immediately able to come up with a matrix solution but took a few mins to come with a binary search one
//Was able to come up with the logic as soon as I visualized it like a sorted array.


// Your code here along with comments explaining your approach in three sentences only
/*
    This logic treats the 2D matrix as a flat, sorted array.
    It performs binary search by calculating the middle element's position, converting it to matrix coordinates,
    and adjusting search bounds based on comparisons with the target until the target is found or the search concludes with no match.
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0; int h = m*n - 1;
        while(l <= h) {
            int mid = l + (h -l)/2;
            int r = mid/n;
            int c = mid%n;

            if( matrix[r][c] == target) {
                return true;

            } else if(matrix[r][c] > target) {
                h = mid -1;

            } else {
                l = mid +1;
            }
        }
        return false;
    }
}