// Time Complexity : O(logn), n is the size of the given array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : One more way to solve this could be to find the first element that is 
//                                           smaller than the 0th element, and then do a BS either on the right
//                                           side of it or on the left side of it by doing the range check for target


// Your code here along with comments explaining your approach


class Solution {
public:
    int search(vector<int>& nums, int target) {
        int len = nums.size();
        int low = 0;
        int high = len-1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if (nums[mid] == target)
                return mid;
            // Left Array is sorted, if we do not do this check then we don't know
            // which part is sorted(atleast either of the part is sorted) and we 
            // can't do range check to decide which direction to proceed
            else if (nums[low] <= nums[mid])
            {
                // And, our target lies in the range of left part
                if (nums[low] <= target && nums[mid] > target)
                    high = mid - 1;
                // if our target doesn't lie in the left part, go to right
                else
                    low = mid + 1;
            }
            else 
            {
                // Our target lies in the right part, go to right
                if (nums[mid]< target && nums[high]>= target)
                    low = mid+1;
                // Our target lies in the right part
                else
                    high = mid-1;
            }

        }
        return -1;
    }
};