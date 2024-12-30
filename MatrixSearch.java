//Time Complexity: O(log(m * n))
//Space Complexity O(1)

public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0)
        {
            return false;
        }

        int m = matrix.length; //no of rows
        int n = matrix[0].length; // no of columns
        int low = 0;
        int high = m * n - 1;

        while(low<=high)
        {
            int mid = low + (high - low)/2;
            int row = mid/n; // get the row index
            int col = mid%n; //get the column index

            if(matrix[row][col]==target)
            {
                return true;
            }
            else if(matrix[row][col]>target)
            {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return false;

    }
}
