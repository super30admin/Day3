// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : How to imagine a 2d matrix to a 1d array took time without actually adding
// everything explicitly.

// Your code here along with comments explaining your approach in three sentences only
/*
 Imagining the 2D matrix as an 1D sorted array the performing the binary search on the imaginary
 array. Once the middle index is found, correlate that imaginary index as a 2d graph points and check the value
 at that point as middle value.
 */


public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int length = m * n;
        int low = 0;
        int high = length - 1;

        while(low <= high) {
            int mid = low + ((high - low)/2);
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,4,6}, {8,10,12,13},{50,55,78,100}};
        System.out.println(searchMatrix(matrix, 13));
        System.out.println(searchMatrix(matrix, 11));
    }
}
