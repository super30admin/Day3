
// Time Complexity : o(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1; // edge case
        }

        int low = 0;
        int high = nums.length - 1;

        while(low<=high){
            int middle = low + (high - low)/2;
            if(nums[middle] == target){
                return middle;
            }
            if(nums[low] <= nums[middle]){ // checking to see if left side is sorted
                if(nums[low] <= target && target < nums[middle]){ // if left side is sorted, then see if our target can be in this
                    high = middle - 1;
                }else{
                    low = middle + 1;
                }
            }
            else{ //right side is sorted
                if(nums[middle] < target && target <= nums[high]){ // if right side is sorted, then see if our target can be in this
                    low = middle + 1;
                }else{
                    high = middle - 1;
                }
            }
        }
        return -1;
    }


}