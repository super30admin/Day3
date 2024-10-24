//33. Search in Rotated Sorted Array - https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//Time Complexity: O(log(n))
//Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {
        //base case
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0; int high = nums.length-1;
        while (low <= high){ //'=' is used if low and high both point to the same element

            int mid = low + (high-low)/2; //to avoid the overflow condition

            if(nums[mid] == target){ //if mid is the target element
                return mid;
            } else if(nums[low] <= nums[mid]){ //left side is sorted
                if(nums[low] <= target && nums[mid] > target){ //target lies on sorted side
                    high = mid-1;
                } else{
                    low = mid+1;
                }
            } else { //right side is sorted
                if(nums[mid] < target && nums[high] >= target){
                    low = mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}