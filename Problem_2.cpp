// Author: Subhed Chavan
// Batch: December 24
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

class Solution
{
public:
    int search(vector<int> &nums, int target)
    {

        int length = nums.size();
        int low = 0;
        int high = length - 1;
        int mid = floor(low + (high - low) / 2);

        if (length == 0)
        {
            return -1;
        }

        // Loop with case where Binary Search fails or should be exited
        while (low <= high)
        {
            mid = floor(low + (high - low) / 2);

            if (nums[mid] == target)
            {
                return mid;
            }

            // Check if left half is sorted
            if (nums[low] <= nums[mid])
            {
                // Check if the target lies in the sorted left half
                if (target < nums[mid] && target >= nums[low])
                {
                    high = mid - 1;
                }
                // If not increase the low
                else
                {
                    low = mid + 1;
                }
            }
            else
            {
                // Check if right half is sorted
                if (nums[mid] < nums[high])
                {
                    // Check if the target lies in the sorted right half
                    if (target > nums[mid] && target <= nums[high])
                    {
                        low = mid + 1;
                    }
                    // If not increase the high
                    else
                    {
                        high = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
};