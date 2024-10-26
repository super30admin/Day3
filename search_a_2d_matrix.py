# Time Complexity : O(m + n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : I don;t think its optimal. initially I thought its O (log (mn)) but I think I am wrong here


# Your code here along with comments explaining your approach in three sentences only
# Approach:
# started with the last index of the first row. If the target is greater than selected element, move to the next row to check else move to the left column
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row_idx = 0
        col_idx = len(matrix[0]) - 1
        while (row_idx < len(matrix) and col_idx >= 0):
            if target == matrix[row_idx][col_idx]:
                return True
            elif target < matrix[row_idx][col_idx]:
                col_idx -= 1
            else:
                row_idx += 1
        return False