class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        low, high = 0, rows * cols - 1

        while low <= high:
            mid = (low + high)//2
            i = mid // cols
            j = mid % cols
            if matrix[i][j] == target:
                return True
            elif target < matrix[i][j]:
                high = mid - 1
            else:
                low = mid + 1
        return False 

            