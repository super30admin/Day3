/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

/*
    Leetcode Problem - 702 (search-in-a-sorted-array-of-unknown-size)
    TC - O(log n)
    SC - O(1)
    Approach - I have used the binary search algorithm to search an element.
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 10000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return reader.get(low) == target ? low : -1;
    }
}