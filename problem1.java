// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Was confused between <= or < or >= or >

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid+1;
            } else{
                if(target <= nums[high] && target > nums[mid]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}