// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Find the range by moving low to high's position and multiplying high by 2 until
// range for target is found and then performing binary search to find index of the target

interface ArrayReader {
    public int get(int index);
}
class SolutionSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(target > reader.get(high)) {
            low = high;
            high = high * 2;
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target) {
                return mid;
            }
            if(reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}