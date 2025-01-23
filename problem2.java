// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only

// If the mid and the target are on the same "side" of the roated array -> then proceed with standard binary search
// If the mid and the target are on different "sides" of the rotated array -> then proceed with inverting the search criteria

class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int l = 0, r = nums.length - 1;

        while(l<=r){
            int mid = (l+r)/2;

            if(nums[mid] == target){
                res = mid;
            }

            // if mid and target in the same half
            if((nums[mid] >= nums[0] && target >= nums[0]) || (nums[mid] < nums[0] && target < nums[0])){
                if(nums[mid] > target){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            // mid and target not in the same half
            else{
                if(nums[mid] < target){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
        }

        return res;
    }
}