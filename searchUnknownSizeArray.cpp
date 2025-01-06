// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/* Initially considering l as 0 and high as 2
Element is not found, high doubles*/

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
    int search(const ArrayReader& reader, int target) {
        int l=0;
        int h = 1;
        while(l<=h){
            int m = l +(h-l)/2;
            if( reader.get(m) == target){
                return m;
            }
            else if(reader.get(m)< target){
                l = h;
                h = h*2;
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return -1;
    }
};
