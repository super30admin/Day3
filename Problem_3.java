// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Used binary search, setting 9999 as the upper limit based on the given constraint

interface ArrayReader {
    public int get(int index);
}
class SolutionSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 9999;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}