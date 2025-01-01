/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *     public int Get(int index) {}
 * }
 */

class Solution
{
    public int Search(ArrayReader reader, int target)
    {
        int low = 0, high = 1;

        while (low <= high)
        {
            while (reader.get(high) == Int32.MaxValue)
            {
                high = high - 1;
            }
            var mid = low + (high - low) / 2;
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
                high = 2 * high;
            }
        }

        return -1;
    }
}