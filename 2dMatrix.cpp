// we need to find the element in a 2d matrix 
// so each row of the matrix is sorted
// if the first integar of each row is greater than the previous  integer it can said the cols are also sorted
// and the last element of the each row is smaller than the first element of the next row as well
// so we can perform the binary search on this matrix to find the target 
// there can be several method to apply the binary search
// 1. we can apply the binary search on each row 
// 2. we can apply the binary search on each row and each col
// 3. we can convert the matrix in single array and apply the binary search
// 4. we can find the way to traverse through matrix as it is a single array
// so for the 4 approach we can start with start = 0 , end = mxn-1 , and mid = (start)+ (end- start)/2;
// but that will be the mid in array , to convert it to matrix coordinaties 
// r_mid = mid / col
// c_mid = mid % col
// 
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        // to search
        int start = 0;
        int end = (matrix[0].size() * matrix.size())-1;
        int col = matrix[0].size();
        while(start <= end)
        {
            int mid = start + (end - start)/2;

            //converting to matrix indexes
            // each col represents first array so we can use modulo to traverse through col lenght
            int c = mid % col;
            // each row reresents nested arrays so we can use divide 
            int r = mid / col;
            if(matrix[r][c]== target)
                return true;
            else if (target < matrix[r][c])
                end = mid -1;
            else
                start = mid + 1;
        }
        return false; 
    }
};