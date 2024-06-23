# Time Complexity: O(logmn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No
class Solution(object):
    def searchMatrix(self, matrix, target):
        # imaginary unfold 2D matrix to 1D
        m = len(matrix) # row length
        n = len(matrix[0]) # column length
        low = 0
        high = (m * n) - 1
        while low <= high:
            mid = low + (high - low) // 2
            row = mid / n
            col = mid % n
            if target == matrix[row][col]:
                return True
            elif target > matrix[row][col]:
                low = mid + 1
            else:
                high = mid - 1
        return False