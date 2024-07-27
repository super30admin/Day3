// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if(nums === null || nums.length === 0) return -1;
    let low = 0;
    let high = nums.length-1;
    while(low <= high) {
        let mid = Math.floor(low+(high-low)/2);
        if(nums[mid] === target){
            return mid;
        } else if(nums[low] <= nums[mid]){
            if(nums[low] <= target && nums[mid] > target){
                high = mid - 1;
            } else { 
                low = mid + 1;
            }
        } else {
            if(nums[mid] < target && nums[high] >= target){
                low = mid + 1;
            } else { 
                high = mid - 1;
            }
        }
    }
    return -1;
    
};