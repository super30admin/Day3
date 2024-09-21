// Time Complexity : O(log(m+n))
// Space Complexity : O(1)  no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n= matrix[0].length;
        int i=0, j=m*n-1;
        while(i<=j){
            int mid = i+(j-i)/2;        
            if(matrix[mid/n][mid%n]==target){
                return true;
            }
            else if(matrix[mid/n][mid%n]>target){
                j=mid-1;
            }
            else i=mid+1;
        }
        return false;

    }
}
