// Time Complexity : O(log(row*column))

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : There were a lot of syntax errors since, 
// I am using c++ after a very long time


 // Your code here along with comments explaining your approach in three sentences only
 // Using the approach thought in class 
 // imagining the 2D matrix as a 1D array and then applying binary search

#include <iostream>
#include <vector>

class Solution {
public:
    bool searchMatrix(std::vector<std::vector<int>>& matrix, int target) {
        int row = matrix.size();
        int column = matrix[0].size();

        int l = 0;
        int h = row * column - 1;
        while (l <= h){
            int mid = l + (h - l)/2;
            int r = mid/column;
            int c = mid%column;

            if (matrix[r][c] == target) return true;
            else{
                if (matrix[r][c] < target) l = mid + 1;
                else h = mid - 1;
            }
        }
        return false;
    }
};

int main(){
    Solution sol = Solution();
    int rows = 3;
    int columns = 4;
    std::vector<std::vector<int>> matrix(rows, std::vector<int>(columns, 0));

    // Optional: Print the matrix to verify
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < columns; ++j) {
            matrix[i][j] = i*j;
        }
    }
    bool result = sol.searchMatrix(matrix, 4);
    std::cout <<"True  Result case output: "<< result << std::endl;

    result = sol.searchMatrix(matrix, 400);
    std::cout <<"False Result case output: "<< result << std::endl;
    return 0;
}