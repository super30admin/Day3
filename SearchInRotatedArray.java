/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: No
 */

public class SearchInRotatedArray {

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // check if left part of array[low...mid] is sorted.
      if (nums[low] <= nums[mid]) {
        // check if target falls in the range low...mid and accordingly update high and
        // low.
        if (target >= nums[low] && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else { // Right part of array[mid...high] is always sorted.
        // check if target falls in the range mid..high and accordingly update high and
        // low.
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }
}
