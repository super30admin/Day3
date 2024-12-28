// 74. Search a 2D Matrix

// TC: O(log(n)) where n is the number of elements in the input array
// SC: O(1)
// Solved in LC: Yes

// Approach 1
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target)
            return false;
        int l = 0, h = m - 1;
        int possibleRow = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] > target)
                h = mid - 1;
            else {
                l = mid + 1;
                possibleRow = mid;
            }
        }
        if (possibleRow == -1)
            return false;
        l = 0;
        h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (matrix[possibleRow][mid] == target)
                return true;
            else if (matrix[possibleRow][mid] > target)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}

// Approach 2

class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int l = 0;
        int h = (m * n) - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            int row = mid / n, col = mid % n;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}