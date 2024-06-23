//TC: O(log n) - As we are multiplying everytime to reach an index greater than or equal to finding target value
//SC: O(1)

class Solution {
    public int search(ArrayReader reader, int target) {
        // Find the bounds
        int low = 0;
        int high = 1;

        // Increase the bounds exponentially until we exceed the target or go out of bounds
        while (reader.get(high) <= target) {

                low = high;
                high = high * 2;
            }


        // Perform binary search within the found bounds
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = reader.get(mid);;

            if (midValue == target) {
                return mid;
            }
            if (midValue > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}