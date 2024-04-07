// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// set low and high pointers, calculate mid based on low and high
// check if mid is equal to target, the return mid.
// else check left array is sorted or not by comparing nums[low] with nums[mid], if it is sorted, compare it with target and se low and high pointers
// else check the righ array and compare the mid and high with target and set low and high pointers.
class SortedRotatedArray {

     public int search(int[] nums, int target) {

         int low = 0;
         int high = nums.length -1;

         while(low <= high) {
            int mid = low + (high-low)/2;

            // check if mid is the target
            if(nums[mid] == target) {
                return mid;
            }

            // check left sub array
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target  && nums[mid] > target){
                    high = mid -1;
                }else {
                    low = mid + 1;
                }
            }
            // check right sub array
            else {
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }

            }
         }
         return -1;
        }

}