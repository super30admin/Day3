/*
    Leetcode problem 162: Find Peak Element
    T.C: O(log(n)) :: S.C: O(1)

    Solved using B.S technique:
    As there is no order in which the elements are sorted we need to move in the direction
    of the increasing order of the mid element (nums[i] != nums[i + 1] for all valid i) this
    constraint helps us tackle the problem of a plateauing on left and right of mid. As we can
    return any index of a peak in the array we can move towards the larger element and return the index.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; //prevent integer overflow
            //Check if you are at the peak element
            if ((mid == low || nums[mid - 1] < nums[mid]) && (mid == high || nums[mid + 1] < nums[mid])) return mid;

            if (mid == n - 1 || nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}