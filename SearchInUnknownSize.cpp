// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int l = 0;
        int r = 1;
        while (reader.get(r) < target) {
            l = r;
            r = r*2;
        }
        while(l<=r) {
            int mid = l + (r-l)/2;
            if (reader.get(mid) == target) return mid;
            if (reader.get(mid) < target) l = mid+1;
            else r = mid-1;
        }
        return -1;
    }
};