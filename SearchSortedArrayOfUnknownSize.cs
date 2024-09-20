// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//This approach exponentially increases the search range by 
//doubling the high value until reader.Get(high) is greater than or equal to the target. 
//It efficiently narrows down the potential range without needing to
// check every element. Once the target is within the range, 
//binary search is applied to find the exact index.


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
        
        while(reader.Get(high) < target){
            low = high;
            high = 2 * high;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            int midValue = reader.Get(mid);
            if(midValue == target) {
                return mid;
            }
            else if(midValue < target){
                low = mid + 1;

            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }
}