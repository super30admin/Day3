// Time Complexity : O(lon n) n = number if elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes

public class Solution {
    public int Search(int[] nums, int target) {
        if(nums == null || nums.Length == 0)
        {
            return -1;
        }
        int l = 0;
        int h = nums.Length -1;

        while(l<=h)
        {
            int mid = l+(h-l)/2; // to avoid integer overflow
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[l]<=nums[mid]) // to check which array is sorted and discard other half
            {
                if(nums[l]<=target && target < nums[mid]) // if element is present in one half discard the other half
                {
                    h = mid-1;
                }
                else
                {
                    l= mid +1;
                }
            }
            else
            {
                if(nums[mid]<target && target <= nums[h]) // if element is present in one half discard the other half
                {
                    l = mid+1;
                }
                else
                {
                    h =mid-1;
                }
            }
        }
        return -1;
    }
}