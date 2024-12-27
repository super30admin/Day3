// Author: Subhed Chavan
// Batch: December 24
// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

class Solution
{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target)
    {
        // Check for case where empty array is passed and no search is required.
        if (matrix.empty() || matrix[0].empty())
        {
            return false;
        }

        int m = matrix.size();
        int n = matrix[0].size();

        // Get low and high for traversal
        int low = 0;
        int high = (m * n) - 1;

        // Loop with case where Binary Search fails or should be exited
        while (low <= high)
        {
            // Find mid
            int mid = low + (high - low) / 2;

            // Getting row and column to access the mid based on the formula provided
            // Used mod for col to get the col in the range
            int row = mid / n;
            int col = mid % n;

            // Check for target
            if (matrix[row][col] == target)
            {
                return true;
            }
            // Check if the target lies in the left half
            else if (target < matrix[row][col])
            {
                high = mid - 1;
            }
            // If not, then should exist in the right half based on the comparison
            else
            {
                low = mid + 1;
            }
        }

        return false;
    }
};
