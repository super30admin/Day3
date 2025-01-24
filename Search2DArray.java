// Time Complexity : O(log m + log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// 1. Binary search on the rows to locate the row that might contain the target.
// 2. Binary search on that row to locate the target within the columns.


public class Search2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int innerLength = matrix[0].length;

        int low = 0; int high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target && matrix[mid][innerLength - 1] >= target) {
                low = 0;
                high = innerLength - 1;
                while (low <= high) {
                    int innerMid = low + (high - low) / 2;
                    if (matrix[mid][innerMid] == target) return true;
                    if (matrix[mid][innerMid] > target) {
                        high = innerMid - 1;
                    } else {
                        low = innerMid + 1;
                    }
                }
                return false;
            }

            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
