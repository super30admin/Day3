// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 In a rotated sorted array, when array is divided, we know that at least one part of it is always sorted. 
 If one part is sorted - then we check if the target exists in its constraints, 
 if so we search the target in its constraints else we delegate to the right portion of the array and repeat this step. 
*/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let high = nums.length - 1;
    let low = 0;
    while(low <= high){
        let mid = parseInt((high+low)/2);

        if(nums[mid] === target){
            return mid;
        }
        //Check at least if left array is sorted
        if(nums[low] <= nums[mid]){
            if(target >= nums[low] && target <= nums[mid]){
                    high = mid-1;
                    continue;
                }
                else {
                    low = mid+1;
                    continue;
                }
            }
        //Else Right array is sorted
        else {
            if(target >= nums[mid] && target <= nums[high]){
                    low = mid+1;
                    continue;
                }
                else {
                    high = mid-1;
                    continue;
                }
            }
    }

    return -1;
};