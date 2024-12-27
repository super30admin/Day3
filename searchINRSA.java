// Time Complexity :O(log n)
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[low] <= nums[mid]){// means sorted
                if(target >= nums[low] && target < nums[mid]){ // Not doing target >= nums[mid] coz, we have taken care of it on line 14.
                    high = mid -1;
                }else{
                     low = mid + 1;
                }
            }else if(nums[high] > nums[mid]){
                if(target <= nums[high] && target > nums[mid]){
                    low = mid + 1;                    
                }else{
                     high = mid -1;
                }

            }
        }

        return -1;
    }
}