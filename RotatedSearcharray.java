// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        if (nums == null || nums.length == 0) {
            return -1;
        }

        while (left < right) {
            int mid = (left + right) / 2; 
            if (nums[mid] > nums[right]) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }
        int pivot = left;
        left = 0;
        right = nums.length-1;

        if (nums[pivot] <= target && target <= nums[right]) {
            left = pivot;
        }
        else{
            right = pivot-1;
        }
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }
        }
        return -1;
    }
}