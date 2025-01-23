class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
    
    if (mat.length == 0 || mat[0].length == 0) {    //checking if the matrix is empty
        return false;
    }

    int n = mat.length;     //initialise rows
    int m = mat[0].length;  //initialise cols

    for (int i = 0; i < n; i ++) {          //traverse through rows
        for (int j = 0; j < m; j ++) {      //traverse through rows
            if (mat[i][j] == target) {
                return true;
            }
        }
    }
    return false;
    }
}


// Time Complexity :    O(n * m)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


/* Your code here along with comments explaining your approach in three sentences only - 

This is a brute force approach in which we are traversing through the 2D matrix looking for the target. 

*/
