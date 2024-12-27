// TC : O(log(n))
// SC :  O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes. I assumed we have to check to the left and right side of mid without including mid. but this gives a problem when mid becomes 0 so mid - 1 and mid + 1 result in a array index out of bound.


// After finding mid point, we cheeck that whether the left part or the right part of mid is sorted and then we decide which part to explore by check if our target is in the specified range of sorted portion.

class Solution2 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){
                if((target >= nums[low]) && (target <= nums[mid])){
                    high = mid -1;
                }
                else{
                    low = mid + 1;
                }
            }
            else if (nums[mid] <= nums[high]){
                if((target >= nums[mid]) && (target <= nums[high])){
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