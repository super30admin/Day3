## Problem2 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

// Time Complexity :O(log(n))
// Space Complexity :Constant Space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only
/* 
 * Divide the array into two halves by calculating mid,lower and high.Since the array is previously sorted , one half of the aaray is always sorted.
 * By taking mid , iterate left and see if target matches with mid ,if yes return, else ,check if the array is sorted , if yes ,keep searching left if target is greater than the lowest and less than or equals to highest till element is found
 * If element is greater than the mid, tarverese right by chnaging the lower to mid+1 , check if the right side array is sorted and keep checking for the target element.
 */
class Solution 
{
    public int search(int[] nums, int target) 
    {
        if(nums.length==0||nums==null)
        {
            return -1;
        }
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            if(nums[low]<=nums[mid])
            {
                if(target>=nums[low] && target<nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                if(target>nums[mid] && target<=nums[high])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}