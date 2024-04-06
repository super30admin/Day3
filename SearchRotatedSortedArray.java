// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, if else logic was little tricky to get my head around.

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                if (nums[mid] < target && nums[right] >= target) {

                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;

    }
}
