public class Solution
{
    public int Search(int[] nums, int target)
    {
        if (nums == null || nums.Length == 0)
        {
            return -1;
        }
        int low = 0, high = nums.Length - 1;
        while (low <= high)
        {
            var mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }
            if (nums[low] <= nums[mid])
            {
                if (nums[low] <= target && nums[mid] > target)
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
                if (nums[mid] < target && nums[high] >= target)
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