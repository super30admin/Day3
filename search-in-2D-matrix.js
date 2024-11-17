// Time Complexity : O(log(mxn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let rows = matrix.length;
    let cols = matrix[0].length;
    let low = 0;
    let high = (rows*cols) - 1;

    while(low <= high) {
        let mid =  Math.floor(low + (high - low) / 2);

        let r = Math.floor(mid/cols);
        let c = Math.floor(mid%cols);

        if(target === matrix[r][c]) return true;
        else if(target > matrix[r][c]){
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
    }
    return false;
};