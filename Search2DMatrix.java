/* Approach 1
 r = mid % row;
   c = mid % col;
   Treat matrix as an array and the r and c are the indexes.

   OR
Approach 2
   Binary Search for the target in each row.
   Once row is determined binarySearch in columns pof that row.

   Time Complexity - O(Log(mn)), Space Complexity - O(1)
*/

// Approach 2

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
         
         int lowR = 0 ; int lowC = 0;
         int highR = row-1; int highC = col-1;

         while( lowR <= highR){
            int mid = lowR + (highR-lowR)/2;
            
            if(matrix[mid][highC] >= target && matrix[mid][lowC]<= target){
                while(lowC<=highC){
                    int midC = lowC+(highC-lowC)/2;
                    if(matrix[mid][midC] == target) return true;
                    if(target>matrix[mid][midC]) lowC=midC+1;
                    else highC = midC-1;
                }
                
            }
             else if (target < matrix[mid][lowC]) {
                highR = mid-1;
             }
             else {
                lowR = mid+1;
             }
         }
         return false;
    }
}