// Time Complexity : O(log (mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Matrix2DSearch {

    //visualising the 2D array into 1D array
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0; int r = m*n -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int rw = mid/n;
            int cl = mid%n;
            if(matrix[rw][cl] == target) return true;
            else if(matrix[rw][cl] > target) r = mid-1;
            else l = mid+1;
        }

        return false;
    }
}