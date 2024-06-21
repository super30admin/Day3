// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;

            else if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l])
                    l = mid + 1;
                else
                    r = mid - 1;
            }

            else {
                if (target < nums[mid] || target > nums[r])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }

        return -1;

    }
}