
// Time Complexity : o(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Did not check as it is a premium problem
// Any problem you faced while coding this : No

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; // setting low to 0
        int high = 1; // setting high to 1
        while (reader.get(high) < target) {
            low = high;
            high = high * 2; // increment high by 2 everytime
        }
        return binarySearch(reader, low, high, target); // return to get  position, binary search
    }

    private int binarySearch(ArrayReader reader, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // not found
    }
}
