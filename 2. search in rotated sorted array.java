// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Followed well in class but got very confused when tried to replicate the logic. I tried to come up with the logic and got confused in all the loops


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = low + (high-low)/2;
            
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] >= nums[low] ){//left sorted array
                if (target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
        
             }
             else{ //right sorted
                if (target > nums[mid] && target <= nums[high]){
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
