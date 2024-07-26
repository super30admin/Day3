/**
* Searching matrix using binary search
* The clue is that the time complexity is O(log(m*n)), that means at some point in the code I need rows* cols (m*n)
* And the fact that it is all an sorted increasing sequence means that it is a perfect candidate for binary search.
*/

// Time complexity = O(log(m*n))
// Space complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just wrapping my head around the rows * cols stuff and mid% col and mid/ col.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int elements = rows*cols;
        int low = 0;
        int high = elements-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            // find midpoint in series of elements.
            int searchVal = matrix[mid/cols][mid%cols];
            if(target == searchVal ) {
                return true;
            }else if(target < searchVal) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}