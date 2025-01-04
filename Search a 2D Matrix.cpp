// Time Complexity : O(log m * n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// consider it as a sorted 1D matrix, now calculate row & col for finding & apply Binary Search
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size() == 0) return false;
        int m = matrix.size();
        int n = matrix[0].size();
        int low = 0;
        int high = (m * n) - 1; 
        while(low <= high) {
            int mid = (high - low) / 2 + low; // to prevent overflow
            int row = mid / n; // to calculate row, divide by col (size n)
            int col = mid % n; // to calculate col, mod by col (size n)
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
};