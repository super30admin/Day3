/**
 * Alog:
 * First find the row which is present using binary Search
 * Then using the binary search find the value
 *
 * Time Complexity --> O(log(m*n))
 * Space Complexity --> O(1)
 *
 */
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = findRowIndex(matrix,target);
        return search(matrix[rowIndex],target);
    }

    public static int findRowIndex(int[][] matrix, int target){
        int start = 0;
        int end = matrix.length;
        while(start<end && end-start>1){ // THis is the Criteria for finding the correct row
            int mid = (start+end)/2;
            if(matrix[start][0]<=target && target<matrix[mid][0]){
                end = mid;
            }else{
                start = mid;
            }
        }
        return start;
    }

    public static boolean search(int[]matrixRow, int target){
        int low = 0,high = matrixRow.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(matrixRow[mid]==target)
                return true;
            else if (matrixRow[mid]<target) {
                low = mid+1;
            }else {
                high = mid -1;
            }
        }
        return false;
    }
}