# Binary-Search-1

## Problem1 : Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

# Approach
# Get row and column count of the 2D matrix. Based on that get mid which is the middle element of the 2D Matrix
# Since our mid is for a 1D array, we need to get the row & column for the 2D array. 
# if our matrix[row][column] is equal to target, return True, else if mid > target then set high = mid-1 and if mid < target set low = mid+1. If target not found, return False  

# Time Complexity : O(log m*n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n -1

        while(low<=high):
            mid = low + (high-low)//2
            r = mid//n
            c = mid %n
            if matrix[r][c] == target:
                return True
            if matrix[r][c] > target:
                high = mid -1
            else:
                low = mid + 1
        return False
        