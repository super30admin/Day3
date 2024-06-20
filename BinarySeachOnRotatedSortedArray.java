/*
Time Complexity : O(logn)
Space Complexity : O(n)

Did this code successfully run on Leetcode : yes
*/ 
class BinarySeachOnRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while(left <= right) {
            mid = left + (right - left)/2;
            //base case
            if(nums[mid] == target) return mid;

            //check if left side is sorted
            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { //right is sorted
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}