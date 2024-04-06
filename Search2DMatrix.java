// Time Complexity : log(mn)
// Space Complexity : mn
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to unde

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // Row
        int n = matrix[0].length; // R Column

        int lengthOfAllEle = m * n;

        int left = 0;
        int right = lengthOfAllEle - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / n; // I took m first,
            int c = mid % n;

            if (matrix[r][c] == target)
                return true;
            if (target < matrix[r][c]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return false;
    }

}
