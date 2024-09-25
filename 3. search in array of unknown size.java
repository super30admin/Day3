// Time Complexity : O(log(N)) on average I think. 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        int low = 0, high = 1; //high can be 9999 given the range in constraints
        while (reader.get(high) < target) {
            low = high;
            high = 2*high;
        }

        while (low <= high){ //start binary search
            int mid = low + (high-low)/2;
            if (reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1; //ie number not present
    }


}
