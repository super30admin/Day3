// Time Complexity : O(log m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
    Since number of cols and number of rows is provided, we can find the position of the matrix item if we imagined a flat array.
    Applied standard binary search and applied the above logic to find the mid element position in array. 
*/

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {

    let m = matrix.length;
    let n = matrix[0].length;
    let high = (m * n) - 1;
    let low = 0;
    while(low <= high){
        let mid = parseInt((high+low)/2);
        //To find the row and column of the pivot element, take 
        //pivot/mid and pivot%mid
        let midRow = parseInt(mid/n);
        let midCol = mid%n;
        if(matrix[midRow][midCol] === target){
            return true;
        }
        else if(matrix[midRow][midCol] > target){
            high = mid-1;
            continue;
        }
        else if(matrix[midRow][midCol] < target){
            low = mid+1;
            continue;
        }
    }

    return false;

};