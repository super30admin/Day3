# Time Complexity : O(log(m*n))
# Space Complexity : O(log(m*n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : difficulty in assigning low and high pointers in the 2D array like took some time to figure that out


# Your code here along with comments explaining your approach in three sentences only

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix) # calculating the number of rows
        cols = len(matrix[0]) # calculating the number of columns

        low = 0
        high = rows * cols - 1

        # performing binary search
        while low <= high:
            mid = (low + high) // 2
            r = mid//cols # calculating rows of the 2D matrix
            c = mid%cols # calculating the columns of the 2D matrix

            if matrix[r][c] == target:
                return True

            elif matrix[r][c] < target:
                low = mid + 1

            else:
                high = mid - 1

        return False
