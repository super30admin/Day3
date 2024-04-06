
// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchUnknownSizeArray {

    public int search(ArrayReader reader, int target) {

        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (reader.get(mid) == target)
                return mid;
            if (target > reader.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }

}
