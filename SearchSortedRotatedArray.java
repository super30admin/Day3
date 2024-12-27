// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Since it is searching in a sorted array - use Binary search technique

/**
 * In a rotated sorted array, at any given point either the left
 * half or the right half of the array has to be a sorted array,
 * using that theory look into either left half or right half till the point where start becomes greater than end
 */
public class SearchSortedRotatedArray {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) // base case
            return -1;

        int mid = start + (end - start)/2;

        if (target == nums[mid])
            return mid;

        if (nums[start] <= nums[mid]) {
            // if this is true then left array is sorted and right is not
            if (nums[start] <= target && target < nums[mid])
                return binarySearch(nums, start, mid - 1, target);
            else
                return binarySearch(nums, mid + 1, end, target);
        } else {
            // if this is true then left array is not sorted and right is sorted
            if (nums[mid] < target && target <= nums[end])
                return binarySearch(nums, mid + 1, end, target);
            else
                return binarySearch(nums, start, mid - 1, target);
        }
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {12, 13, 14, 15, 5, 6, 7};
        int target = 6;
        SearchSortedRotatedArray obj = new SearchSortedRotatedArray();
        int index = obj.search(arr, target);
        System.out.println("Target found at index: " + index);
        assert (5 == index);
        System.out.println("Success");
    }
}
