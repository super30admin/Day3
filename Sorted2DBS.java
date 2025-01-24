// Time Complexity : O(logm + logn) because first we need to know i which row exactly the target might exists and need to check that internal array using binary search.
// Space Complexity : nothing extra space just constant.
// Did this code successfully run on Leetcode : yes, it did.
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
public class Sorted2DBS {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        //Approach - Assume to Flatten the 2D array into a 1D array the the !D array would be in sorted order, perform binary search.
        int low = 0;
        int high = (n*m) -1;

        while(low <= high){
            int mid = (high + low)/2;
            //in order to convert the index in 1D array to the real row we need to divide the index by number of colums and 
            //if we need to find teh column then we need to find the modulo of index with no of columns.
            int row = mid/n;
            int col = mid%n;

            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] < target)
                low = mid+1;
            else
                high = mid-1;
        }
       return false;
    }
}
