// Time Complexity: O(log n)
// Space Complexity: O(1)

// This is a variation of classical binary search where an input array is rotated. 
// Here overall skeleton of binary search is same except few extra checks being
// done to navigate left, right and mid positionings. If nums[mid] doesn't match then, 
// sorted array is seeked to carry out further operations of left and right.

// Iterative Binary Search
public class SearchinRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            // Else if and else conditions doesn't compare target with nums[mid]
            // inclusively, because it has already checked in if conditions
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)); // 4
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3)); // -1
        System.out.println(search(new int[] { 1 }, 0)); // -1
    }
}
