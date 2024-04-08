// Time Complexity : O(log N), as we are eliminating half of the elements for search in every iteration based on the intuition that rotated sorted array has a sub array with elements in sorted order
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low +(high - low)/2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && nums[mid] > target) {
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            } else {
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }return -1;
    }
}