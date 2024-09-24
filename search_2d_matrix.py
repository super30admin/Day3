class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # the 2d matrix is visualized as a 1d array

        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m * n) - 1

        while low <= high:
            # finding the middle element of the visualized 1Darray
            mid = low + (high - low) // 2
            # converting the middle element back to its original position in the 2D array
            r = mid / n
            c = mid % n

            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                low = mid + 1
            else:
                high = mid - 1
        return False


# amortized time complexity for the above code is O(log(m*n))
# space complexity is O(1)
