class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        if (rows == 0) return false;
        int cols = matrix[0].size();
        
        // Using Flattened Array
        int left = 0, right = (rows * cols) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / cols][mid % cols]; // matrix[row][col];
            
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
};