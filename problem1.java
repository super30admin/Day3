//
//Problem1
//Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
//the time complexity of this problem is O(log(n*m))


public class problem1 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high=(n*m)-1;
        while(low<=high){

            int mid=(low+high)/2;
            int row=mid/m;
            int col=mid%m;

            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                low=mid+1;
            }
            else {
                high=mid-1;
            }

        }

        return false;

    }


}
