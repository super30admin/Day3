// Time Complexity : O(log T) where T is the index of the target element
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only:
// First of all found the range where the target element can be present by doubling the high pointer until the target element is less than the element at high pointer.
// I have used binary search to find the target element in the rotated sorted array.
public class RotatedSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2 * high;
        }

        while(low <= high){
            int mid = low + (high-low)/2;

            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }
}
