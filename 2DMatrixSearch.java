/* Solved this using imaginary flattened 1D array
* Time complexity is O(LogN)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
         int m = matrix.length;
         if (m == 0) return false;
         int n = matrix[0].length;
         int low = 0;
         int high = m * n - 1;
int mid;
int elemnt;
         while(low <= high){
           mid = (low + high) / 2;
           elemnt = matrix[mid/n][mid%n];
        
        if(target == elemnt) return true;
        else{
            if(target < elemnt) high = mid - 1;
            else low = mid + 1;
        }
            
         }

         
return false;
    }
}