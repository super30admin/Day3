// Time Complexity :O(logm*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only: I followed the binary search approach by treating the matrix as a 1D array of length m*n-1. I calculate the middle index (mid), 
// then use it to determine the corresponding row and column indices. Using these indices, I access the value at mid. If mid matches the target, I return true. If not, I compare mid with the target: if mid is greater than the target, the target may lie in the left part of the matrix. Otherwise, the target is likely in the right part. 
// This process continues while(low<=high), reducing the search space by half at each step

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;int high=m*n-1;
          while(low <= high){
             int mid=low+(high-low)/2;
              int r=mid/n;
              int c=mid%n;
             
        int midvalue=matrix[r][c];
            if(midvalue == target){
                return true;
            }else if(midvalue > target){
                   high=mid-1; 
                }else{
                    low=mid+1;
            }
            
        }
        return false;
    }
}