"""
Imagine 2d matrix as a 1D array, where we need to handle indices to help visualize
TC - O(log(M.N))
SC - O(1)

Approach:

Treat matrix as list, where each element is a list.
Get m and n (row and column range of indices for matrix)
set low pointer to 0, high to max index mn-1.
Treat matrix as a list of mn length, use Binary search.
for mid convert to corresponding matrix row and column iindex, check against target , if not move left or right.
"""


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low  = 0
        high = m * n - 1
        while low <= high:
            mid = low + (high - low ) // 2
            r = mid // n
            c = mid % n
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
