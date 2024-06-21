// Time Complexity : O(log 10 ** 4)
// Space Complexity : O(10**4)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Set high to be 10**4 as the problem description presented the constraint for array.length and applied standard binary search

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
    let high = 10 ** 4;
    let low = 0; 
        while(low <= high){
            let mid = Math.floor((high+low)/2);
            let midVal = reader.get(mid)
                if( midVal === target){
                    return mid;
                }
                else if(midVal > target) {
                    high = mid-1;
                    continue;
                }
                else {
                    low = mid+1;
                    continue;
                }
        }
        return -1;
};