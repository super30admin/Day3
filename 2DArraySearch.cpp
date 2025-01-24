// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        int i = 0;
        int j = m*n -1;
        while(i<=j) {
            int mid = i + (j-i)/2;
            int r = mid/n;
            int c = mid%n;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] > target) j = mid-1;
            else i = mid+1;
        }
        return false;
    }
};