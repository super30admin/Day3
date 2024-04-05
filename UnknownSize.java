// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = high * 2; //Increases the search size by 2 as the size of the array is unknown
        }
        while (low <= high){
            int mid = low + (high - low) / 2; //Calculates middle element
            if (reader.get(mid) == target){ //If the target matches the middle element
                return mid;
            }
            if(target <= reader.get(mid)){
                high = mid - 1; //Moves left
            } else {
                low = mid + 1; //Moves right
            }
        }
        return -1;
    }

}