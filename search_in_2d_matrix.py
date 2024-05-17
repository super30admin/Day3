"""
Binary-Search-1
Problem1
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

Time Complexity : O(logm*n)
Space Complexity :  O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
In this 2d array we're trying to apply binary search since it's similar to a single array of mxn elements in a matrix so inorder to find row and column index
we have to use // n for row and % n for col on the mid index and we apply the binary search on it and same process is repeated until low <= high.  
"""

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or len(matrix) == 0:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1
        
        while low <= high:
            mid = low + ((high - low) // 2 ) # we're doing this to handle integer overflow which can happen in C, C++ and Java.
            row = mid // n
            col = mid % n

            if matrix[row][col] == target:
                return True
            elif target > matrix[row][col]:
                low = mid + 1
            else:
                high = mid - 1

        return False

        
