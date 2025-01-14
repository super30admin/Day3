
from typing import List
"""
LeetCode 74# : https://leetcode.com/problems/search-a-2d-matrix/description/
Search 2D matrix
"""


"""
Brute Force Approach: I will iterate through all the elements in the array and search for my element K. 
Time Complexity: If the matrix is of size "M" rows and "N" column then, O(MN)
Space Complexity: Constant O(1) because not using any extra space.
"""


class Solution:
    def searchMatrixBruteForce(self, matrix: List[List[int]], target: int) -> bool:

        # Edge case
        if not matrix:
            return False

        no_of_rows = len(matrix)
        no_of_col = len(matrix[0])

        for i in range(no_of_rows):
            for j in range(no_of_col):
                matrix_element = matrix[i][j]
                if matrix_element == target:
                    return True

        # we are out of this loop and there is no target
        return False

    # Further Optimization
    """
    Approach: We can store the elements in set for lookup in O(1) time, this approach will increase our space complexity,
     but further calls to searchMatrix will be in constant time
     Time Complexity: O(MN)
     Space Complexity: O(MN)
    """

    def searchMatrixOptimized(self, matrix: List[List[int]], target: int) -> bool:
        # Edge case
        if not matrix:
            return False

        no_of_rows = len(matrix)
        no_of_col = len(matrix[0])

        my_set = set()
        for i in range(no_of_rows):
            for j in range(no_of_col):
                matrix_element = matrix[i][j]
                my_set.add(matrix_element)

        # return true if target is present in set
        return target in my_set

    # Further Optimization in terms of time complexity
    """
    Approach:  Now we have been given that elements on each row are sorted 
    plus the last element of row is smaller than the first element of next row.
    We can now check the first and last element of the row and determine if we want to perform binary search on that one
    
     Time Complexity: O(M) + O(Log(N) = O(M) always taking larger value
     Space Complexity: O(1) Not using any extra space.
    """

    def binarySerachOnRow(self, matrix: List[List[int]], row_number: int, low: int, high: int, target: int) -> bool:

        # stopping condition for binary search
        if low > high:
            return False

        mid = low + (high - low) // 2

        element_at_mid = matrix[row_number][mid]

        if element_at_mid == target:
            return True
        elif element_at_mid > target:
            # the target should be on left side
            high = mid - 1
            return self.binarySerachOnRow(matrix, row_number, low, high, target)
        else:
            # target is on right side
            low = mid + 1
            return self.binarySerachOnRow(matrix, row_number, low, high, target)

    def searchMatrixOptimized2(self, matrix: List[List[int]], target: int) -> bool:
        # Edge case
        if not matrix:
            return False

        no_of_rows = len(matrix)
        no_of_col = len(matrix[0])

        # iterate the loop number of rows time
        for i in range(no_of_rows):
            first_element_of_row = matrix[i][0]
            last_element_of_row = matrix[i][no_of_col - 1]

            # check if target lies between them
            if first_element_of_row <= target <= last_element_of_row:
                # target is available in this row, perform binary search on ith row
                low = 0
                high = no_of_col - 1
                return self.binarySerachOnRow(matrix, i, low, high, target)

        # outside of this for
        # element must not be there at all
        return False

    # Extremely Further Optimization in terms of time complexity
    """
    Approach: We can do the binary search on 2D matrix with simple math logic. Number of rows and Columns are already given to us.
    lets assume we have a 1D array and based on the index in the 1D array, 
    we can determine at which index the element is present in 2D array.
    lets say the index in 1D array is 8 and we have 3 rows and 4 columns,
    now the element is present at:
    Example :
     matrix = [
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 60]
    ]
    element 23 is at 8th position and 2nd row 0th column [2][0]
    No of row = Index(8) / No of columns 3 = 8/4 = 2nd row
    no of columns = 8 % 4 = 0 th columns 
    Time Complexity: O(log(MN))
    Space Complexity: O(1) Not using any extra space.
    """

    def getPositionMatrix(self, matrix: List[List[int]], index: int) -> tuple:

        noColumn = len(matrix[0])

        row_position = index // noColumn
        col_position = index % noColumn

        return row_position, col_position

    def binarySearch2Dmatrix(self, matrix: List[List[int]], target: int, low: int, high: int) -> bool:

        # stopping condition of binary serach
        if low > high:
            return False

        mid = low + (high - low) // 2

        row, col = self.getPositionMatrix(matrix, mid)

        element_at_mid = matrix[row][col]

        if element_at_mid == target:
            return True
        elif element_at_mid > target:
            # move to the left side
            high = mid - 1
            return self.binarySearch2Dmatrix(matrix, target, low, high)
        else:
            # move right
            low = mid + 1
            return self.binarySearch2Dmatrix(matrix, target, low, high)

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        # edge case
        if not matrix:
            return False

        no_of_rows = len(matrix)
        no_of_column = len(matrix[0])

        low = 0
        high = (no_of_rows * no_of_column) - 1

        return self.binarySearch2Dmatrix(matrix, target, low, high)
