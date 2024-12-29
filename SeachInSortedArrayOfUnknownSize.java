//TC: O(log n) where n is index of target in array ->
        // O(log n) for finding search range, O(log n) for binary search on actual search range, total O(log n)
//SC: O(1) no extra space used
//approach: search exponential for range where target could lie in
// then do binary search in the range determined

public class SeachInSortedArrayOfUnknownSize {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = 1;

        while (nums[high] < target && nums[high] != Integer.MAX_VALUE) {
            low = high;
            high *= 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target || nums[mid] == Integer.MAX_VALUE) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
