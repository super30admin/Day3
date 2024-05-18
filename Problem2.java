/*
    Leetcode Problem - 33 (Search in Rotated Sorted Array)
    TC - O(log n)
    SC - O(1)
    Approach - I have used the binary search algorithm and using the logic that atleast one half of the array is sorted in the rotated sorted array to figure out the which
    half the element persists.
*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[low] <= nums[mid]) {
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