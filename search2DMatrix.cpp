// Time Complexity : O(log(m*n)) where m be rows and n be columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*Performed binary search on 2D matrix.
Without flatening it into 1-D array.
*/
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size()==0){
            return false;
        }
        int noOfRows = matrix.size();
        int noOfCol = matrix[0].size();
        
        int low =0;
        int high = noOfRows * noOfCol-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int midRow = mid/ noOfCol;
            int midColumn = mid% noOfCol;

            if(matrix[midRow][midColumn]== target){
                return true;
            }
            else if(matrix[midRow][midColumn] > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
};