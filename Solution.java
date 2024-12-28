// Time Complexity : O(log n)
// Space Complexity : no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
//in all cases, at least one side of mid will be sorted
//if left is sorted, check if target lies in bounds of left, if not, call binary search on right
//similarly for right

class Solution {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        return binarySearch(nums, target, low, high);
    }

    private static int binarySearch(int[] nums, int target, int low, int high){
        int mid = low + (high-low)/2;
        if(nums[mid] == target) return mid;
        if(low == high){
            if(nums[low] == target) return low;
            else return -1;
        }
        if (low == high-1){
            if(nums[low] == target) return low;
            else return nums[high] == target ? high : -1;
        }
        else if(nums[mid-1] >= nums[low]){
            if (nums[low] <= target && nums[mid-1] >= target)
                return binarySearch(nums, target, low, mid-1);
            else return binarySearch(nums, target, mid+1, high);
        }else if((nums[mid+1] < nums[high])){
            if (nums[mid+1] <= target && nums[high] >= target)
                return binarySearch(nums, target, mid+1, high);
            else return binarySearch(nums, target, low, mid-1);
        }
        return -1;
    }
}