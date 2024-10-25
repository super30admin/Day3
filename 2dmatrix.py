# The code defines a searchMatrix method to locate a target value within a 2D matrix.
# The matrix has sorted properties: each row is sorted from left to right, and the last element of each row is less than or equal to the first element of the next row.
# 
# The search is conducted in two phases:
# 1. Locate the correct row where the target might be present:
#    - Two pointers, 'top' and 'bot', represent the range of rows to consider.
#    - A binary search is performed over the rows:
#       - If the target is greater than the last element of the current row (matrix[row][-1]), the search moves down by setting top = row + 1.
#       - If the target is less than the first element of the current row (matrix[row][0]), the search moves up by setting bot = row - 1.
#       - If the target is within the current row range, we break out to proceed with a search within this row.
#    - If no such row is found, the method returns False, as the target is not in the matrix.
# 
# 2. Perform binary search within the identified row:
#    - Two pointers, 'l' and 'r', define the search range within the row.
#    - If matrix[row][m] (mid-point element) equals the target, True is returned.
#    - If matrix[row][m] is less than the target, l is updated to m + 1 to search the right half of the row.
#    - If matrix[row][m] is greater than the target, r is updated to m - 1 to search the left half of the row.
# If the target is not found after both searches, the method returns False.
# 
# TC: O(log m + log n) - Binary search over rows (log m) and columns (log n).
# SC: O(1) - Constant space is used, as only pointers are maintained for each binary search step.


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])

        top, bot = 0, ROWS - 1
        while top <= bot:
            row = (top + bot) // 2
            if target > matrix[row][-1]:
                top = row + 1
            elif target < matrix[row][0]:
                bot = row - 1
            else:
                break

        if not (top <= bot):
            return False
        row = (top + bot) // 2
        l, r = 0, COLS - 1
        while l <= r:
            m = (l + r) // 2
            if target > matrix[row][m]:
                l = m + 1
            elif target < matrix[row][m]:
                r = m - 1
            else:
                return True
        return False
