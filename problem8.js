// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let m = matrix.length;
    let n = matrix[0].length;
    let low = 0;
    let high = m * n - 1;
    while (low <= high){
        let mid = Math.floor(low + (high - low)/2);
        let row = Math.floor(mid / n);
        let col = mid % n;
        if(matrix[row][col] === target){
            return true;
        } else if(matrix[row][col] > target){
            high = mid - 1;
        } else {
            low = mid + 1
        }
    }
    return false;
};