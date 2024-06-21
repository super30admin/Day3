// Time Complexity : O(log n)
// Space Complexity : O(1);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

/* find row and coloumn based on middle element and apply binary search*/
class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0; int end = n * m -1;

        while(start <= end) {
            int mid = (start + end) /2;
            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target)
                return;
            else if(matrix[row][col] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}