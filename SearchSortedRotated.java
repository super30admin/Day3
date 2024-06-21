
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null){
            return -1;
        }
        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid]== target) return mid;
            if(nums[mid]>=nums[low]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                }else{
                    low = mid +1;
                }
            }
            if(nums[mid]<=nums[high]){
                if(target > nums[mid] && target <= nums[high]){
                    low = mid +1;
                }else{
                    high = mid-1;
                }
            }

        }
        return -1;
        
    }
}