// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach in three sentences only
/*Identify which part of the array is sorted (left or right).
Determine which part to search based on the target's value and the sorted property of the subarrays.
Adjust the search boundaries accordingly. */

class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)
           return -1;
    

    int n= nums.length;
    int low =0;
    int high= n-1;
    while(low<=high){
        int mid = low+(high-low)/2;
        if(nums[mid]==target){
           return mid;
        }
        if(nums[low]<=nums[mid]){
            if(target>=nums[low] && target<nums[mid]){
                high=mid;
            }else{
                low=mid+1;
            }
        }else{
            if(target>nums[mid] && target<= nums[high]){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
    }
     return -1;
    }
    
}