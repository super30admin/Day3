// Time Complexity : O(log n) - Binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
class Solution {
    public int search(int[] nums, int target) {
        // Calculate length of given matrix
        int n = nums.length;
        // Set the low and high value to start binary search
        int low = 0;
        int high = n - 1;
        // When low is less than or equal to high, come out of the loop
        while (low <= high) {
            // Calculate the mid in below way to avoid integer overflow exception
            int mid = low + ((high - low) / 2);
            // If the mid element if equal to target, return index of mid element
            if (nums[mid] == target) {
                return mid;
            }
            // Check if the left part is sorted
            if (nums[low] <= nums[mid]) {
                /*
                 * Check if in left sorted part the target can be present by checking
                 * if the target is greater or equal to low value and less than mid value
                 */
                if (target >= nums[low] && target < nums[mid]) {
                    // In that case perform binary search in left part
                    high = mid - 1;
                } else {
                    // else perform binary search in right part
                    low = mid + 1;
                }
            }
            // Else right part is sorted
            else {
                /*
                 * Check if in right sorted part the target can be present by checking
                 * if the target is greater than mid value and less than or equal to high value
                 */
                if (target > nums[mid] && target <= nums[high]) {
                    // In that case perform binary search in right part
                    low = mid + 1;
                } else {
                    // else perform binary search in left part
                    high = mid - 1;
                }
            }
        }
        // If not found, return -1
        return -1;
    }
}