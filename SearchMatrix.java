/*
Time Complexity:
    Let m be the number of rows in the matrix.
    Let n be the number of columns in the matrix.
    The matrix is searched using binary search. The search space is m * n (all elements in the matrix).
    Time Complexity Analysis:

    In each iteration of the while loop, you reduce the search space by half, making it a classic binary search.
    The time complexity of binary search is O(log(m⋅n)).
    Since log(m * n) can also be expressed as O(logm+logn), the complexity remains O(log(m⋅n)).

    Therefore, the time complexity is O(log(m⋅n)).

Space Complexity:
    The space complexity is determined by the additional memory usage that the algorithm requires.

    In this case, you are only using a few integer variables (low, high, mid, row, column), regardless of the size of the matrix.
    No additional data structures (like arrays, lists, or stacks) are used that depend on the size of the input.
    Therefore, the space complexity is O(1) (constant space).

Did this code successfully run on Leetcode : Yes
 */

class SearchMatrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int m = matrix.length; //Size of row
        int n = matrix[0].length; //Size of column

        int low = 0, high = m*n - 1; //high is calculated if we imagine the matrix to be a linear array so high is n-1, but this is a matrix so m*n-1.

        while(low<=high)
        {
            int mid = low + ((high-low)/2);
            int row = mid/n;
            int column = mid%n;

            if(matrix[row][column] ==  target) {
                return true;
            }
            else if(matrix[row][column] >  target) { //if element on this index is greater than the target, we move the high pointer
                high = mid - 1;
            }
            else {
                low = mid + 1; //if element on this index is less than the target, we move the low pointer
            }
        }

        return false; //target not found
    }
}
