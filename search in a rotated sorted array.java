// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
implemented the code by checking for the sorted part of the array and performing binary search
 */
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while(low <= high)
        {
            mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                return mid;
            }

            else if(nums[low] <= nums[mid])
            {
                if(target >=nums[low] && target < nums[mid] )
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }

            else
            {
                if(target > nums[mid] && target <= nums[high])
                {
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