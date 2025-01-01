// Time Complexity: O(logn)
// Space Complexity: O(1);
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
// Approach:
// This is a problem of Rotated sorted array. I have applied Binary search here.
// Then set the low and high bound in the Binary search. We have atleast one half part is sorted in this array. 
// So, I divided the array into two half then checked which part is sorted.
// Then checked target lies left half or right half and again do binary search. If target is not found in the array return -1.

class Solution {
    public int search(int[] nums, int target) {
        
        //If the array is empty of null return -1
        if(nums == null || nums.length == 0) {
            return -1;
        }

        // Initialize the low and high bound 
        int low = 0;
        int high = nums.length-1;

        // Perform binary Search
        while(low <= high) {
            
            // Calculate mid
            int mid = low + (high - low) / 2;//Prevent integer overflow

            // Check if taget equals to mid
            if(nums[mid] == target) {
                return mid;
            }
            // Check which part is sorted
            if(nums[low] <= nums[mid]) {

                // Check target lies in the left half
                if(target >= nums[low] && target < nums[mid] ) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // Check target lies in the right half
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        // If target is not found, return -1
        return -1;
    }
}
