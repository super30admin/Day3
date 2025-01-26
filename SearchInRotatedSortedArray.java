// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Use binary search. Calculate mid, if mid element is target then return that. 
 * Else, check the side which is sorted. If left side is sorted, in that side if target is between left and mid index then move right to mid-1,
 * else left to mid+1. If right side is sorted,in that side if target is between mid and right index then move left to mid+1,
 * else right to mid-1.
 */
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid= left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[left]<=nums[mid]){
                if(target>=nums[left] && target <nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(target>nums[mid] && target <=nums[right]){
                    left=mid+1;                    
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}