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
        int low = 0;
        int high = 1;

        // Find the range in which the element lies
        while (target > reader.get(high))
        {
            low = high;
            high = high * 2;
        }
        // Once found, look if the high is the target
        if (reader.get(high) == target)
        {
            return high;
        }

        // If not send it to binarySearch function to find the element
        return binarySearch(reader, target, low, high);
    }

    int binarySearch(const ArrayReader &reader, int target, int low, int high)
    {
        // Binary search to find the element and return the index
        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target)
            {
                return mid;
            }
            else if (reader.get(mid) < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return -1;
    }
};