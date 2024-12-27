// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : First, identify whether the left or right part of the array is sorted.
// Then, check if the target lies within the sorted range. If it does, narrow the search to that range
// using binary search, otherwise, search the unsorted half.

class SolutionRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
