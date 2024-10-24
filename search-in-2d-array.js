/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  let m = matrix.length;
  let n = matrix[0].length;
  let low = 0;
  let high = m * n - 1;

  while (low <= high) {
    let mid = Math.floor(low + (high - low) / 2);
    let row = Math.floor(mid / n);
    let column = Math.floor(mid % n);

    if (matrix[row][column] == target) {
      return true;
    } else if (matrix[row][column] > target) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }

  return false;
};

console.log(
  searchMatrix(
    [
      [1, 3, 5, 7],
      [10, 11, 16, 20],
      [23, 30, 34, 60],
    ],
    3
  )
);
