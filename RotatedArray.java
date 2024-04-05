// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if (nums[mid] == target){ //If middle element is equal to target
                return mid;
            }
            if (nums[low] <= nums[mid]){ //Checks if it is left sorted
                if (nums[low] <= target && nums[mid] > target){ //Checks if target lies in the left side of the array
                    high = mid - 1; //Moves left
                }   else {
                    low = mid + 1; //Moves right
                }
            } else {                    //Checks if it is right sorted
                if (nums[mid] < target && nums[high] >= target){ //Checks if target lies in the right side of the array
                    low = mid + 1; //Moves left
                } else {
                    high = mid - 1; //Moves right
                }

            }
        }
        return -1;
    }
}