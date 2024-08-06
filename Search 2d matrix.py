#// Time Complexity : O(log(MN)) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS=len(matrix)
        COLS=len(matrix[0])
        top=0
        bottom=ROWS-1

        while top<=bottom: # to find correct row.
            rowMid=(top+bottom)//2
            if target>matrix[rowMid][-1]:
                top=rowMid+1
            elif matrix[rowMid][0]>target:
                bottom=rowMid-1 
            else:
                break
        if not (top<=bottom):
            return False
        
        l=0
        r=len(matrix[0])-1
        rowMid=(top+bottom)//2
        while l<=r:
            mid1=(l+r)//2
            if target>matrix[rowMid][mid1]:
                l=mid1+1
            elif target<matrix[rowMid][mid1]:
                r=mid1-1
            else:
                return True
        return False

# Approach:
# The problem can be solved using a binary search approach. The idea is to first find the correct row
# in the matrix where the target element could be present. This is done by comparing the target with the
# first and last elements of the matrix. If the target is greater than the last element of the matrix
# or less than the first element of the matrix, we can discard the entire row. Otherwise, we
# find the correct row by performing a binary search on the rows of the matrix.
# Once we have the correct row, we perform a binary search on the elements of that row to find
# the target element.