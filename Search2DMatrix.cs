//Algo: Binary Search.
//Logically converted the array t0 1D array and then applied the BS.
//for BS converted mid to 2D matrix row and column index and the checked target,
//and accordingly reducted the search space.
//TC: O(logN)
//SC: O(1) no extra space used

public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        
        if(matrix == null){
            return false;
        }
        
        int rowSize = matrix[0].Count();
        int colSize = matrix.Count();
        
        int low = 0;
        int high = (rowSize * colSize) - 1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            int rowIndex = mid/rowSize;
            int colIndex = mid%rowSize;
            
            int midVal = matrix[rowIndex][colIndex];
            if(midVal == target){
                return true;
            }
            
            if(target < midVal){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return false;
    }
}