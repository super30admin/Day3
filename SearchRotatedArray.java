/* Check which part is sorted
Check if target lies in that range
Accordingly make the low/high pointer changes



Time Complexity- O(logN), Space Complexity - O(1)
 */

 class Solution {
    public int search(int[] nums, int target) {
        int low =0;int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }

            if(nums[low]<=nums[mid]){
                if(target<nums[mid] && target>=nums[low]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
             else {
                if(target>nums[mid] && target <=nums[high]){
                    low = mid+1;
                } else {
                    high = mid -1;
                }
             }
        }
        return -1;
    }
}