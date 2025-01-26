// Time Complexity : O(logn)+O(logm) n is row count and m is column count
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// approach - performed two binary operations, first operation to find the row index in which target 
// is present and second binary operation to search element in the row found in first operation

public class Solution {

    public int GetRowIndex(int[][] matrix, int target,int n, int m)
    {
        int low = 0;
        int high = n-1;
        while(low<=high)
        {
            int mid = low + (high - low)/2; // avoid integer overflow
            if(target >= matrix[mid][0] && target <= matrix[mid][m-1])
            {
                return mid;
            }
            else if(target < matrix[mid][0])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
    public bool SearchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.Length ==0)
        {
            return false;
        }
        int n = matrix.Length;
        int m = matrix[0].Length;
        int rowIndex = GetRowIndex(matrix,target,n,m);
        if (rowIndex == -1)
        {
            return false;
        }

        // perform binary search in the row found out from above search
        int low = 0;
        int high = m-1;

        while(low <= high)
        {
            int mid = low + (high - low) /2;
            if(target == matrix[rowIndex][mid])
            {
                return true;
            }
            else if(target > matrix[rowIndex][mid])
            {
                low = mid + 1;
            }
            else 
            {
                high = mid -1;
            }
        }
        return false;
    }
}