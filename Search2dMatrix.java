// Time Complexity :O(logM*N)
// Space Complexity :O(1)
public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)
            return false;
        int r = matrix.length;    //rows
        int c = matrix[0].length; //cols
        int low = 0;
        int high = r*c -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/c;
            int col=mid%c;
            if(matrix[row][col]==target){
                return true;
            }else if (matrix[row][col]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
    }
        return false;
    }
}
