/*
TC --> O(log(m*n))
SC --> O(m*n)
 */
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;
        int[] newList = new int[ROW * COL]; //m*n
        int index = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                newList[index] = matrix[i][j];
                index++;

            }//for
        }//for

        //perform binary search here -->
        int left = 0;
        int right = ROW * COL - 1;
        int mid;
        int midVal;
        while (left <= right) {
            mid = left + (right - left) / 2;
            midVal = newList[mid];
            if (midVal == target) {
                return true;
            } else if (midVal > target) {
                //move left
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }//while
        return false;

    }//method
}//class
