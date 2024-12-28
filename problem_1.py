#  Time Complexity: O(log(m*n)) where m is the number of rows and n is the number of columns
#  Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach 
# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/) 
# Approach
# I am considering the 2D matrix as a 1D array and applying binary search on it.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        left = 0 
        right = m*n -1 
        while left <= right:
            pivot_index = left + ( right- left)//2
            row = pivot_index // n
            col = pivot_index % n
            pivot_element = matrix[row][col]
            
            if pivot_element == target:
                return True 
            elif (target < pivot_element):
                right = pivot_index -1 
            else:
                left = pivot_index + 1
        return False
                