// Time Complexity : O(log(m×n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : ues
// Any problem you faced while coding this : No

/**
 * The same code works on leetcode but on editor it does not works correctly
 */


// Your code here along with comments explaining your approach in three sentences only


public class Problem1 {

    public static void main(String[] args) {

        Problem1 p = new Problem1();

        int[][] matrix = new int[4][4];
//        matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        matrix[0] = new int[] {1, 3, 5, 7};
        matrix[1] = new int[] {10, 11, 16, 20};
        matrix[2] = new int[] {23, 30, 34, 60};
        int target = 60;

        System.out.println(p.search(matrix, target));
    }

    boolean search(int[][] matrix, int target)
    {
        int m = matrix.length; // no of rows
        int n = matrix[0].length; // no of cols

        int low = 0;
        int high = m*n - 1;

        while (low <= high) {

            int mid = low + (high - low) /2;

            int row = mid % n;
            int col = mid / n;

            if (matrix[row][col] == target) {
                return true;
            }
            else if(matrix[row][col] > target) {
                high = mid - 1;
            } else {
                low  = mid + 1;
            }
        }

        return false;
    }
}
