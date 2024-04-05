// Time Complexity :O(logn) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
public class SearchRotatedArrayLC33 {
      public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;// always use this formula to calculate mid values to avoid integer
                                             // overflow error.
            if (nums[mid] == target)
                return mid;
            if (nums[low] <= nums[mid]) {// left side is sorted
                if (nums[low] <= target && nums[mid] > target) {// Step1:check if element present in left sorted array
                    high = mid - 1; // Step1.1: yes, change high pointer to mid-1
                } else {
                    low = mid + 1;// Step1.2: no, element present in left sorted array. lets check in right array
                                  // from [low = mid+1 to high = high]
                }

            } else {// right side is sorted
                if (nums[mid] < target && nums[high] >= target) {// check if element
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }

        return -1;
    }
}
