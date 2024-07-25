// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Problem6 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If we found the target, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Determine if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if the target lies within the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Check if the target lies within the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        // If we exit the loop, the target is not present
        return -1;
    }
}
