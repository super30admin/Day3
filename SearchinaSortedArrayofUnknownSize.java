// Problem 702: Search in a Sorted Array of Unknown Size
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class ArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high *= 2;
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
