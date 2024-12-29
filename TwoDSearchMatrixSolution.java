class TwoDSearchMatrixSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int low = 0;
        int high = rowLength * columnLength - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / columnLength;
            int column = mid % columnLength;
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}