// Time Complexity :O(Log(N))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
//Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {

        if (reader == null) {
            return 0;
        }
        int low = 0 ;
        int high = 1;

        while(reader.get(high)<target){
            low = high;
            high = 2*high;
        }


        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid)<target){
                low = mid+1;


            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
