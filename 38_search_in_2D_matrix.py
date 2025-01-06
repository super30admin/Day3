# Time complexity - O(log mn) # considering 2D matrix to 1D array and applying binary search
# Space complexity - O(1) / O(mn) if input matrix included

from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = m * n - 1

        while low <= high:
            mid = low + ((high - low) // 2)
            row = mid // n
            col = mid % n

            if matrix[row][col] == target:
                return True
            
            if matrix[row][col] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return False