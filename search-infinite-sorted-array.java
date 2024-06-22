// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach in three sentences only

/*
    This code searches for a specific number target in an array of large and unknown length and sorted. 
    It starts by guessing a large range where the number might be found (by doubling h until reader.get(h) is at least target).
    Once it has a good range, it narrows down the search using binary search, which quickly finds the target by
    repeatedly dividing the search range in half until it's found or determined to be absent. 

*/
  
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */


 class Solution {
    public int search(ArrayReader reader, int target) {
        //null
        int l = 0; int h = 1;
        while(reader.get(h) <target) {
            l = h;
            h = 2*h;
        }
        //range of l and h
        while(l<=h) {
            int mid = l +(h-l)/2;
            if(reader.get(mid) == target ) return mid;
            else if(reader.get(mid) > target) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}