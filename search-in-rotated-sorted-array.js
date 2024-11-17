// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) { 
    let low = 0;
    let high = nums.length-1;

    while(low <= high) {
        let mid = Math.floor((low + high) / 2);  //to avoid integer overflow, low+(high-low)/2;

        if(target === nums[mid]) return mid;

        else if(nums[low] <= nums[mid]){  //left part of the array is sorted
            if(target >= nums[low] && target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        else { //right part of the array is sorted
            if(target > nums[mid] && target <= nums[high]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
    }
    return -1;
}