// Time Complexity : O(log n)
// Space Complexity : O(1) => Constant space compleexity as we are not utizlizing additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Miscalculated the value of high variable (Didn't subtract -1)

/* Calculated mid and checked if left side is sorted and target could be in that range, then search on the left side
 * if left side is not sorted then look at the right side
 */
class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents Integer overflow

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) //Checks if left side is sorted by calculating range (In 2nd condition, equality signed is skipped as we have already compared with mid)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;

            }

        }
        return -1;
    }
}