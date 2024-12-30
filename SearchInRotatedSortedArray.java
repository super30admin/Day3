class Solution {
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // Did this code successfully run on Leetcode : Yes
    // thought process: at every step we're checking which part is sorted and then we're checking if the target lies in that part
    // if it does, we're doing a binary search in that part, if it doesn't, we're doing a binary search in the other part
    // we're doing this until we find the target or the low and high pointers cross each others
    public int search(int[] nums, int target){ 
    if (nums == null || nums.length ==0){
        return -1;
    }
    
       int low = 0;
       int high = nums.length -1;
       while (low <= high){
       int mid = low + (high - low) /2;
        if (nums[mid] == target) {
            return mid;
        }
        //check if left part is sorted
        if (nums[low] <= nums[mid]){
            // check if the target will be present or not
            if (target >= nums[low] && target < nums[mid]){
                //the target should be here, do a binary search here
                high = mid -1;
            } else {
                low = mid +1;
            }
        } else {
             if (target > nums[mid] && target <= nums[high]){
                //the target should be here, do a binary search here
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
       }
       return -1;
    }
}