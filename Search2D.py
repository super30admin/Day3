# Time Complexity = O(log m + log n) = O(log m*n)

class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        self.low = 0
        self.high = m*n - 1
        while self.low <= self.high:
            self.mid = int((self.low + self.high) / 2)

            r = int(self.mid / n)
            c = int(self.mid % n)

            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                self.low = self.mid + 1
            else:
                self.high = self.mid - 1

        return False

