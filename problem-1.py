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


