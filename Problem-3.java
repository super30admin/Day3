// This solution first calculates the upper bound and then applies binary search using the calculated upperbound
//Time Complexity: O(log n + log n)=> O(2logN) => O(log n)

class SearchInASortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int upperBound = 1;
        int low = 0;
        int mid;
        while (reader.get(upperBound) <= target) {
            upperBound = upperBound * 2;
        }

        while (low < upperBound) {
            mid = low + (upperBound - low) / 2;
            int currMid = reader.get(mid);
            if (currMid == target)
                return mid;
            if (target > currMid) {
                low = mid + 1;
            } else
                upperBound = mid - 1;
        }
        if (reader.get(upperBound) == target)
            return upperBound;
        return -1;

    }
}
