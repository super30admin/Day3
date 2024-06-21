/*
    1. Time Complexity : O(log(m*n)) => O(logm + logn)
    2. Space Complexity : O(1)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * Assume the matrix is flattened into 1D array.
 * Value at matrix[i][j] is represented as arr[(i * cols) + j]
 * Value at arr[i] is the value at matrix[i /cols][i%cols]
 * Now perform binary search on the 1D array where low = 0 and high = m * n - 1 (last index in the 1D array)
 */


class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = rows * cols - 1, mid, value;
        while (low <= high) {
            mid = low + (high - low) / 2;
            value = matrix[mid/cols][mid%cols];
            if (value == target) return true;
            else if (value < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[] targets = {0,1,5,9,16,20,30,60,70};
        for (int target : targets) {
            System.out.println("Found target " + target + " :"+ searchMatrix(matrix, target));
        }
    }
}