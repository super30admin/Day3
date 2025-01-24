# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

# Time Complexity: O(log(m*n)) or O(log(m) + log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# Use binary search on the 2D matrix treated as a 1D array. 
# Convert the mid index to row and column indices to access the matrix elements. 
# Adjust the search range based on comparisons until the target is found or the range is exhausted.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m,n = len(matrix), len(matrix[0])
        low,high = 0, m*n-1
        while low <= high:
            mid = low + (high-low)//2
            row = mid//n
            col = mid%n
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                high = mid-1
            else:
                low = mid + 1

        return False

        
