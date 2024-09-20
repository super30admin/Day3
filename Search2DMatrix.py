# Time Complexity : O(log (m*n))
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Trying to understand how binary search works on a matrix


# Your code here along with comments explaining your approach in three sentences only
# -> Find the length of rows and columns
# -> Find the index of target by changing the low and high accordingly using binary search

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = (m*n)-1
        while(low<=high):
            mid = low + (high-low) // 2
            r = mid / n
            c = mid % n
            if (matrix[r][c] == target):
                return True
            elif(matrix[r][c]<=target):
                low = mid + 1 
            else:
                high = mid - 1
        return False

        