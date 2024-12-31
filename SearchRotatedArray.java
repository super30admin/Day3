// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, followed the approach as discussed in class


// Your code here along with comments explaining your approach in three sentences only
// Followed the binary search approach by checking if left half of array is sorted and target is within left half ,
//  and left half is not sorted , checked in right half of the array and then if target is within right half
//  and then adjusting the low and high variables accordingly


public class SearchRotatedArray {
        public int search(int[] nums, int target) {
            if(nums == null || nums.length == 0){
                return -1;
            }
            int low = 0;
            int high = nums.length-1;
            while(low <= high){
                int mid = low+ (high-low)/2;
                if(nums[mid] == target){
                    return mid;
                }
                if(nums[low] <= nums[mid]){
                    if(target < nums[mid] && target >= nums[low]){
                        high = mid-1;
                    }else{
                        low = mid+1;
                    }
                }else{
                    if(target >nums[mid] && target <= nums[high] ){
                        low = mid+1;
                    }else{
                        high = mid-1;
                    }
                }
                System.out.println("h "+high+" l "+low+" mid "+mid);
            }
            return -1;
        }
}
