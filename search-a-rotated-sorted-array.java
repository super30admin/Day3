// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/*The code uses binary search to find target in a given rotated sorted array:

It identifies which segment (left or right of mid) is sorted.
Adjusts search bounds (l or r) based on whether target falls within the sorted segment.
Continues until target is found or search space is exhausted (l > r).
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0 || nums==null)
        {
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        int mid;
        while(l<=r)
        {
            mid = l+(r-l)/2;
            if(target==nums[mid])
            {
                return mid;
            }
            //sorted on left
            else if(nums[mid]>=nums[l])
            {
                //target to the left
                 if(target>=nums[l] && target <nums[mid])
                 {
                     r=mid-1;
                 }
                //left
                else
                {
                    l=mid+1;
                }
            }
            //sorted right
            else
            {
                //target to right
                if(target>=nums[mid] && target<=nums[r])
                {
                    l=mid+1;
                }
                //left
                else
                {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}