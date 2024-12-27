// Time Complexity : O(log m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : yes error due to confusion between midelement and midpoint


// Your code here along with comments explaining your approach in three sentences only
class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length  ==  0){
            return  false;
        }
        int rows  = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int  right = rows*columns-1;

        //Binary search
        while(left<=right){
            int midpoint = left + (right-left)/2;
            int mid_element = matrix[midpoint/columns][midpoint%columns];
            if(target  == mid_element){
                return true;
            }else if(target<mid_element) {
                right = midpoint -1;
            }else if(target>mid_element){
                left = midpoint+1;
            }
        }
        return false;
    }
}