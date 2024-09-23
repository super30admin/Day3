class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        columns = len(matrix[0])
        top = 0
        bottom = len(matrix) - 1
        
        while top <= bottom:
            mid = (top + bottom) // 2
            if target < matrix[mid][0]:
                bottom -= 1
            elif target > matrix[mid][- 1]:
                top += 1
            else:
                break
                
        if not (top <= bottom):
            return False
        
        l = 0
        r = columns -1
        while l <= r:
            m = (l + r) //2
            if target < matrix[mid][m]:
                r -= 1
            elif target > matrix[mid][m]:
                l += 1
            else:
                return True
        return False
            