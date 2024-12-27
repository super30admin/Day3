public class Solution
{
    public bool SearchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.Length == 0)
        {
            return false;
        }
        int row = matrix.Length, col = matrix[0].Length;
        int low = 0, high = row * col - 1;
        int column;
        while (low <= high)
        {
            var mid = low + (high - low) / 2;
            row = mid / col;
            column = mid % col;
            if (matrix[row][column] == target)
            {
                return true;
            }
            if (matrix[row][column] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return false;
    }
}