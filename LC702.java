// 702. Search in a Sorted Array of Unknown Size

// TC: O(log(n)) where n is the max possible length of the array
// SC: O(1)


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

public class LC702 {
    public int search(int secret[], int target) {
        int l = 0, h = 9999;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (ArrayReader.get(mid) == target)
                return mid;
            else if (ArrayReader.get(mid) > target)
                h = mid - 1;
            else
                l = mid + 1; 
        }
        return -1;
    }
}
