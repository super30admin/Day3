// Time Complexity : O(log n)
// Space Complexity :
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this :


// In Rotated sorted array, when we start to apply Binary search, we can think of one half of the array as Sorted and another as Unsorted at any point of time.
//So, we can use Binary search to search the element to match the constraint given that the Runtime complexity will be O(log n)

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                  high = mid - 1;
                }
                else {
                  low = mid + 1 ;
                }
            }
            else
            {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}