// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
public:
    int search(vector<int>& nums, int target) {
       int low = 0;
       int high = nums.size()-1;
       //to avoid the overflow we use this method
       

       while(low <= high) {
           int mid = low + (high - low)/2;
           if(nums[mid] == target) return mid;
           //check if left is sorted
           if(nums[low] <= nums[mid]) {
               //check if target is in this range
               if(nums[low] <= target && target <= nums[mid]) {
                   high = mid-1; 
               } else {
                   low = mid+1;
               }
           } else {
               //check if target is in this range
               if(nums[mid] <= target && target <= nums[high]) {
                 low = mid + 1;
                } else {
                  high = mid - 1;  
                } 
           }
          
       }
        return -1;
    }
};
