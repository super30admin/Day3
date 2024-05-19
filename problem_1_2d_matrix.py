# Time complexity O(log m*n)
# space complexity O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix and not matrix[0]:
            return False
        m = len(matrix) # row 
        n = len(matrix[0]) # col 
        low = 0 
        high = m*n - 1 
        while low <= high:
            mid = low + (high - low) // 2 
            row = mid // n 
            col = mid % n 
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                high = mid - 1
            else:
                low = mid + 1 
        return False
        