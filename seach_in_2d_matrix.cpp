// Time Complexity : O(log M*N).
// Space Complexity : O(1). We are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int low = 0;
        int high = (matrix.size() * matrix[0].size()) - 1;

        int column_size = matrix[0].size();
        // assuming 2d matrix to be 1d matrix
        while(low <= high)
        {
            int mid = low + ((high - low)/2);

            // get value from 2d matrix
            int row = mid/column_size;
            int col = mid%column_size;

            int mid_val = matrix[row][col];

            if(mid_val == target)
            {
                return true;
            }

            if(mid_val < target)
            {
                // move low pointer
                low = mid + 1;
            }
            else
            {
                // move high pointer
                high = mid-1;
            }
            
        }
        return false;
    }
};