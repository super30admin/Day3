// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0 || nums == null) {
            return -1;
        }
        
        int low = 0;
        int high = n - 1;
        //Binary Search
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            }

            //if left side is sorted
            if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //if right side is sorted
            else {
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