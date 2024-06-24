// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
  public int search(int[] nums, int target) {
    // Check edge cases.
    if(nums.length == 0 || nums==null) return -1;
    int low = 0;
    int high = nums.length - 1;
    while(low <= high) {
      // To avoid integer overflow.
      int mid = low + (high-low)/2;
      // return index if target matches the element at mid.
      if(nums[mid] == target) return mid;
      // Check if the first half is sorted, if not then second half is sorted.
      if(nums[low] <= nums[mid]) {
        // Check if target element resides within the sorted half of the array and adjust pointers accordingly.
        if(target<nums[mid] && target>=nums[low]) high = mid - 1;
        else low = mid + 1;
      } else {
        if(target>nums[mid] && target<=nums[high]) low = mid + 1;
        else high = mid - 1;
      }
    }
    // Return -1 if element doesn't exist.
    return -1;
  }
}