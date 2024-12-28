// Approach: Array is sorted, but to apply binary search, we need to define upper and lower bounds of search space. Two pointers can be
// used to bound this space. By initializing low, high pointers to 0, 1, respectively, and updating them to high and 2 * high while element
// at the high index is less than search target, we can determine the correct search space. Once the bounds are set, binary search can be applied.
// Time Complexity : O(logk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Didn't run on leetcode (premium problem), tested locally
// Any problem you faced while coding this : No

public class SearchInfiniteSortedArray {
    static class ArrayReader {
        int[] arr;
        ArrayReader(int[] a) {
            arr = a;
        }
        int get(int idx) {
            if (idx >= arr.length) {
                return Integer.MAX_VALUE;
            }
            return arr[idx];
        }
    }

    int binarySearch(ArrayReader reader, int k, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = reader.get(mid);
            if (midVal == k) {
                return mid;
            } else if (midVal > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    int[] findSearchSpace(ArrayReader reader, int target) {
        // Step 1: Determine the range
        int left = 0;
        int right = 1;

        // Expand the range until the target is within the bounds
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
        return new int[] { left, right };
    }

    public static void main(String[] args) {
        SearchInfiniteSortedArray sisa = new SearchInfiniteSortedArray();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 5;
        ArrayReader ar = new ArrayReader(arr);
        int[] search = sisa.findSearchSpace(ar, k);
        System.out.println("Target found at index: " + sisa.binarySearch(ar, k, search[0], search[1]));
    }
}