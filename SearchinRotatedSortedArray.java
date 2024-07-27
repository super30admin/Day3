// Problem 33: Search in Rotated Sorted Array
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
        }
        return -1;
    }
}
