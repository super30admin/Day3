// unable to open in leet code requires premium subscription
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
    let low = 0;
    let high = 1;
    while(reader.get(high) < target){
        low = high; 
        high *= 2;
    }
    while(low <= high) {
        let mid = Math.floor(low + (high - low)/2);
        if(reader.get(mid) === target) {
            return mid;
        } else if(reader.get(mid) > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
        if(reader.get(low) === target) return low;
    }
    return -1;
};