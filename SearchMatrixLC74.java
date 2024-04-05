
// Time Complexity :O(m+n) m- to find exact row where target lies. n- to search in the row.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
//Logic: Iterate through each row and see if target is found.
//if Yes, find target in the row
// if No, return false;
public class SearchMatrixLC74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length) {
            if (matrix[i][0] <= target && matrix[i][j] >= target) {//checking target within the range [First element <= target  =< last element] by looping through each row.
                //Matching target range row is found. iterate on the row till column length;
                while (row <= j) {
                    if (matrix[i][row] == target) return true;
                     else 
                        row++;
                }
                return false;
            } else {
                i++;
            }
        }
        return false;

    }

}
