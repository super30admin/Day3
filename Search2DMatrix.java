// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, followed the approach as discussed in class


// Your code here along with comments explaining your approach in three sentences only
// Followed the binary search approach by calculating the row and column of the mid element using divide and mod operations

public class Search2DMatrix {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length ==0){
                return false;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int low = 0;
            int high = m*n -1;

            while(low <= high){
                int mid = low + (high-low)/2;
                int r = mid/n;
                int c = mid%n;
                System.out.println("r "+r+" c "+c);
                if(matrix[r][c] == target){
                    return true;
                }
                if(matrix[r][c] > target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            return false;
        }
}
