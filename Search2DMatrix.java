/*
    Leetcode problem 74: Search a 2D Matrix
    T.C: O(n log(m)) :: S.C: O(1)

    Solved using B.S technique:
    As the elements are sorted from left to right and following to the next row.
    Each row indvidually can be considered as a linearly sorted array an we can
    perform binary search to get the target element and return the truth value.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;

        if (matrix == null || matrix.length == 0) return result;

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            result = binarySearch(matrix[i], 0, m - 1, target);
            if (result) {
                break;
            }
        }

        return result;
    }

    private boolean binarySearch(int[] row, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}