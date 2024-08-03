class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        # Solution 1 -> Zig-zag Traversal starting from first row last el(0,..)
        row = 0
        col = len(matrix[0]) - 1
        print(row, col)

        while (row < len(matrix) and row >= 0 and col >= 0 and col < len(matrix[0])):
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                row += 1
            else:
                col -= 1

        return False

# Solution 2 -> Binary search on row or column and then linear on other - m + log(n) or n + log(m)
