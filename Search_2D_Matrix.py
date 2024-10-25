# Time Complexity : O(log(m * n)) where m is the number of rows and n is the number of columns
# Space Complexity : O(1) since we are not using any extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Treat the 2D matrix as a 1D sorted array using binary search
        m, n = len(matrix), len(matrix[0])  # Get the number of rows and columns
        left, right = 0, m * n - 1  # Set binary search boundaries

        while left <= right:
            mid = (left + right) // 2  # Find the middle index
            # Convert the 1D index to 2D matrix coordinates
            row, col = divmod(mid, n)  # divmod returns (quotient, remainder)
            mid_element = matrix[row][col]

            if mid_element == target:  # Check if the mid element is the target
                return True
            elif mid_element < target:  # If the target is greater, move right
                left = mid + 1
            else:  # If the target is smaller, move left
                right = mid - 1

        return False  # Return False if the target is not found
