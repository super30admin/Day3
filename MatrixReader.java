public class MatrixReader {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0, h=m*n-1;

        while(h>=l){
            int mid = (l+h)/2;
            if(matrix[mid/n][mid%n] > target){
                h = mid-1;
            } else
            if(matrix[mid/n][mid%n] < target){
                l = mid+1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
