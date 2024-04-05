// Time Complexity : O(log m + log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
   bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        
        int low =0; int high = m*n-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            int r = mid/n;
            int c = mid %n;
            if (matrix[r][c] == target) return true; 
            if(matrix[r][c] > target){
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return false;
        
    }
};
