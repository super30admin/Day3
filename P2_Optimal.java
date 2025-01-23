class Solution {
    public int search(int[] nums, int k) {
    
    int n = nums.length;
    int lb = 0, ub = n - 1;

    while (lb <= ub) {
        int mid = lb + (ub - lb) / 2;

        if (nums[mid] == k) return mid;

        if (nums[lb] <= nums[mid]) {                        //check if the left half is sorted
            if (nums[lb] <= k && k <= nums[mid]) {          //target exists in the left sorted half
                ub = mid - 1;
            }
            else {                                          //target does not exist in the left sorted half
                lb = mid + 1;
            }
        } else {                                            //check if the left half is sorted
            if (nums[mid] <= k && k <= nums[ub]) {          //target exists in the right sorted half
                lb = mid + 1;
            } 
            else {                                          //target does not exist in the right sorted half
                ub = mid - 1;
            }
        }
    }
    return -1;
    }
}


// Time Complexity :    O(logn)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    None 


// Your code here along with comments explaining your approach in three sentences only - checking which ones are sorted halves and accordingly performing binary search on them. 


