/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *     public int Get(int index) {}
 * }
 */

class Solution {
    public int Search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        
        while (reader.Get(high) < target && reader.Get(high) != int.MaxValue)
        {
            low = high;
            high *= 2; 
        }

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            int midVal = reader.Get(mid);

            if (midVal == target)
                return mid;
            else if (midVal < target)
                low = mid + 1; 
            else
                high = mid - 1; 
        }

        return -1;
    }
}