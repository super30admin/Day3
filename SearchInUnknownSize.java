// Time Complexity :O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class SearchInUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low=0,high=1;
        
        while(reader.get(high) < target) {
            low = high;
            high=high*2;
        }
        while(low<high) {
            int mid = low+(high-low)/2;
            
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        if(reader.get(low) == target) return low;
        return -1;

    }
}