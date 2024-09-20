// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
// Assuming 2D array as 1D array and 
// finding the row index and col index using mid of 1D array

public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int m = matrix.Length;
        int n = matrix[0].Length;

        int low = 0;
        int high = (m*n) -1;
        while (low <= high){
            int mid = low + (high-low)/2;
            int row = mid/n;
            int col = mid % n; 
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        
        }
        return false;
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        Solution obj = new Solution();

        //Input: matrix = [[1, 3, 5, 7],[10,11,16,20],[23,30,34,60]], target = 3
        //Output: true
        int[][] matrix = new int[][]
        {
            new int[] {1,3,5,7},
            new int[] { 10, 11, 16, 20 },
            new int[] { 23, 30, 34, 60 }
        };

        int target = 31;

        bool result = obj.SearchMatrix(matrix, target);

        Console.WriteLine(result);
    }
}