"""
// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes. (#74)
// Any problem you faced while coding this : No.
"""

from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m*n) - 1
        while low <= high:
            mid = ( low + high ) // 2
            row = mid // n
            col = mid % n
            if  matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                high = mid - 1
            else:
                low = mid + 1

        return False


matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
sol = Solution()
print("found target", sol.searchMatrix(matrix,20))
print("found target", sol.searchMatrix(matrix,22))