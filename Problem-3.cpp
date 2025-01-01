// author : Sahil D Shetty
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution
{
public:
    int search(const ArrayReader &reader, int target)
    {
        int low = 0, high = 1;

        while (reader.get(high) <= target)
        {
            low = high;
            high = high * 2;
        }

        if (reader.get(high) == target)
        {
            return high;
        }

        return binarySearch(reader, target, low, high);
    }

    int binarySearch(const ArrayReader &reader, int target, int low, int high)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target)
            {
                return mid;
            }

            if (reader.get(mid) > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
};