// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : no


class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        // Increase high exponentially until target is less than reader.get(high)
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        // Standard binary search within the range [low, high]
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Corrected mid calculation
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;  // Return -1 if the target is not found
    }
}