#Time Complexity := O(log m * n)
#Space Complexity : = O(1)
# Leetcode := Yes
# # approach := imagine 2D matrix as a 1D sorted array and apply binary search, where the mid index is mapped to the 2D coordinates using mid // cols (row) and mid % cols (column).
# Compare the target with the value at the mapped position; if it's smaller, adjust the right pointer; if larger, adjust the left pointer.
# Repeat until the target is found (return True), or the search space is empty (return False).

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        rows = len(matrix)
        cols = len(matrix[0])
        l = 0
        r = rows * cols -1 

        while l <= r:
            mid = (l+r)//2
            row, col = mid // cols, mid % cols
            if target > matrix[row][col]:
                l = mid +1
            elif target < matrix[row][col]:
                r = mid -1
            else:
                return True 
        return False
