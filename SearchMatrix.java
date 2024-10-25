// Time Complexity : Given in the Question O (log(m* n)) because we are performing binary search over a range of size m* n
// Space Complexity : O(1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// We are flattening a 2D matrix and treating it as a 1D sorted array
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = matrix[mid / cols][mid % cols]; // mapping the mid index to the matrix element

            // performing binary search to compare the target with the matrix element
            if (midValue == target) {  // of target is equal , return true
                return true;
            } else if (midValue < target) {
                low = mid + 1; // if target is > index, search in right array
            } else {
                high = mid - 1; // else search in left array
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SearchMatrix searcher = new SearchMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 10;
        boolean result = searcher.searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
    }
}