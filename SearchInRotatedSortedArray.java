class Solution {
    public int search(int[] nums, int target){ 
    if (nums == null || nums.length ==0){
        return -1;
    }
    
       int low = 0;
       int high = nums.length -1;
       while (low <= high){
       int mid = low + (high - low) /2;
        if (nums[mid] == target) {
            return mid;
        }
        //check if left part is sorted
        if (nums[low] <= nums[mid]){
            // check if the target will be present or not
            if (target >= nums[low] && target < nums[mid]){
                //the target should be here, do a binary search here
                high = mid -1;
            } else {
                low = mid +1;
            }
        } else {
             if (target > nums[mid] && target <= nums[high]){
                //the target should be here, do a binary search here
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
       }
       return -1;
    }
}