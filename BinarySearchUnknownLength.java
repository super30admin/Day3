// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Couldn't run this problem as I dont have Leetcode Premium

// Your code here along with comments explaining your approach in three sentences only
// We first have to find the range in which the target elements lies. 
// After the range is found, we use Binary search to find the target.

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right = 2 * right;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}