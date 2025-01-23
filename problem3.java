// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only\
// 1. Since the secret length is between 1 and 10^4 that is the size of our search space.
// 2. If the index doesn't exist, the interface returns the max int value (2^31 - 1) implying that the target is to the left

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0, r = 10000 - 1;

        while(l<=r){
            int mid = (l+r)/2;
            int val = reader.get(mid);
            if(val == target){
                return mid;
            }
            else if(val > target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }
}