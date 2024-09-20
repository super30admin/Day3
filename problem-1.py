# Approach
# consider two binary searches one for row and one for column
# first we need to get the row index where target is assumed to present. To achieve this we will search wheather the target is in between the start and end value of mid row
# if the target id less than o index move left and if taget is greater than last index  value of mid row move right.
# once we get the row_index then the column search is similar to 1-dbinary search if target is equal to mid return . if target < mid move left else move right


# Complexities
# Time Complexity: O(log n + log m) where m and n are no of rows and columns.
# space Complexity : O(1) + O(log nm) recursive stack space

from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row_index = self.binarySearch_row(matrix, target, 0, len(matrix) - 1)
        return self.binarySearch_column(matrix, target, 0, len(matrix[0]) - 1, row_index)

    def binarySearch_row(self, matrix, target, low, high):
        if (high - low) > 0:
            mid = int((low + high) / 2)
            if matrix[mid][0] <= target <= matrix[mid][len(matrix[mid]) - 1]:
                return mid
            elif target > matrix[mid][len(matrix[mid]) - 1]:
                return self.binarySearch_row(matrix, target, mid + 1, high)
            else:
                return self.binarySearch_row(matrix, target, low, mid - 1)
        else:
            return high

    def binarySearch_column(self, matrix, target, low, high, row_index):
        if (high - low) > 0:
            mid = int((low + high) / 2)
            if matrix[row_index][mid] == target:
                return True
            elif matrix[row_index][mid] < target:
                return self.binarySearch_column(matrix, target, mid + 1, high, row_index)
            else:
                return self.binarySearch_column(matrix, target, low, mid - 1, row_index)
        else:
            if matrix[row_index][low] == target:
                return True
            return False


