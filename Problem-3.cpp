// Time Complexity : worst case: O(log n + log n) for two BS's, n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no, but I found this problem a little similar to search in 2D matrix
//                                           in the way that, in that problem, we could've used two BS's: first to
//                                           find the row where target could exist and second to find target in that row
//                                             


// Your code here along with comments explaining your approach


/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */
#include<limits.h>
class Solution {

    // Given low, high this function does a BS within the given range in
    // reader stream, if target exists it returns it's index else -1
    int binarySearch(int low, int high, const ArrayReader& reader, int target)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if (reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;

    }
public:
    int search(const ArrayReader& reader, int target) {
        // If secret array only contains one element,
        // check if it is equal to target and return it if so, else 
        // return -1
        if(reader.get(1) == INT_MAX)
            return (target == reader.get(0))? 0: -1;

        int low = 0;
        int high = 5;
        // This BS is to find the range where given target 
        // could exist in the reader stream.
        while (low<=high && reader.get(low) != INT_MAX)
        {
            int mid = low+(high-low)/2;
            // If target falls in b/w low and mid, do BS for this range
            if(reader.get(low) <= target && reader.get(mid) >= target)
                return binarySearch(low, mid, reader, target);
            // If mid is less than target, move low to mid+1 and
            // high by 5 elements to expand search space for range
            else if(reader.get(mid) < target)
            {
                low = mid+1;
                high = high+5;
            }
            // If target is smaller than mid, then move high
            else {
                high = mid-1;
            }
        }
        return -1;
    }
};