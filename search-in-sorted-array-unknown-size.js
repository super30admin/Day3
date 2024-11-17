// Time Complexity : O(log T) -> T is the index of target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * function ArrayReader() {
 *
 *     @param {number} index
 *     @return {number}
 *     this.get = function(index) {
 *         ...
 *     };
 * };
 */

/**
 * @param {ArrayReader} reader
 * @param {number} target
 * @return {number}
 */
var search = function (reader, target) {
    let left = 0;
    let right = 1;

    while(reader.get(right) < target) {
        left = right;
        right = 2 * right;
    }

    while(left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if(reader.get(mid) === target) return mid;

        else if(reader.get(mid) > target) {
            right = mid - 1;
        }
        else {
            left = mid + 1;
        }
    }
    return -1;
};