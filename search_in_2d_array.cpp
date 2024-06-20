/*
 *                  Search in a 2D Array
 *
 * Time complexity : O(log [nxm])
 * Space complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : -
 * Your code here along with comments explaining your approach in three sentences only
 *          - Using binary search
 */
#include<iostream>
#include<vector>

using namespace std;

class Solution {
    public:

    bool searchMatrix(vector<std::vector<int> > matrix, int target) {

        int rows = matrix.size();
        int cols = matrix[0].size();

        cout << "Number of rows : " << rows << endl;
        cout << "Number of cols : " << cols << endl;

        int low = 0;

        int high = rows*cols - 1; // Flattened the sorted array into 1-D array and compared the values.
        
        while (low <= high) {
            int mid = low+high/2;

            if(matrix[mid/cols][mid%cols] == target) return true;

            else if(matrix[mid/cols][mid%cols] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;

    }
};

int main() {
    std::vector<std::vector<int> > matrix;
    bool contains = false;

    Solution* obj = new Solution();

    // Initialize each row as a vector
    std::vector<int> row1;
    row1.push_back(1);
    row1.push_back(3);
    row1.push_back(5);
    row1.push_back(7);

    std::vector<int> row2;
    row2.push_back(10);
    row2.push_back(11);
    row2.push_back(16);
    row2.push_back(20);

    std::vector<int> row3;
    row3.push_back(23);
    row3.push_back(30);
    row3.push_back(34);
    row3.push_back(60);

    // Add rows to the matrix
    matrix.push_back(row1);
    matrix.push_back(row2);
    matrix.push_back(row3);

    contains = obj->searchMatrix(matrix, 3);

    cout << contains;

    return 0;
}