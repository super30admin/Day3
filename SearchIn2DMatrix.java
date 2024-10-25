class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Time Complexity : O(log(m*n)) = logm + logn
        // Space Complexity : O(1)
        // Approach : Identify the row where potential target can be found and apply Binary search on the row to check if it exists
        int rowIdx = getSearchRow(matrix,target);
        if (rowIdx == -1){
            return false;
        } else {
            return binarySearch(matrix,rowIdx,target);
        }

    }
    public int getSearchRow(int[][] matrix, int target){
        int columnLen = matrix[0].length - 1;

        // perform binary search on rows
        int topRow = 0;
        int bottomRow = matrix.length-1;
        while(topRow<=bottomRow){
            int midRow = bottomRow + (topRow-bottomRow)/2; // midRow
            // check if traget exists in the midRow
            if(matrix[midRow][0] <= target && matrix[midRow][columnLen] >= target){
                return midRow;
            } else if(matrix[midRow][0]>target){
                bottomRow = midRow-1;
            } else{
                topRow = midRow+1;
            }
        } 
        return -1;
    }

    public boolean binarySearch(int[][] matrix, int row, int target){
        int low = 0;
        int high = matrix[row].length-1;
        while (low<=high){
            int mid = low + (high -low)/2;
            if(matrix[row][mid] == target){
                return true;
            } else if (matrix[row][mid]> target){
                high=mid-1;
            } else{
                low = mid+1;
            }
        }
        return false;
    }
}