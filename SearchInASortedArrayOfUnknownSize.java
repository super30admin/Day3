// Time Complexity: O(log n)
// Space Complexity: O(1) as not any extra data structure has been utilized

// Secret arrayReader length will always be >= 1 upto 10^4. 
// So the edge case check has been skipped here. 
// The implementation of ArrayReader is un-available.

public class SearchInASortedArrayOfUnknownSize {

    public static void main(String[] args) {
        System.out.println(search([-1,0,3,5,9,12], 9)); // true
    }

    public static int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        // Calculated the lower and higher bounds as input length is unknown
        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }
        if (reader.get(high) == target)
            return high;
        return search(reader, low, high, target);
    }

    private int search(ArrayReader reader, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
