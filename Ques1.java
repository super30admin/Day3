class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Step 1: Identify the potential row where the target could exist.
        int rowIdx = searchPotentialRow(matrix, target);
        
        // Step 2: If a valid row is found, perform binary search on that row.
        if (rowIdx != -1) {
            return binarySearchOverRow(rowIdx, matrix, target);
        } else {
            // If no valid row is found, the target does not exist in the matrix.
            return false;
        }
    }

    public int searchPotentialRow(int[][] matrix, int target) {
        // Binary search to find the row where the target could exist.
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the target is within the range of the current row.
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length - 1]) {
                return mid; // Return the index of the row where the target could be.
            } else if (matrix[mid][0] < target) {
                // Target is larger than the first element of this row. Search further down.
                low = mid + 1;
            } else if (matrix[mid][0] > target) {
                // Target is smaller than the first element of this row. Search further up.
                high = mid - 1;
            }
        }
        return -1; // No valid row found.
    }

    private boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {
        // Perform binary search on the identified row to check for the target.
        int low = 0;
        int high = matrix[rowIdx].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[rowIdx][mid] == target) {
                return true; // Target found.
            } else if (matrix[rowIdx][mid] > target) {
                // Target is smaller than the mid element. Search the left part.
                high = mid - 1;
            } else {
                // Target is larger than the mid element. Search the right part.
                low = mid + 1;
            }
        }
        return false; // Target not found in the row.
    }
}
