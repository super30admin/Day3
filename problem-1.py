# Time Complexity
# O(log m*n)
# Space Complexity
# O(1)


# Approach :

# Assume the 2d matrix as a single array
# Caluclate the upper bound as matrix length -1
# Calculate the number of elements in a row as matrix[0].length
# To find the mid points coordinates, calculate the mid point value, to find row index, mid point value is divided by the column length, to find column index, mid point value % the column length is done.
# to maintain 0 ( log n) complexity, binary search is performed


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        rowLength = len(matrix)

        if rowLength == 0:
            return False

        colLength = len(matrix[0])

        lastIndex = (rowLength * colLength) - 1
        lowIndex = 0

        while (lowIndex <= lastIndex):

            midElement = (lowIndex + lastIndex) // 2
            midElementRow = midElement // colLength
            midElementCol = midElement % colLength

            if (matrix[midElementRow][midElementCol] == target):
                return True

            elif (target >= matrix[midElementRow][midElementCol]):
                lowIndex = midElement + 1

            else:
                lastIndex = midElement - 1

        return False
