# he matrix is treated as a single sorted array using row-major indexing, where each index maps to matrix[row][col] 
# using pivot_idx // n (row) and pivot_idx % n (column). 
# A binary search is then performed on this "flattened" array to find the target efficiently.
# Time Complexity: O(log(m×n)), as it performs binary search on the flattened matrix.
# Space Complexity: O(1), as no additional data structures are used.
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])

        left, right = 0, m * n - 1
        while left <= right:
            pivot_idx = (left + right) // 2
            pivot_ele = matrix[pivot_idx // n] [pivot_idx % n] 
            if target == pivot_ele:
                return True
            elif target > pivot_ele:
                left = pivot_idx + 1 
            else:
                right = pivot_idx - 1 
        return False