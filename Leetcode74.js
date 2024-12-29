/**
 TC: O(log(n)) where n is the number of elements in the input array
 SC: O(1)
 Solved in LC: Yes
 */
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let row = 0;
    let leftPointer = 0;
    let rightPointer = matrix[row].length - 1;

    while(leftPointer <= rightPointer && row < matrix.length) {
        if(matrix[row][matrix[row].length - 1] < target) {
            row++;
            continue;
        }

        const middle = Math.floor((leftPointer + rightPointer) / 2);

        if(matrix[row][middle] === target) {
            return true;
        }

        if(matrix[row][middle] > target) {
            rightPointer = middle - 1;
            continue;
        }

        leftPointer = middle + 1;
    }

    return false;
 };
 console.log([[1,3,5,7],[10,11,16,20],[23,30,34,60]],3)