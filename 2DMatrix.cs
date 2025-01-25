public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {

        // Initialize values
        int m = matrix.Length; // row
        int n = matrix[0].Length; // column

        int low = 0; 
        int high = m * n - 1;

        //Implement the while loop here
        while(low <= high){
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int column = mid % n;
            int midValue = matrix[row][column];
            if(target == midValue){
                return true;
            }
            else if(midValue > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
    return false;
    }
    
}