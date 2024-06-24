# Time complexity: O(logm + logn)
# Space complexity: O(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False 
        m = len(matrix) # number of rows
        n = len(matrix[0]) # number of columns

        # binary search on row
        top = 0
        bottom = m-1
        while top <= bottom:
            mid = (top+bottom)//2
            if matrix[mid][0] <= target <= matrix[mid][-1]:
                left = 0
                right = n-1
                while left <= right:
                    mid1 = (left+right)//2
                    if matrix[mid][mid1] == target:
                        return True
                    elif matrix[mid][mid1] < target:
                        left = mid1+1
                    else:
                        right = mid1-1
                return False

            elif target < matrix[mid][0]:
                bottom = mid-1
            else:
                top = mid + 1
        return False
        