// Time Complexity : O(log n)
// Space Complexity : O(1) // since we are not using additional we created apart from the original nums array given to us
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid]==target) return mid;
            else{
                if(nums[mid]<=nums[high]){ //if right part is sorted or not
                    if(target>nums[mid] && target<=nums[high]){ // checking if the target is there in the sorted portion of the array or not
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
                else{
                    if(target>=nums[low] && target<nums[mid]){
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
            }
            
        }
        return -1;
    }
}
