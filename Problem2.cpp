// Search in Rotated Sorted Array

//Time Complexity: O(log(n))
//Space Complexity: O(1)
// Code ran successfully on leetcode
// Approach:

//Checking which half of the array is sorted and then binary searching on that half. 

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0; 
        int high = nums.size() - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1; 
                }else{low = mid + 1;}
            }else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1; 
                }else{high = mid - 1;}
            }
        }
        return -1;
    }
};