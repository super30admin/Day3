// Time Complexity: O(log n)
// Space Complexity: O(1)

// This is a variation of classical binary search. Instead of checking mid array element,
// row and column number is calculated based on the mid, / and % respectively.

// Iterative Binary Search
public class Searcha2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int r = matrix.length;
        int c = matrix[0].length;
        int n = r * c;

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / c;
            int column = mid % c;
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 3)); // true
        System.out.println(searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 13)); // false
    }

}