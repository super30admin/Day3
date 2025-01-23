class Solution {
    public int search(ArrayReader reader, int target) {
        int lb = 0;
        int ub = 1;

        while (reader.get(ub) < target) {
            lb = ub;
            ub = ub * 2;
        }

        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;

            if (reader.get(mid) == target) {
                return mid;
            }

            if (reader.get(mid) < target) {
                lb = mid + 1;
            }
            else {
                ub = mid - 1;
            }
        }
        return -1;
    }
}

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : did not have leetcode premium


// Your code here along with comments explaining your approach in three sentences only - had to watch the solution in order to understand the problem -> doubling the boundary technique