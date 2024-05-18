//TIme Complexity - O(logn)
//Space Complexity - O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
//In a rotated sorted array, there will atleast be one half that is sorted. We aim to find the mid
//and the using that, check if the first half is sorted. If yes, check if the target is within the range
// greater than first element and lesser than the mid. If it is not in that range, then we make our search space as the right half. 
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if(nums == null || nums.length == 0){
            return -1;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
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