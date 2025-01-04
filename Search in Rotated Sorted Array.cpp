// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Even if the sorted array is rotated. One side (either left or right) of mid will always be sorted We will use modified binary serach
// Calculate mid if our target is at mid then simple return the mid. If target is not at the mid then use the sorted part of the array to move left and right pointers by checking if the target is lying in sorted part of the array.
class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size() == 0) return -1;
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(nums[mid] == target) return mid;
            // left part sorted, take care of <=
            else if(nums[low] <= nums[mid]) {
                // check if target lies in the sorted part
                if(nums[low] <= target && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            }
            // right part sorted
            else {
                // check if target lies in the sorted part
                if(nums[mid] < target &&  target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
};