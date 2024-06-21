// Time Complexity : O(log(m*n))
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows-1;
        int mid = 0;
        while(top<=bottom){
            mid = (top+bottom)/2;
            if(matrix[mid][0]>target){
                bottom=mid-1;
            }else if(matrix[mid][cols-1]<target){
                top=mid+1;
            }
            else{
                break;
            }           
        }

        if (top>bottom){
            return false;
        }
        int l = 0;
        int r = cols-1;
        System.out.println(matrix[mid][0]);
        while(l<=r){
            int mid1 = (l+r)/2;
            System.out.println(matrix[mid][mid1]);
            if (matrix[mid][mid1] == target) {
                return true;
            } else if (matrix[mid][mid1] > target) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }
        }
        return false;
    }
}