// Approach: We can tweak the original binary search algorithm as follows: Identify which side of the midpoint is sorted. Then,
// confirm whether the target lies on this side of the array. This is the only information we can be certain of. Update the low or
// high pointers accordingly.
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class SearchRotatedSortedArray {

    int pivotedBinarySearch(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[low] <= arr[mid]) { // left side of mid is sorted
                if (arr[low] <= k && arr[mid] > k) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right side of array is sorted
                if (arr[high] >= k && arr[mid] < k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    int findPivotIndex(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (m >= 1 && arr[m] < arr[m - 1]) {
                return m;
            } else if (m < arr.length - 1 && arr[m] > arr[m + 1]){
                return m + 1;
            } else if (arr[l] <= arr[m]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    int binarySearch(int[] arr, int k, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray srsa = new SearchRotatedSortedArray();
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int k = 7;
        System.out.println("ELement found at index " + srsa.pivotedBinarySearch(arr, k));

//        Another approach that uses atmost 3 binary searches - one for finding pivot index, other two on 2 halves of the array
//        int p = srsa.findPivotIndex(arr);
//        System.out.println("Pivot index: " + p);
//        int idx = srsa.binarySearch(arr, k, 0, p - 1);
//        if (idx == -1) {
//            idx = srsa.binarySearch(arr, k, p, arr.length - 1);
//        }
//        System.out.println("ELement found at index " + idx);
    }
}