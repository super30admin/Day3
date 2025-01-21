"""

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Time Complexity : O(log(mn))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# The approach treats the 2D matrix as a flattened sorted array and applies binary search.  
# The mid index is mapped back to the 2D matrix using row = mid // n and col = mid % n.  
# If the target is found, return True; otherwise, adjust the search range until left > right.  


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        m, n = len(matrix), len(matrix[0])

        left, right = 0, m * n - 1

        while left <= right:
            mid = (left+right) // 2
            pivot = matrix[mid // n][mid % n]
            
            if pivot == target:
                return True
            else:
                if pivot > target:
                    right = mid - 1
                else:
                    left = mid + 1
        
        return False
