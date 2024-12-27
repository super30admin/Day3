// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class RotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums  == null && nums.length  ==  0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        //finding the pivot  since it is not sorted
        while(left < right){
            int midpoint = left + (right-left)/2;
            if(nums[midpoint] > nums[right]){
                left = midpoint +1;
            }else{
                right = midpoint;
            }
        }
        int start = left;
        left = 0;
        right  = nums.length-1;

        if(target >= nums[start] && target <= nums[right]){
            left = start;
        }else{
            right = start;
        }

        while(left <= right){

            int midpoint = left + (right-left)/2;
            if(nums[midpoint] == target){
                return midpoint;
            }
            else if(nums[midpoint] < target){
                left = midpoint+1;
            }else
                right = midpoint -1;
        }
        return -1;

    }
}