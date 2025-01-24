package problem2;

// Time Complexity : O(logn)+O(logn)=O(logn)
// Space Complexity : O(1) -- no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// First finding the start index the lowest value using binary search
// then checking onwhich side the target lies and then doing binary search accordingly

/**
 * Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
 */

public class Approach2 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] rotatedArr = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};

        int target = 6;

        Approach2 binarySearch = new Approach2();
        int output = binarySearch.search(rotatedArr, target);

        System.out.println("output ==> " + output);
    }

    public int search(int[] nums, int target) {

//        base condition
        if(nums.length == 0 || nums == null) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

//        find the start index
        while (left < right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

//        System.out.println("left ==> " + left);
        int start = left;
        left = 0;
        right = nums.length - 1;

        if(target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
