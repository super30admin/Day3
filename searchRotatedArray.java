
/*
 * Approach : breaking down sorted and unsorted pieces in a
 * Time complexity: O(log n) - n length of the array
 * Space complexity: O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) {
            return -1;
        }
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while(low<=high){
            // do binary search
            int mid = low + (high - low)/2; //prevent integer overflow
            if(target == nums[mid]) return mid;
            if(nums[low] <= nums[mid]) { // <= because to check single element arrays
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // move left
                } else {
                    low = mid + 1; // move right
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; //move right 
                } else {
                    high = mid - 1; // move left
                }
            }
        }
        return -1;
    }
}