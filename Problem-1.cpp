// Time Complexity : O(log m*n): m*n is the size of given matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Learned a bit more about C++ vector and its functions: push_back(), at(), 
//                                           vector iterators: begin, end


// Your code here along with comments explaining your approach
class Solution {

    vector<int> convert1DIndexto2D(int one_d_index, int n) {
        vector<int> two_d_index;
        two_d_index.push_back(one_d_index / n);
        two_d_index.push_back(one_d_index % n);
        return two_d_index;
    }

public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            vector<int> two_d_index = convert1DIndexto2D(mid, n);
            int row = two_d_index[0];
            int col = two_d_index[1];
            
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
};