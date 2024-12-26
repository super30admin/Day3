// Time Complexity : O(logM+logN)=O(log(M⋅N))
// Space Complexity : O(1) No additional data structures are used.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Since it is searching in a sorted array - use Binary search technique

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int mid = start + (end - start) / 2;

        // First try to find the row of interest using binary search and then look for target in that row
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == matrix[mid][0])
                return true;
            if (matrix[mid][0] < target && target <= matrix[mid][matrix[0].length - 1])
                break;
            if (target <= matrix[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = matrix[0].length - 1;
        int row = mid;

        // look for target in that row using binary search
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == matrix[row][mid])
                return true;
            if (target <= matrix[row][mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        SearchMatrix obj = new SearchMatrix();

        boolean result = obj.searchMatrix(matrix, 19);
        System.out.println("Element found in 2D matrix: " + result);

        result = obj.searchMatrix(matrix, 11);
        System.out.println("Element found in 2D matrix: " + result);
    }
}