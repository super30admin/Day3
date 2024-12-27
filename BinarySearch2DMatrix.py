# // Time Complexity : O (log (m * n)) 
# // Space Complexity : O (1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : NA

# # // Your code here along with comments explaining your approach in three sentences only
# - using binary search on 2D matrix, calculating the number of rows and columns in the matrix
# - then computing low, mid and high
# - to access the mid element in the matrix, we compute the row and column the mid element is in
# - row is calculated by mid / no_of_columns 
# - then mod id used to compute the index in a row, because the range of index will be 0 to n-1
# - if target is > mid we move right, and if target < mid we move left


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # base case
        if matrix is None or len(matrix) == 0:
            return False
            
        # number of rows
        m = len(matrix)
        # number of columns 
        n = len(matrix[0])
        low = 0 
        # m * n is the number of elements
        high = m * n - 1
        while(low <= high):
            # prevents integer overflow
            mid = low + (high - low) / 2
            # finding the row in which the mid element exits
            row = mid / n
            # finding the column in the row at which mid element exists
            col = mid % n
            # comparing the value mid with target 
            if matrix[row][col] == target:
                # target found
                return True
            elif matrix[row][col] > target:
                # moving left
                high = mid -1
                # moving right
            elif matrix[row][col] < target:
                low = mid + 1

        return False
        