"""
Problem 1: Search a 2D Matrix
Time Complexity: O(log m*n)
Space Complexity: O(1)
The code initializes the low and high pointers to the start and end of the matrix, respectively.
It then calculates the mid index and the corresponding row and column indices.
The code checks if the element at the mid index is equal to the target.
If the element is equal to the target, it returns True.
If the element is greater than the target, it updates the high pointer to mid - 1.
If the element is less than the target, it updates the low pointer to mid + 1.
The code continues this process until the low pointer exceeds the high pointer or the target element is found.
"""
from typing import List


def searchMatrix(matrix: List[List[int]], target: int) -> bool:
    if not matrix or len(matrix) == 0:
        return False

    m = len(matrix)
    n = len(matrix[0])
    low = 0
    high = m * n - 1

    while low <= high:
        mid = low + (high - low) // 2
        row = mid // n
        col = mid % n
        if matrix[row][col] == target:
            return True
        elif matrix[row][col] > target:
            high = mid - 1
        else:
            low = mid + 1

    return False


searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3) # Output: True

