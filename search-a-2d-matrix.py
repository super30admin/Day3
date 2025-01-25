#Time complexity: O(log m + log n )
#Space complexity O(n)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[-1])
        isPresent = False
        matchingRow = 0
        low = 0 
        high = m-1
        while low <= high:
            mid = low + (high - low) // 2
            if matrix[mid][0] <= target <= matrix[mid][n-1]:
                matchingRow = mid
                break
            if target < matrix[mid][0]:
                high = mid - 1
            else:
                low = mid + 1
        
        low = 0
        high = n-1
        while low <= high:
            mid = low + (high - low) // 2
            if matrix[matchingRow][mid] == target:
                isPresent = True
                break
            if target < matrix[matchingRow][mid]:
                high = mid - 1
            else:
                low = mid + 1
        return isPresent
