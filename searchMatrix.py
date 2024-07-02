class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Check if matrix is empty or None
        if len(matrix) == 0 or matrix[0] == None:
            return False
        
        # Get number of rows and columns in the matrix
        rows = len(matrix)
        cols = len(matrix[0])
        
        # Initialize start and end pointers for binary search
        start = 0
        end = rows * cols - 1
        
        # Perform binary search
        while start <= end:
            mid = start + (end - start) // 2  # Calculate middle index
            row = mid // cols  # Calculate row index from flattened index
            col = mid % cols   # Calculate column index from flattened index
            
            if matrix[row][col] == target:  # Target found
                return True
            elif matrix[row][col] > target:  # Target is in the left half
                end = mid - 1
            else:  # Target is in the right half
                start = mid + 1
        
        # Target not found
        return False
sol = Solution()

# Example matrix
matrix = [
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 60]
]

target = 3
print(sol.searchMatrix(matrix, target))  # Output: True

target = 13
print(sol.searchMatrix(matrix, target))  # Output: False
