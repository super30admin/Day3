// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
// The algorithm uses binary search to find the target in a rotated sorted array 
//by first determining which half of the array is sorted. 
//It then checks if the target lies within the bounds of the sorted half, 
//adjusting the search range accordingly. 
//This process continues until the target is found or the search range is exhausted.

using System;

public class Solution
{
    public int Search(int[] nums, int target)
    {
        int low = 0;
        int high = nums.Length - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2; // to avoid integer overflow
            if (nums[mid] == target)
            {
                return mid; // Target found
            }
            else if (nums[low] <= nums[mid])
            { // Left sorted array
                if (nums[low] <= target && nums[mid] > target)
                {
                    high = mid - 1; // Target is in the left half
                }
                else
                {
                    low = mid + 1; // Target is in the right half
                }
            }
            else
            { // Right sorted array
                if (target > nums[mid] && target <= nums[high])
                {
                    low = mid + 1; // Target is in the right half
                }
                else
                {
                    high = mid - 1; // Target is in the left half
                }
            }
        }

        return -1; // Target not found
    }
}

class Program
{
    static void Main()
    {
        Solution solution = new Solution();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        int result = solution.Search(nums, target);
        Console.WriteLine(result); // Expected output: 4
    }
}
