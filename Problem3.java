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
    Approach - I have used the binary search algorithm to search an element. But, to define the low and high range, we are using multiply by 2 to 
    reduce the time complexity.
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while(target > reader.get(high)) {
            low = high;
            high = high * 2;
        }
        return binarySearch(reader, low, high, target);
    }
    private int binarySearch(ArrayReader reader, int low, int high, int target) {
        while(low<=high) {
            int mid = low + (high - low) / 2; // to prevent integer overflow
            if(reader.get(mid) == target) {
                return mid;
            } else if(target > reader.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}