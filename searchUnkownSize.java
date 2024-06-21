
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
/*
TC --> o(logn)
SC --> O(1)
 */
class Solution {

    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while ((reader.get(right) != Integer.MAX_VALUE) && (reader.get(right) < target)) {
            right *= 2;
        }//while
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = reader.get(mid);

            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }
}
