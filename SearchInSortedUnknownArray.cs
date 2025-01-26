// Time Complexity : O(logm)+O(logn) where m is count of elements taken for finding high
// and n is count of elements taken for binary search after finding low and high values.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// approach - performed two binary operations, first operation to get the postion of high index  
// and second to search the target from defined low and high index.

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

        while(target > reader.Get(high))
        {
            low = high;
            high = high*2;
        }

        while(low<=high)
        {
            int mid = low + (high - low) /2;
            if(reader.Get(mid) == target)
            {
                return mid;
            }
            else if(target > reader.Get(mid))
            {
                low = mid+1;
            }
            else
            {
                high = mid -1;
            }
        }
        return -1;
    }
}