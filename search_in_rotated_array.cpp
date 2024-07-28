// Time Complexity : O(log N) since we divide the array in half every step
// Space Complexity : O(1). We are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : missed a few edge cases with (low < high) instead of using (low <= high) 

class Solution {
public:
    int search(vector<int>& nums, int target) {

        int low = 0;
        int high = nums.size()-1;

        while(low < high)
        {
            int mid = low + ((high - low)/2);

            // figure out which side is sorted
            if(nums[low] <= nums[mid])
            {
                // left side is sorted
                if(nums[mid] == target)
                {
                    return mid;
                }

                // check if target lies in left array
                if(target >= nums[low] && target < nums[mid])
                {
                    // target lies in the left array
                    high = mid;
                }
                else
                {
                    // target lies in right array
                    low = mid + 1;
                }
            }
            else
            {
                //right side is sorted
                if(nums[mid] == target)
                {
                    return mid;
                }

                // check if target lies in the righ array
                if(target > nums[mid] && target <= nums[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid;
                }
            }

        }

        if(nums[low] == target)
        {
            return low;
        }

        return -1;
        
    }
};