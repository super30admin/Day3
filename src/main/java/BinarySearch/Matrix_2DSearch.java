package BinarySearch;

// Time Complexity : O(Log(N*M)) : Log(M) + LOg(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

public class Matrix_2DSearch {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = (matrix.length * matrix[0].length) - 1;
        int mid = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            //leftMost Element :
            int mV = matrix[mid/cols][mid%cols];

            if(mV == target) {
                return true;
            }

            if(target < mV) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }

        return false;
    }
}

