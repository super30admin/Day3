/*
    1. Time Complexity : O(log(n))
    2. Space Complexity : O(1)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * Perform modified binary search by comparing nums[mid] and nums[low]
 * to check whether the left half of array is sorted
 * and check if target is within nums[mid] and nums[l].
 * Thus eliminating half of the array with each iteration. 
 */

 class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1, mid = 0;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[l]) {
                if (target < nums[mid] && target >= nums[l])
                    h = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target >= nums[l] || target < nums[mid])
                    h = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,0,1,2};
        int[] targets = {0,2,3,4,6,9,12};
        for (int target : targets) {
            System.out.println("Found target " + target + " at index " + search(nums, target));
        }
    }
}
