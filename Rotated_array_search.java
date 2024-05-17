// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
// There will at least the left side, right side, or both sides will be sorted
// If the side is sorted then check if the element can be in that range
// Else select other side

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null){
            return -1;
        }
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while(low <= high){
            int mid = low + (high-low)/2; // avoid overflow
            
            if(nums[mid] == target){
                return mid;
            }
            // left side sorted
            if(nums[low] < nums[mid]){ // equality for single element check
                if(target >= nums[low] && target < nums[mid]){ // no equality for second since id mid == target, return
                    high = mid - 1;
                }
                else{
                    low = mid +1; 
                }

            }
            else{ // right side is sorted
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid -1;
                }
            }

        }
        return -1;
    }
}