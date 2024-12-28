// Time Complexity : O (log n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/* 
  One side of the array will be sorted - if target is in that side, search that side as usual
  else use the recursive function to do the process on the other side
*/
class Solution {
    public int search(int[] nums, int target) {
        return enhancedBS(nums, target, 0, nums.length - 1);
    }
    public int enhancedBS(int[] nums, int target, int start, int end) {
        if(start > end) return -1;
        int ns = nums[start];
        int ne = nums[end];
        if(target == ns) return start;
        if(target == ne) return end;
        int mid = (start + end) / 2;
        int nm = nums[mid];
        if(target == nm) return mid;
        else if((target < nm && target > ns) || (ns > ne && target > ns && target > nm)) {
            return enhancedBS(nums, target, start, mid - 1);
        }
        else if((target > nm && target < ne) || (ns > ne && target < nm && target < ne)) {
            return enhancedBS(nums, target, mid + 1, end);
        }
        return -1;
    }
}
