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
    // Establishing low and high in such a way that the target lies in between.
    while(target>reader.get(high)) {
      low = high;
      high = high*2;
    }
    // Binary Search for target.
    while(low<=high) {
      int mid = low + (high - low)/2;
      if(target == reader.get(mid)) return mid;
      if(target < reader.get(mid)) high = mid - 1;
      else low = mid + 1;
    }
    // Element doesn't exist.
    return -1;
  }
}