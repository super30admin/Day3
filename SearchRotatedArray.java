// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if(nums==null||nums.length==0)
            return -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[low]){
                if(target>=nums[low]&&target<nums[mid]){
                    high = mid - 1;
                }else{
                    low  = mid + 1;
                }
            }
            else{
                if(target<=nums[high]&&target>nums[mid]){
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
