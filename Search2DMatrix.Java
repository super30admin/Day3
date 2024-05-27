## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

// Time Complexity :O(log(m*n))
// Space Complexity :Constant Space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only
/* 
 * Since i need to find the element in O(log(m*n)), need to do a binary search in the matrix
 * Binary Search reuires us to locate the elements in matrix by calculating the mid each time and comparing it with the target till it is found.
 * For this we iterate over the matrix by calculating low, high and update mid value based on the comparision with target till it is found.If not found we return false,else true.
 */
class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        if(matrix.length==0|| matrix==null)
        {
            return false;
        }
        
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int row=mid/n;
            int column=mid%n;
            if(matrix[row][column]==target)
            {
                return true;
            }
            else if(target>matrix[row][column])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return false;
    }
}