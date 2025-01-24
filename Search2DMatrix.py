"""
Search a 2D matrix -

Binary search approach --
TC - O( log(m * n))
SC - O(1)
"""

matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
target = 34


class Solution:
    def searchMatrix(self, matrix, target):
        if matrix is None or len(matrix) == 0: return -1

        row = len(matrix)
        col = len(matrix[0])

        low = 0
        high = (row * col) - 1

        while low <= high:
            mid = low + (high - low) // 2

            r = mid // col
            c = mid % col

            # get mid value for comparison
            midVal = matrix[r][c]

            if midVal == target: return True
            if midVal > target:
                high = mid - 1
            else:
                low = mid + 1
        return False


obj = Solution()
print(obj.searchMatrix(matrix, target))
