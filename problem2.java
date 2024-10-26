//Problem2
//Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
// Time complexity is O(log(n)), where n is the size of the array
public class problem2 {

    public int search(int[] nums, int target) {

        int low=0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if (nums[mid]>=nums[low]){
                if (nums[low]<=target && nums[mid]>=target) {
                    low=mid+1;
                }
                else {
                    high=mid-1;
                }
            }
            else
            {
                if (nums[high]>=target && nums[mid]<=target) {
                    high=mid-1;
                }
                else {
                    low=mid+1;
                }
            }


        }
        return low;
    }

}
