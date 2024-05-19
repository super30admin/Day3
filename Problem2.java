// Time Complexity : O(logn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

// 1.The code uses binary search to find a target value in a rotated sorted array. 
// 2.It starts with pointers at the beginning and end of the array and repeatedly checks the middle element. 
// 3.Depending on which half of the array is sorted and where the target lies, it adjusts the pointers until it finds the target or concludes that the target isn't in the array. 
// 4.If the target is found, it returns the index; otherwise, it returns `-1`.

class Solution {
    public int search(int[] nums, int target) {     
     
     int low = 0;
     int high = nums.length -1;
     while(low <=high){
        int mid = low + (high-low)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[low] <= nums[mid]){
           if(nums[low] <= target && target < nums[mid]){
            high = mid-1;
           }else{
            low = mid+1;
           }
        }else{
           if(nums[mid] < target && target <= nums[high]){
            low = mid+1;
           }else{
            high = mid-1;
           } 
        }
     }
     return -1;
    }
}