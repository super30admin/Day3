// Time Complexity : O(log n)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
keep low at 0 and high at index 1 initially then increase low = high and high=2*high until high is less than target, after
range is known, perform binary seacrch to find the taget.
*/

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

      while(reader.get(high) < target) {
          low = high;
          high = 2 * high;
      }

      while( low <= high) {
          int mid = low + (high-low)/2;

          if(reader.get(mid) == target)
              return mid;

          else if( reader.get(mid) > target)
              high =  mid -1;

          else
              low = mid + 1;

      }
      return -1;
    }
}