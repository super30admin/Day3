# // Time Complexity : O(m+n) for traversing each row and and checking one all columns of one row
# // Space Complexity : O(1)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
class Solution:

        
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        
        row = rows-1
        start_y = 0
        end_y = cols-1
        
        while 0 <= row:
            # check if target is present in a row
            if matrix[row][start_y] <= target <= matrix[row][end_y]:
                # traverse the row where taregt might be present
                for j in range(cols):
                    if target == matrix[row][j]:
                        return True
            # keep checking each row
            row -= 1
            
        return False