// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I initially wanted to use two stacks to split the array
// at pivot and perform binary search on both these but soon realized it violates space complexity
//and unnecessarily complicating the task.

// Your code here along with comments explaining your approach in three sentences only
/*
 In the case of rotated sorted array, from the calculated middle value, at any point either side of the
 middle value is always sorted. Validate if the target value lies in between the middle value to either
 of the ends and if it is present proceed with binary searching.
 */


public class RotatedSearch {
    public static int search(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;

        while(low <= high) {
            int mid = low + ((high-low)/2);
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid;
                }
                else {
                    low = mid+1;
                }
            }
            else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid+1;
                }
                else {
                    high = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,1,2,3};
        int target = 1;
        int ans = search(nums, target);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }
}