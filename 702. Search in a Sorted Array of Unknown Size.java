// Time Complexity : O(log n)
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
        int low = 0;
        int high = 1;

        while(low < high){
            int mid = low + (high - low)/2;
            // check mid exists
            if(reader.get(mid) == Integer.MAX_VALUE){
                // mid doesn't exist
                high = mid-1;
                continue;
            }

            // narrow down the range
            int num = reader.get(mid);
            if(num == target){
                return mid;
            } else if(num < target){
                // double the range
                low = mid+1;
                high *= 2;
            } else {
                high = mid-1;
            }
        }

        return reader.get(low) == target ? low : -1;
    }
}
