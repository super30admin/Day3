public class SearchTwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int m = matrix.length;
        int n = matrix[low].length;
        int high = (m*n)-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            int row = mid/n;
            int column = mid%n;
            if(matrix[row][column] == target){
                return true;
            }
            else{
                if(matrix[row][column]<target){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }

        }
        return false;
    }
}
