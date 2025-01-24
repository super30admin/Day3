# Time Complexity : O(logn + log m ) => O(logmn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])

        low = 0
        high = m - 1

        # First binary search to find the correct row
        while low <= high:
            mid = low + (high - low) // 2
            if matrix[mid][0] == target:
                return True
            elif matrix[mid][0] < target:
                low = mid + 1
            else:
                high = mid - 1

        # At this point, `high` is the row where the target could be
        row = high
        
        # Second binary search to find the target within the row
        low = 0
        high = n - 1
        while low <= high:
            mid = low + (high - low) // 2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return False
