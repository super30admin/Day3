/**
* Search in Rotated Sorted Array 
* compared mid and the first value, the general idea that if nums[low]< nums[mid], then we are like having a sequence of 4,5,6,7
* Then checking whether the target is between the low and mid index.
*/

// Time complexity = O(log(n))
// Space complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I faced issues in like understanding where to place the partition of the search space.

class Solution_2 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[low]) { // This is normal ascending sorted array
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] <= nums[high]) {// This is 0,1,2,3, where mid is 0 and high is 3.
                if (target > nums[mid] && target <= nums[high]) {// target is between mid and high.
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
