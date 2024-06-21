from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row, column = len(matrix), len(matrix[0])
        l = 0
        h = row * column - 1
        while l <= h:
            mid = l + (h-l)//2
            r = mid//column
            c = mid%column
            if matrix[r][c] == target: 
                return True
            else:
                if matrix[r][c] < target:
                    l = mid + 1
                else:
                    h = mid - 1
        return False

if __name__ == "__main__":
    row = 3
    col = 4
    matrix = [[0] * col]*row
    for i in range(row):
        for j in range(col):
            matrix[i][j] = i*j
    
    sol = Solution()
    res = sol.searchMatrix(matrix, 4)
    print(f"True case result: {res}")

    res = sol.searchMatrix(matrix, 400)
    print(f"False case result: {res}")
