//TC - O(log(m*n))
//SC - O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem
// approach - we are assuming the matrix as a 1d array. And then carrying out normal Binary Search on the array

/**
 *  Search2DMatrix : Search2DMatrix
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 24, 2024)
 * @since : 1.0 (Oct 24, 2024)
 *
 */
 public class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
   int m = matrix.length, n = matrix[0].length;
   int low = 0, high = (m*n)-1;
   while(low <= high){
    int mid = low + (high-low)/2;
    int r = mid/n;
    int c = mid%n;
    if(matrix[r][c] == target){
     return true;
    }
    else if(matrix[r][c] < target){
     low = mid+1;
    }else{
     high = mid-1;
    }
   }
   return false;
  }
}
