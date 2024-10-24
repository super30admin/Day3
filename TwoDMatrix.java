// Time Complexity :search: O(log (m*n))
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class TwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low = 0; int high = m*n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            //finding the position MID in 2d array
            int r=mid/n;
            int c=mid%n;

            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] > target){
                high = mid-1;
            }else{
                low = mid +1;
            }
        }

        return false;

    }

    public static void main(String args[]) {
        TwoDMatrix array = new TwoDMatrix();
        int[][] nums = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = i * 4 + j;
            }
        }


        System.out.println("search returned  " +array.searchMatrix(nums, 6));

    }
}
