// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
// Approach: 
// This is a problem of search in sorted array where size is unknown. 
// Here I have applied a binary search and this different kind of binary search. 
// In this array, we don't know the high bound of the array. So, initially I set the low equals to 0 and high equals to 1. 
// To expand the search range weset the new low to the previous high and double the high and we do Binary search.


class Solution {
    
    public int search(ArrayReader reader, int target) {
        
        // Initialize the low and high pointers for the range
        int low = 0;
        int high = 1;

        // Expand the search range until we find an element greater than or equal to target
        while(reader.get(high) < target) {
            low = high; // Set the new low to the previous high
            high = high * 2; // Double the high to expand the search range
        }

        // If the target is exactly at the high index, return the high index
        if(reader.get(high) == target) {
            return high;
        }
        
        // Perform binary search within the range 
        return binarySearch(reader, target, low, high);
    }


    private int binarySearch(ArrayReader reader, int target, int low, int high) {

        // Perform binary search 
        while(low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the middle element is the target
            if(reader.get(mid) == target)  {
                return mid;
            } else if(target > reader.get(mid)) { // If target is larger, move the low pointer up
                high = mid + 1;
            } else { // If target is smaller, move the high pointer down
                low = mid - 1;
            }
        }
        // Return -1 if the target is not found
        return -1;
    }

}