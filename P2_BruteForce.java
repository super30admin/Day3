class Solution {
    public int search(int[] nums, int k) {

        int n = nums.length;

        for (int i = 0; i <= n; i ++) {
            if (nums[i] == k) return i;
        }
        return -1;
    }
}

// Time Complexity :    O(n)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    None 


// Your code here along with comments explaining your approach in three sentences only - linear search operation 