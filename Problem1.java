// Time Complexity :O(M∗Log(N))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// binary search on each row

//Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {



    int r = 0;

    while (r<matrix.length){//r==0
        int low = 0 ;
        int high = (matrix[0].length-1);
        int c=0;

        while(low<=high){
        int mid = low + (high - low)/2;
        c = mid;
        if(matrix[r][c] == target){
            return true;
        }else if(matrix[r][c] < target){
            low = mid+1;
        }else{
            high = mid-1;
        }
     }
     r++;
    }

        return false;
    }



}


