//TC: O(logm + logn)
//SC: O(1)
public class Solution_2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows-1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][cols-1]){
                break;
            }
            if(target < matrix[mid][0])
                high = mid - 1;
            else
                low = mid + 1;
        }
        low = 0;
        high = cols - 1;
        int r = mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(matrix[r][mid] == target)
                return true;
            if(target < matrix[r][mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
