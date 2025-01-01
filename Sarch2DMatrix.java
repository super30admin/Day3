// Time Complexity :log(m*n)
// Space Complexity :log(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only 
/*Row can be located by index/no of columns and column can be calculated by index%no of colums.
 * We split the matrix in halves using binary search
 */


class Sarch2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0){
            return false;
        }

        int m = matrix.length;
        int n= matrix[0].length;
        int low= 0;
        int high=m+n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target)
                   high=mid-1;
            else {
                low=mid+1;
            }
        }
        return false;
        
    }
}