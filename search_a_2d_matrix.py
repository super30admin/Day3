# Time Complexity : O(log(m * n))
# Space Complexity : Constant
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach 
# get the first and last idx (row,col) of the input matrix and find the middle element by dividing and taking a modulus of the number of columns
# use binary search and determine if the target element is present or not 

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0  or matrix==None:
            return False

        n = len(matrix[0])
        low = 0
        high = m*n-1
        while low <= high:
            mid = (low+high)//2
            row = mid//n
            col = mid%n

            if matrix[row][col] == target:
                return True
            elif (target >= matrix[row][col]):
                low = mid+1
            else:
                high = mid-1
        return False