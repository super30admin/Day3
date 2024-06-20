// Approach: first we have to find the row in which the target can be. for that, we have to apply bin search to the first column. whenever we get the row head which is less than the target, i update the targetRow and if the next row head is > target, i return the targetRow. then apply binary search in that row. made 2 methods for the 2 types of bin search.
// Time: O(logm+logn)
// Space: O(1)

class Solution {
    bool binSearch(int l, int r, vector<vector<int>>& matrix, int target, int targetRow) {
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(matrix[targetRow][mid] == target) {
                return true;
            }
            else if(matrix[targetRow][mid] < target) {
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return false;
    }

    int colBinSearch(int up, int down, vector<vector<int>>& matrix, int target, int targetRow) {
        while(up <= down) {
            int mid = up + (down-up)/2;
            if(matrix[up][0] > target) {
                    return targetRow;
            }
            if(matrix[mid][0] <= target) {
                targetRow = mid;
                up = mid+1;
                
            }
            
            else {
                down = mid-1;
            }
        }
        return targetRow;
    }
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int m = matrix.size(), n = matrix[0].size();
        if(m == 1) {
            if(n == 1) {
                if(matrix[0][0] == target) {
                    return true;
                }
                return false;
            }
            return binSearch(0, n-1, matrix, target, 0);
        }
        
        
        int targetRow = colBinSearch(0, m-1, matrix, target, -1);

        if (targetRow == -1) {
            return false;
        }
        if(matrix[targetRow][0] == target) {
            return true;
        }
        return binSearch(0, n-1, matrix, target, targetRow);
        
    }
};