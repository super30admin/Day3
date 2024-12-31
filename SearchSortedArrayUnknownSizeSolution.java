
class SearchSortedArrayUnknownSizeSolution {
    public int search(ArrayReader reader, int target) {
        // Input: secret = [2,5], target = 5 Output: 1
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        if (reader.get(high) == target) {
            return high;
        }

        return binarySearch(reader, low, high, target);
    }

    private int binarySearch(ArrayReader reader, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                // move right
                low = mid + 1;
            } else {
                // move left
                high = mid - 1;
            }
        }
        return -1;
    }
}