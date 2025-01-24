# Time Complexity : O(log (m * n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach in three sentences only

# Treating the Matrix as a 1-Dimensional Array
# we perform BS on it. to get specific r and c we do r = mid//n and c= mid%n
# once we get r and c we make comparisions with the target and decide upon high and low 
# and return true if we find target otherwise return false


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix) # no of rows
        n = len(matrix[0]) # no of columns

        low = 0
        high = m*n -1
        while(low <= high):
            mid = low + (high - low)//2
            r = mid//n # getting the row number
            c = mid%n #column no
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return False

        
