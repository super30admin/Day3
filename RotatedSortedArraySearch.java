// Time Complexity : O(log n) as we are using binary search
// Space Complexity : O(1) Constant space as the amount of extra space used does not depend on number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RotatedSortedArraySearch {
    public int search(int[] nums,int target){
        int low=0, high = nums.length-1;

        while (low<=high) {
            int mid = low + (high - low) / 2;

            // check if the mid element is the target
            if (nums[mid] == target) {
                return mid;
            }

            // find which half is sorted
            if (nums[low] <= nums[mid]) { // left half is sorted
                if (nums[low] <= target && target < nums[mid]) { // if target is between low and mid i.e in the first half
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {// right half is sorted
                if (nums[mid] < target && target <= nums[high])// if target value  is between mid and high in the right half
                {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        RotatedSortedArraySearch searcher = new RotatedSortedArraySearch();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = searcher.search(nums, target);
        System.out.println("Target found at index: " + result);
    }
}