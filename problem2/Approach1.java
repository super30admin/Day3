package problem2;

// Time Complexity : O(logN)
// Space Complexity : O(1) -- no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/**
 * Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
 */

public class Approach1 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] rotatedArr = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};

        int target = 1;

        Approach1 binarySearch = new Approach1();
        int output = binarySearch.search(rotatedArr, target);

        System.out.println("output ==> " + output);
    }

    public int search(int[] nums, int target) {

        int n = nums.length;
//        base condition
        if(n == 0 || nums == null) {
            return -1;
        }

        int low = 0;
        int high = n - 1;

        while(low <= high) {

            int mid = low + (high - low)/2;

            System.out.println("mid ==> " + mid);
            System.out.println("low ==> " + low);
            System.out.println("high ==> " + high);

            if(nums[mid] == target) {
                System.out.println("in if 1");

                return mid;
            }

//            left side is sorted
            else if(nums[low] <= nums[mid]) {

                System.out.println("in else if");
                System.out.println("low ==> " + low);
                System.out.println("high ==> " + high);
                System.out.println("mid ==> " + mid);
                System.out.println("===============================");

                if(nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }

//             right side is sorted
            else {
                System.out.println("in else");

                System.out.println("low ==> " + low);
                System.out.println("high ==> " + high);
                System.out.println("mid ==> " + mid);
                System.out.println("===============================");

                if(nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
