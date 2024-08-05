// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = high * 2;
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}