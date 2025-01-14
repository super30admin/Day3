package BinarySearch;


// Time Complexity : O(Log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
public class RotatedSortedArray {
   public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

       System.out.println(search(nums, target));
   }

   public static int search(int[] nums, int target) {

       if (nums == null || nums.length == 0) {
           return -1;
       }
       if (nums.length == 1){
           if (nums[0] == target) {
               return 0;
           }
           return -1;
       }

       int left = 0;
       int right = nums.length-1;
       int mid = -1;

       while(left <= right) {
            mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[left] <= nums[mid]) {
                if (target < nums[mid] && target>=nums[left]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }

            } else{
                if (target > nums[mid] && target<=nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
       }

       return -1;
   }
}
