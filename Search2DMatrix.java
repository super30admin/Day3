public class Search2DMatrix {

    /**
     Time Complexity - o(logMxN)
     Space Complexity - o(1)


     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null)
            return false;

        // find rows and coloums
        // rows
        int m = matrix.length;
        // coloums
        int n = matrix[0].length;
        // Find low and high
        int low = 0;
        /**
         * If imagine it as one d array and count number of elements.
         * ( (number of rows * number of cols) -1).
         calculate mid.
         low+ high-low/2;
         then use mid to calculate row and col
         */

        /**

         * calculate row. devide index by number of rows
         * To locate rows devide the index by number of rown.
         * o/2 = 0 - row zero. 5/4 = 1 - row one
         *
         calculate col.
         col lies 0- (n-1) bcos there are n cols.
         when we bind something in range, we use modulus.
         index % number of cols. 5%4 = 1 - col 1.

         */

        int high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
