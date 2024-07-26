/**
* Search in a Sorted Array of Unknown Size
* Compared the low with the target
* The search space was not known but it was reduced because I used binary search and compared low with the target.
*/

// Time complexity = O(log(n))
// Space complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I faced issues in why low is used for comparing with target.


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = Integer.MAX_VALUE; // 2^31-1 (a clue given in the question)
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if(reader.get(low)== target) {
                return low;
            }
            
            if (reader.get(mid) < target) {
                low = mid + 1;
            }
                
            else {
                high = mid;
            }
                
        }
        if(reader.get(low)== target) {
            return low;
        } else {
            return -1;
        }
    }
}
