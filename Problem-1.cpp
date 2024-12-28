class Solution
{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target)
    {
        if (matrix.size() == 0)
        {
            return false;
        }

        int m = matrix.size(), n = matrix[0].size();

        int l = 0, h = n * m - 1;
        while (l <= h)
        {
            int mid = l + (h - l) / 2;
            int r = mid / n, c = mid % n;
            if (matrix[r][c] == target)
            {
                return true;
            }

            if (target < matrix[r][c])
            {
                h = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }

        return false;
    }
};