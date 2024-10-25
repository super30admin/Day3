// Time Complexity : O(logn)
// Space Complexity : O(1)
// Approach : When sorted Array is rotated then one portion of array is always sorted (left or right). Calculate mid if our target is at mid then simple return the mid. If our target is not at the mid then use the sorted part of the array to move left and right pointers. by checking if the target is lying in sorted part of the array.

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            // left array is sorted
            if(nums[low]<=nums[mid]){
                if(nums[low]<= target && nums[mid]>=target){
                    high = mid -1;
                } else{
                    low=mid+1;
                }
            } else{
                // right array is sorted
                if(nums[mid]<=target && nums[high]>=target){
                    low=mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}