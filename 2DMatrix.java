class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int high=(n*m)-1;
        int mid=0;

        while(low<=high){
            mid=(low+high)/2;
            if(matrix[mid/m][mid%m]==target)
             return true;
    
            if( matrix[mid/m][mid%m]>target)
              high=mid-1;
              else
              low=mid+1;

        }
        return false;
    }
}