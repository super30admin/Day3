// Time Complexity : O(logn)
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

 class Problem7 {
    public int search(ArrayReader reader, int target) {
        // Initial bounds for the search
        int left = 0;
        int right = 1;
        
        // Exponentially increase the right bound until it exceeds the target
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
        
        // Perform binary search within the identified bounds
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = reader.get(mid);
            
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // If the target is not found, return -1
        return -1;
    }
}
