# Time Complexity : O(logm + logn)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

"""
I will be using binary search twice:
Firstly to find the correct row
 If target is in the mid-row: return mid as the correct row
 If target is > last element of mid-row, discard the top half of the matrix, else discard the bottom half

Secondly to find if the target is there in the correct row
 If the target == mid, return True
 If target > mid, discard the left side of that row, else discard the right side
"""


def findRow(matrix, target):
    m = len(matrix)
    n = len(matrix[0])
    low = 0
    high = m - 1

    while low <= high:
        mid = low + (high - low) // 2
        if matrix[mid][0] <= target <= matrix[mid][n - 1]:
            return mid
        elif target > matrix[mid][n - 1]:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def searchMatrix(matrix, target):
    """
    :type matrix: List[List[int]]
    :type target: int
    :rtype: bool
    """
    if len(matrix) == 0:
        return False

    # find the correct row
    row = findRow(matrix, target)

    # if target not found in any of the rows
    if row == -1:
        return False
    # if correct row found for the target
    else:
        low = 0
        high = len(matrix[0]) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if matrix[row][mid] == target:
                return True
            elif target > matrix[row][mid]:
                low = mid + 1
            else:
                high = mid - 1
        return False

print(searchMatrix([[1,2,3],[4,5,6],[7,8,9]], 12))

