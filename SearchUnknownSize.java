// Time Complexity : O(log n)
// Space Complexity : O(1) => Constant space compleexity as we are not utizlizing additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Started with considering having 2 elements and then setting the value of low to high and multiplying high * 2 (multiplying by 2 to maintain logarithmic TC )
 */

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;

        }
        return binarySearch(low, high, target, reader);
    }

    private int binarySearch(int low, int high, int target, ArrayReader reader) {
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (target < reader.get(mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}