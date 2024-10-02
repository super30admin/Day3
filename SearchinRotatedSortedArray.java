// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Solution {
   public int search(int[] nums, int target) {
        return binarySearch(nums, 0 , nums.length - 1 , target); 
   }
   public int binarySearch(int[] nums, int low, int high, int target)
   {
       if(low > high) return -1;
       int mid = low + (high -low)/2;
       if(nums[mid] == target) return mid;
       if(nums[low] <= nums[mid])
       {
           if(nums[low] <= target && nums[mid] >= target) high = mid -1;
           else low = mid + 1;
       } else {
           if(nums[mid] <= target && nums[high] >= target) low = mid + 1;
           else high = mid - 1;
       }
       return binarySearch(nums, low , high , target);
   }
}