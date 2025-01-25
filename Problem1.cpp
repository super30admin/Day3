// Search a 2D Matrix

//Time Complexity: O(log(m*n))
//Space Complexity: O(1)
// Code ran successfully on leetcode
// Approach: 

// Flattened 2D array as 1D array. Used the mid to calculate row index and column index needed for middleElement. 
// Used Binary Search to then check for target

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = matrix.size();
        int col = matrix[0].size();
        int low = 0; 
        int high = (row * col) - 1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int row_index = mid / col;
            int col_index = mid % col;
            int middleElement = matrix[row_index][col_index];

            if(middleElement == target){
                return true;
            }
            else if(middleElement < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
};