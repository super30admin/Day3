// Time Complexity : O(logn) everytime we are reducing the search space by 1/2.
// Space Complexity : O(logn) auxiliary stack space for recursion calls, can be eliminated by using while loop.
// Did this code successfully run on Leetcode : yes, it did.
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
class RotatedBS {
    //I have used recursion for this.
    private int binarySearch(int[] nums, int target, int low, int high)
    {
        //checking when the search is completed and not found the element.
        if(low > high)
            return -1;
        int mid = (low + high)/2;
        //checking if the mid element is the target.
        if(nums[mid] == target)
            return mid;
        /*if not then the element lies either in the left or right subarrays.
        since the array is rotated, only one of the subarray will be in sorted state,
        we will find which subarray is in sorted state, then check if our target exists in that range
        if yes, then we perform binarysearch that subarray, otherwise we perform binarysearch on the other half.
        */
        if(nums[low] <= nums[mid])
        {
            if(nums[low] <= target && nums[mid] > target)
               return binarySearch(nums, target, low, mid-1);
            else
                return binarySearch(nums, target, mid+1, high);
        }
        else
        {
            if(nums[mid] < target && nums[high]>= target)
                return binarySearch(nums, target, mid+1, high);
            else
                return binarySearch(nums, target, low, mid-1);
        }

       
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
}