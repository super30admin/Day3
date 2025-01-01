// Time Complexity :O(log(m*n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int m = nums.length;
        int n = nums[0].length;
        if(target > nums[m-1][n-1]) return false;
        int low = 0; int high = m*n  - 1;// MIS, take m and n as nums.length and nums[0].length, & not as nums.length-1 and nums[0].length-1. As it will change the high position.
        while(low <= high){
            int mid = low + (high - low)/2;

            //Seeing where this mid lies
            int row = mid / n;
            int col = mid % n;

            if(nums[row][col] == target){
                return true;
            }else if(nums[row][col] >= target){                
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}