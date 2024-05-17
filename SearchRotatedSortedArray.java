// Time Complexity : o(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int search(int[] nums, int target) {

        if(nums.length == 0 || nums == null){
            return -1;
        }
        int len = nums.length; // length of the Array
        int low = 0;
        int high = len - 1;

        while(low <= high){
            int mid = low + (high - low)/ 2; // to avoid ArrayIndexOutofBound exception.
            if(target == nums[mid]){
                return mid;
            }
            // Assuming only the left part of the array is sorted.
            if(nums[low] <= nums[mid]){
                // if the target is greater than or equal the element in 0 index and target is less than mid index element that change the position of high to mid-1 index  else change postion of low to mid+1 index.
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            // Assuming only the right part of the array is sorted.
            else{

                // if the target is greater than  the element in mid index element and target is less than or equal to high index element that change the position of low to mid+1 index else change postion high to mid-1 index.

                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
