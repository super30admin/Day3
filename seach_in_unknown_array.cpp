// Time Complexity : log M + log N (log M to exand search range and log N for binary search)
// Space Complexity : O(1). We are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int binarySearch(const ArrayReader& reader, int target, int low, int high)
    {
        while(low <= high)
        {
            int mid = low + ((high - low)/2);
            if(reader.get(mid) == target)
            {
                return mid;
            }

            if(reader.get(mid) < target)
            {
                low = mid+1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }

    int search(const ArrayReader& reader, int target) {
        int low = 0;
        int high = 1;

        while(reader.get(high) < target)
        {
            low = high;
            high = high*2;
        }

        return binarySearch(reader, target, low, high);
    }
};